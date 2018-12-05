package galaxy.tec.poiData;
import galaxy.tec.poiData.bean.Area;
import galaxy.tec.poiData.bean.Point;
import galaxy.tec.poiData.bean.Rectangle;
import galaxy.tec.poiData.netconst.URLUtils;
import galaxy.tec.poiData.bean.PoiModel;

import net.sf.json.JSONObject;
import galaxy.tec.poiData.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;

import static galaxy.tec.poiData.netconst.URLUtils.sendURLWithParams;
import static galaxy.tec.poiData.netconst.URLUtils.KEY;

/**
 * 
 */

public class GetDatas {
    //    public static final String keyword = "药店";
    public static final String keyword = "酒店";
    
   /* 高德地图申请的开发key*/
//    public static final String key = "ab01a8664a1d2fe7c9bd4d5172d9fde2";
    
//    public static String poiUrl = "http://api.map.baidu.com/place/v2/search";
   
//    高德地图行政区域查询API的URL
    public static String poiUrl = "https://restapi.amap.com/v3/place/polygon";
    
    public static final int OFFSET = 20;

    public static int total_count = 0;
    
//    public static String subdistrict = "3";


    public static void getByBounds(Rectangle rectangle) {
        if (rectangle == null) return;

        Point lt = rectangle.leftTop;
        Point rb = rectangle.rightBottom;
//        百度地图是纬度经度，高德是经纬度
        String leftbottom = lt.longitude + "," + lt.latitude;//先经度，再纬度
        String righttop = rb.longitude + "," + rb.latitude;//先经度，再纬度

        int currentPageIndex = 1;
        String poiParam = "?keywords=" + keyword + "&offset="+OFFSET+"&polygon=" + leftbottom + "|" + righttop + "&page=" + currentPageIndex+"&output=json&key="+URLUtils.KEY;


        String result = sendURLWithParams(poiUrl + poiParam);

        JSONObject poiJsonroot = JSONObject.fromObject(result);

        int count = poiJsonroot.getInt("count");
        System.out.println("当前区域 ----->" + rectangle);
        if (count >= 1000) {
//                四分法切片，切片后进入递归
            double half_long = (lt.longitude + rb.longitude) / 2;
            double half_lat = (lt.latitude + rb.latitude) / 2;

//            新规划出的5个点，
            Point centerPoint = new Point(half_long, half_lat);//中心点，

            Point p1 = new Point(lt.longitude, half_lat);//左中
            Point p2 = new Point(half_long, rb.latitude);//中上
            Point p3 = new Point(half_long, lt.latitude);//中下
            Point p4 = new Point(rb.longitude, half_lat);//右中


            //4分法递归 防止区域划分过于狭长
//            getByBounds(new Rectangle(rectangle.currentAreaName, lb, centerPoint));
//            getByBounds(new Rectangle(rectangle.currentAreaName, centerPoint, rt));
//            getByBounds(new Rectangle(rectangle.currentAreaName, p1, p2));
//            getByBounds(new Rectangle(rectangle.currentAreaName, p3, p4));

            galaxy.tec.poiData.bean.Rectangle r1 = new galaxy.tec.poiData.bean.Rectangle(rectangle.currentAreaName, lt, p4);
            galaxy.tec.poiData.bean.Rectangle r2 = new galaxy.tec.poiData.bean.Rectangle(rectangle.currentAreaName, p1, rb);
////
            getByBounds(r1);
            getByBounds(r2);

        } else {


            //进入数采集，
            int pages = 0;
            if (count % OFFSET == 0) {
                pages = count / OFFSET;
            } else {
                pages = count / OFFSET + 1;
            }
            List<PoiModel> storeModelList = new ArrayList<PoiModel>(20);

            System.out.println("**************当前切片区域总数 " + count + "     分页数{" + pages + "}     currentPageIndex" + currentPageIndex + "  " + rectangle.toString());

            for (int i = 0; i < pages; i++) {
                String pageparam = "?keywords=" + keyword + "&key=" + KEY + "&offset=20&polygon=" + leftbottom + "," + righttop + "&page=" + currentPageIndex;
                currentPageIndex++;//开始第二页的请求
                String r = sendURLWithParams(poiUrl + pageparam);
                JSONObject page = JSONObject.fromObject(r);

                addPageData(page, storeModelList, rectangle.currentAreaName);
            }
            //先保存数据
            FileUtils.writeIntoCSV(storeModelList);
            storeModelList.clear();
            storeModelList = null;
            currentPageIndex = 0;//set as default.
        }
    }

    public static void addPageData(JSONObject page, List<PoiModel> storeModelList, String currentAreaName) {

    	System.out.println("=====");
        List<JSONObject> stores = page.getJSONArray("results");
        for (int k = 0; k < stores.size(); k++) {
            PoiModel storeModel = new PoiModel();
            if (stores.get(k).containsKey("name")) {
                storeModel.storeName = stores.get(k).getString("name");
            }

            if (stores.get(k).containsKey("location") && stores.get(k).getJSONObject("location").containsKey("lng") && stores.get(k).getJSONObject("location").containsKey("lat")) {
                storeModel.longitude = stores.get(k).getJSONObject("location").getString("lng");
                storeModel.latitude = stores.get(k).getJSONObject("location").getString("lat");
                Area area = getDistinct(storeModel.latitude, storeModel.longitude);

                if (area == null || !area.province.equals(Area.SHENZHEN)) {//不属于深圳地区的
//                if (area == null || !area.country.equals(Area.CHINA) || !area.province.equals(Area.XINJIANG)||!area.city.equals(WLMQ)) {//不属于深圳
                    System.out.println("非深圳地区   ****      " + area.toString() + storeModel.longitude + " , " + storeModel.latitude);
//                if (area == null || !area.country.equals(Area.CHINA) || !area.province.equals(Area.XINJIANG) || !area.city.equals(Area.WLMQ)) {//不属于深圳
                    continue;
                }

                storeModel.areaInfo = area;

                if (area.formatted_address.length() == 0) {
                    storeModel.formatted_address = currentAreaName;
                } else {
                    storeModel.formatted_address = area.formatted_address;
                }
            }

//            if (stores.get(k).containsKey("address")) {
//                storeModel.address = stores.get(k).getString("address");
//            }


            storeModelList.add(storeModel);
            System.out.println("总计数： " + (total_count++) + "     " + storeModel.toString());
        }

    }

    /**
     * 获取行政区域区域信息
     *
     * @param latitude
     * @param longtitude
     * @return
     */
    public static Area getDistinct(String latitude, String longtitude) {
        String url = URLUtils.geoCodeReversURL(latitude, longtitude);
        String r = sendURLWithParams(url);
        JSONObject page = JSONObject.fromObject(r);

        if (page == null) return null;

        Area result = new Area();
        JSONObject object = page.getJSONObject("result");

        if (object == null) return null;

        result.formatted_address = object.getString("formatted_address");

        if (object.containsKey("addressComponent")) {

            result.country = object.getJSONObject("addressComponent").getString("country");
            result.province = object.getJSONObject("addressComponent").getString("province");//目前只需筛选到省，自治区
            result.city = object.getJSONObject("addressComponent").getString("city");//目前只需筛选到省，自治区
            result.district = object.getJSONObject("addressComponent").getString("district");//
            result.town = object.getJSONObject("addressComponent").getString("town");//
            result.street = object.getJSONObject("addressComponent").getString("street");//
            result.street_number = object.getJSONObject("addressComponent").getString("street_number");//

        }

        return result;
    }


}