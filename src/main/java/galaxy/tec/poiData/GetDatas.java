package galaxy.tec.poiData;
import galaxy.tec.poiData.bean.Area;
import galaxy.tec.poiData.bean.Point;
import galaxy.tec.poiData.bean.Rectangle;
import galaxy.tec.poiData.netconst.URLUtils;
import galaxy.tec.poiData.bean.PoiModel;

import net.sf.json.JSONObject;
import galaxy.tec.poiData.utils.FileUtils;
import galaxy.tec.poiData.utils.JDBCOpreation;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;

import static galaxy.tec.poiData.netconst.URLUtils.sendURLWithParams;
import static galaxy.tec.poiData.netconst.URLUtils.KEY;

/**
 * 
 */

public class GetDatas {
	
//	 String[] typeList = typesListString.split("\\|");
	
	public static void main(String[] args) {
//		String[] liString = typesListString.split("\\|");
//		for (int i = 0; i < liString.length; i++) {
//			System.out.println(liString[i]);
//		}
		
		String testURL = "https://restapi.amap.com/v3/place/polygon?&offset=20&polygon=113.751453,22.861748|113.951453,22.8601855";
		for (int i = 0; i < types.split("\\|").length; i++) {
			System.out.println("i"+types.split("\\|")[i]);
			String re = sendURLWithParams(testURL+"&page=1"+"&key="+KEY+"&types="+types.split("\\|")[i]);
			System.out.println(re);
		}
		
				
	}
	
	
    JDBCOpreation jdbcOpreation = new JDBCOpreation();
    
    public static final String types1 = "120100";//产业园区
    
//    public static final String types = "120100|090300";//产业园区 和诊所
    
    	public static String types = "010000|010100|010101|010102|010103|010104|010105|010107|010108|010109|010110|010111|010112|010200|010300|010400|" +
                "010401|010500|010600|010700|010800|010900|010901|011000|011100|020000|020100|020101|020102|020103|020104|" +
                "020105|020106|020200|020201|020202|020203|020300|020301|020400|020401|020402|020403|020404|020405|020406|" +
                "020407|020408|020600|020601|020602|020700|020701|020702|020703|020800|020900|020904|020905|021000|021001|" +
                "021002|021003|021004|021100|021200|021201|021202|021203|021300|021301|021400|021401|021500|021501|021600|" +
                "021601|021602|021700|021701|021702|021800|021802|021803|021804|021900|022000|022100|022200|022300|022301|" +
                "022400|022500|022501|022502|022600|022700|022800|022900|023000|023100|023200|023300|023301|023400|023500|" +
                "025000|025100|025200|025300|025400|025500|025600|025700|025800|025900|026000|026100|026200|026300|029900|" +
                "030000|030100|030200|030201|030202|030203|030204|030205|030206|030300|030301|030302|030303|030400|030401|" +
                "030500|030501|030502|030503|030504|030505|030506|030507|030508|030700|030701|030702|030800|030801|030802|" +
                "030803|030900|031000|031004|031005|031100|031101|031102|031103|031104|031200|031300|031301|031302|031303|" +
                "031400|031401|031500|031501|031600|031601|031700|031701|031702|031800|031801|031802|031900|031902|031903|" +
                "031904|032000|032100|032200|032300|032400|032401|032500|032600|032601|032602|032700|032800|032900|033000|" +
                "033100|033200|033300|033400|033401|033500|033600|035000|035100|035200|035300|035400|035500|035600|035700|" +
                "035800|035900|036000|036100|036200|036300|039900|040000|040100|040101|040200|040201|050000|050100|050101|" +
                "050102|050103|050104|050105|050106|050107|050108|050109|050110|050111|050112|050113|050114|050115|050116|" +
                "050117|050118|050119|050120|050121|050122|050123|050200|050201|050202|050203|050204|050205|050206|050207|" +
                "050208|050209|050210|050211|050212|050213|050214|050215|050216|050217|050300|050301|050302|050303|050304|" +
                "050305|050306|050307|050308|050309|050310|050311|050400|050500|050501|050502|050503|050504|050600|050700|" +
                "050800|050900|060000|060100|060101|060102|060103|060200|060201|060202|060300|060301|060302|060303|060304|" +
                "060305|060306|060307|060308|060400|060401|060402|060403|060404|060405|060406|060407|060408|060409|060411|" +
                "060413|060414|060415|060500|060501|060502|060600|060601|060602|060603|060604|060605|060606|060700|060701|" +
                "060702|060703|060704|060705|060706|060800|060900|060901|060902|060903|060904|060905|060906|060907|061000|" +
                "061001|061100|061101|061102|061103|061104|061200|061201|061202|061203|061204|061205|061206|061207|061208|" +
                "061209|061210|061211|061212|061213|061214|061300|061301|061302|061400|061401|070000|070100|070200|070201|" +
                "070202|070203|070300|070301|070302|070303|070304|070305|070306|070400|070401|070500|070501|070600|070601|" +
                "070603|070604|070605|070606|070607|070608|070609|070610|070700|070701|070702|070703|070704|070705|070706|" +
                "070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071801|071900|071901|071902|" +
                "071903|072000|072001|080000|080100|080101|080102|080103|080104|080105|080106|080107|080108|080109|080110|" +
                "080111|080112|080113|080114|080115|080116|080117|080118|080119|080200|080201|080202|080300|080301|080302|" +
                "080303|080304|080305|080306|080307|080308|080400|080401|080402|080500|080501|080502|080503|080504|080505|" +
                "080600|080601|080602|080603|090000|090100|090101|090102|090200|090201|090202|090203|090204|090205|090206|" +
                "090207|090208|090209|090210|090211|090300|090400|090500|090600|090601|090602|090700|090701|090702|100000|" +
                "100100|100101|100102|100103|100104|100105|100200|100201|110000|110100|110101|110102|110103|110104|110105|" +
                "110106|110200|110201|110202|110203|110204|110205|110206|110207|110208|110209|120000|120100|120200|120201|" +
                "120202|120203|120300|120301|120302|120303|120304|130000|130100|130101|130102|130103|130104|130105|130106|" +
                "130107|130200|130201|130202|130300|130400|130401|130402|130403|130404|130405|130406|130407|130408|130409|" +
                "130500|130501|130502|130503|130504|130505|130506|130600|130601|130602|130603|130604|130605|130606|130700|" +
                "130701|130702|130703|140000|140100|140101|140102|140200|140201|140300|140400|140500|140600|140700|140800|" +
                "140900|141000|141100|141101|141102|141103|141104|141105|141200|141201|141202|141203|141204|141205|141206|" +
                "141207|141300|141400|141500|150000|150100|150101|150102|150104|150105|150106|150107|150200|150201|150202|" +
                "150203|150204|150205|150206|150207|150208|150209|150210|150300|150301|150302|150303|150304|150400|150500|" +
                "150501|150600|150700|150701|150702|150703|150800|150900|150903|150904|150905|150906|150907|150908|150909|" +
                "151000|151100|151200|151300|160000|160100|160101|160102|160103|160104|160105|160106|160107|160108|160109|" +
                "160110|160111|160112|160113|160114|160115|160117|160118|160119|160120|160121|160122|160123|160124|160125|" +
                "160126|160127|160128|160129|160130|160131|160132|160133|160134|160135|160136|160137|160138|160139|160140|" +
                "160141|160142|160143|160144|160145|160146|160147|160148|160149|160150|160151|160152|160200|160300|160301|" +
                "160302|160303|160304|160305|160306|160307|160308|160309|160310|160311|160312|160314|160315|160316|160317|" +
                "160318|160319|160320|160321|160322|160323|160324|160325|160326|160327|160328|160329|160330|160331|160332|" +
                "160333|160334|160335|160336|160337|160338|160339|160340|160341|160342|160343|160344|160345|160346|160347|" +
                "160348|160349|160400|160401|160402|160403|160404|160405|160406|160407|160408|160500|160501|160600|170000|" +
                "170100|170200|170201|170202|170203|170204|170205|170206|170207|170208|170209|170300|170400|170401|170402|" +
                "170403|170404|170405|170406|170407|170408|180000|180100|180101|180102|180103|180104|180200|180201|180202|" +
                "180203|180300|180301|180302|180400|180500|190000|190100|190101|190102|190103|190104|190105|190106|190107|" +
                "190108|190109|190200|190201|190202|190203|190204|190205|190300|190301|190302|190303|190304|190305|190306|" +
                "190307|190308|190309|190310|190311|190400|190401|190402|190403|190500|190600|190700|200000|200100|200200|" +
                "200300|200301|200302|200303|200304|200400|220000|220100|220101|220102|220103|220104|220105|220106|220107|" +
                "220200|220201|220202|220203|220204|220205|970000|990000|991000|991001|991400|991401|991500";
    
    
    
    
//	public static  String typesListString = "010000|010100|010101|010102|010103|010104|010105|010107|010108|010109|010110|010111|010112|010200|010300|010400|" +
//  "010401|010500|010600|010700|010800|010900|010901|011000|011100|020000|020100|020101|020102|020103|020104|" +
//  "020105|020106|020200|020201|020202|020203|020300|020301|020400|020401|020402|020403|020404|020405|020406|" +
//  "020407|020408|020600|020601|020602|020700|020701|020702|020703|020800|020900|020904|020905|021000|021001|" +
//  "021002|021003|021004|021100|021200|021201|021202|021203|021300|021301|021400|021401|021500|021501|021600|" +
//  "021601|021602|021700|021701|021702|021800|021802|021803|021804|021900|022000|022100|022200|022300|022301|" +
//  "022400|022500|022501|022502|022600|022700|022800|022900|023000|023100|023200|023300|023301|023400|023500|" +
//  "025000|025100|025200|025300|025400|025500|025600|025700|025800|025900|026000|026100|026200|026300|029900|" +
//  "030000|030100|030200|030201|030202|030203|030204|030205|030206|030300|030301|030302|030303|030400|030401|" +
//  "030500|030501|030502|030503|030504|030505|030506|030507|030508|030700|030701|030702|030800|030801|030802|" +
//  "030803|030900|031000|031004|031005|031100|031101|031102|031103|031104|031200|031300|031301|031302|031303|" +
//  "031400|031401|031500|031501|031600|031601|031700|031701|031702|031800|031801|031802|031900|031902|031903|" +
//  "031904|032000|032100|032200|032300|032400|032401|032500|032600|032601|032602|032700|032800|032900|033000|" +
//  "033100|033200|033300|033400|033401|033500|033600|035000|035100|035200|035300|035400|035500|035600|035700|" +
//  "035800|035900|036000|036100|036200|036300|039900|040000|040100|040101|040200|040201|050000|050100|050101|" +
//  "050102|050103|050104|050105|050106|050107|050108|050109|050110|050111|050112|050113|050114|050115|050116|" +
//  "050117|050118|050119|050120|050121|050122|050123|050200|050201|050202|050203|050204|050205|050206|050207|" +
//  "050208|050209|050210|050211|050212|050213|050214|050215|050216|050217|050300|050301|050302|050303|050304|" +
//  "050305|050306|050307|050308|050309|050310|050311|050400|050500|050501|050502|050503|050504|050600|050700|" +
//  "050800|050900|060000|060100|060101|060102|060103|060200|060201|060202|060300|060301|060302|060303|060304|" +
//  "060305|060306|060307|060308|060400|060401|060402|060403|060404|060405|060406|060407|060408|060409|060411|" +
//  "060413|060414|060415|060500|060501|060502|060600|060601|060602|060603|060604|060605|060606|060700|060701|" +
//  "060702|060703|060704|060705|060706|060800|060900|060901|060902|060903|060904|060905|060906|060907|061000|" +
//  "061001|061100|061101|061102|061103|061104|061200|061201|061202|061203|061204|061205|061206|061207|061208|" +
//  "061209|061210|061211|061212|061213|061214|061300|061301|061302|061400|061401|070000|070100|070200|070201|" +
//  "070202|070203|070300|070301|070302|070303|070304|070305|070306|070400|070401|070500|070501|070600|070601|" +
//  "070603|070604|070605|070606|070607|070608|070609|070610|070700|070701|070702|070703|070704|070705|070706|" +
//  "070800|070900|071000|071100|071200|071300|071400|071500|071600|071700|071800|071801|071900|071901|071902|" +
//  "071903|072000|072001|080000|080100|080101|080102|080103|080104|080105|080106|080107|080108|080109|080110|" +
//  "080111|080112|080113|080114|080115|080116|080117|080118|080119|080200|080201|080202|080300|080301|080302|" +
//  "080303|080304|080305|080306|080307|080308|080400|080401|080402|080500|080501|080502|080503|080504|080505|" +
//  "080600|080601|080602|080603|090000|090100|090101|090102|090200|090201|090202|090203|090204|090205|090206|" +
//  "090207|090208|090209|090210|090211|090300|090400|090500|090600|090601|090602|090700|090701|090702|100000|" +
//  "100100|100101|100102|100103|100104|100105|100200|100201|110000|110100|110101|110102|110103|110104|110105|" +
//  "110106|110200|110201|110202|110203|110204|110205|110206|110207|110208|110209|120000|120100|120200|120201|" +
//  "120202|120203|120300|120301|120302|120303|120304|130000|130100|130101|130102|130103|130104|130105|130106|" +
//  "130107|130200|130201|130202|130300|130400|130401|130402|130403|130404|130405|130406|130407|130408|130409|" +
//  "130500|130501|130502|130503|130504|130505|130506|130600|130601|130602|130603|130604|130605|130606|130700|" +
//  "130701|130702|130703|140000|140100|140101|140102|140200|140201|140300|140400|140500|140600|140700|140800|" +
//  "140900|141000|141100|141101|141102|141103|141104|141105|141200|141201|141202|141203|141204|141205|141206|" +
//  "141207|141300|141400|141500|150000|150100|150101|150102|150104|150105|150106|150107|150200|150201|150202|" +
//  "150203|150204|150205|150206|150207|150208|150209|150210|150300|150301|150302|150303|150304|150400|150500|" +
//  "150501|150600|150700|150701|150702|150703|150800|150900|150903|150904|150905|150906|150907|150908|150909|" +
//  "151000|151100|151200|151300|160000|160100|160101|160102|160103|160104|160105|160106|160107|160108|160109|" +
//  "160110|160111|160112|160113|160114|160115|160117|160118|160119|160120|160121|160122|160123|160124|160125|" +
//  "160126|160127|160128|160129|160130|160131|160132|160133|160134|160135|160136|160137|160138|160139|160140|" +
//  "160141|160142|160143|160144|160145|160146|160147|160148|160149|160150|160151|160152|160200|160300|160301|" +
//  "160302|160303|160304|160305|160306|160307|160308|160309|160310|160311|160312|160314|160315|160316|160317|" +
//  "160318|160319|160320|160321|160322|160323|160324|160325|160326|160327|160328|160329|160330|160331|160332|" +
//  "160333|160334|160335|160336|160337|160338|160339|160340|160341|160342|160343|160344|160345|160346|160347|" +
//  "160348|160349|160400|160401|160402|160403|160404|160405|160406|160407|160408|160500|160501|160600|170000|" +
//  "170100|170200|170201|170202|170203|170204|170205|170206|170207|170208|170209|170300|170400|170401|170402|" +
//  "170403|170404|170405|170406|170407|170408|180000|180100|180101|180102|180103|180104|180200|180201|180202|" +
//  "180203|180300|180301|180302|180400|180500|190000|190100|190101|190102|190103|190104|190105|190106|190107|" +
//  "190108|190109|190200|190201|190202|190203|190204|190205|190300|190301|190302|190303|190304|190305|190306|" +
//  "190307|190308|190309|190310|190311|190400|190401|190402|190403|190500|190600|190700|200000|200100|200200|" +
//  "200300|200301|200302|200303|200304|200400|220000|220100|220101|220102|220103|220104|220105|220106|220107|" +
//  "220200|220201|220202|220203|220204|220205|970000|990000|991000|991001|991400|991401|991500";

    
	

    
    
   
//    高德地图行政区域查询API的URL
    public static String poiUrl = "https://restapi.amap.com/v3/place/polygon";
    
    public static final int OFFSET = 20;

    public static int total_count = 0;
    


    public static void getByBounds(Rectangle rectangle,String searchType) {
        if (rectangle == null) return;

        Point lt = rectangle.leftTop;
        Point rb = rectangle.rightBottom;
//        百度地图是纬度经度，高德是经纬度
        String lefttop = lt.longitude + "," + lt.latitude;//先经度，再纬度
        String rightbottom = rb.longitude + "," + rb.latitude;//先经度，再纬度

        int currentPageIndex = 1;
//        for (int i = 0; i <typesListString.split("\\|").length; i++) {
        	String poiParam = "?types=" + searchType + "&offset="+OFFSET+"&polygon=" + lefttop + "|" + rightbottom + "&page=" + currentPageIndex+"&key="+KEY;
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

            galaxy.tec.poiData.bean.Rectangle r1 = new galaxy.tec.poiData.bean.Rectangle(rectangle.currentAreaName, lt, p4);
            galaxy.tec.poiData.bean.Rectangle r2 = new galaxy.tec.poiData.bean.Rectangle(rectangle.currentAreaName, p1, rb);
            getByBounds(r1,searchType);
            getByBounds(r2,searchType);

        } else {


            //进入数采集，
            int pages = 0;
            if (count % OFFSET == 0) {
                pages = count / OFFSET;
            } else {
                pages = count / OFFSET + 1;
            }
            List<PoiModel> storeModelList = new ArrayList<PoiModel>(20);

            System.out.println("当前小区域总数 " + count + "     分页数{" + pages + "}     currentPageIndex" + currentPageIndex + "  " + rectangle.toString());

            for (int i2 = 0; i2 < pages; i2++) {
            	
//            	for (int i = 0; i < types.split("\\|").length; i++) {
					
            		String pageparam = "?types=" + searchType + "&key=" + KEY + "&offset=20&polygon=" + lefttop + "|" + rightbottom + "&page=" + (currentPageIndex);
            		currentPageIndex++;//开始第二页的请求
            		String r = sendURLWithParams(poiUrl + pageparam);
            		JSONObject page = JSONObject.fromObject(r);
            		addPageData(page, storeModelList, rectangle.currentAreaName);
//				}
            	
            }
            //先保存数据
            FileUtils.writeIntoCSV(storeModelList);
            storeModelList.clear();
            storeModelList = null;
            currentPageIndex = 1;//set as default.
        }
//        }
    }

    public static void addPageData(JSONObject page, List<PoiModel> storeModelList, String currentAreaName) {
    	
        @SuppressWarnings("unchecked")
		List<JSONObject> pois = page.getJSONArray("pois");
        for (int k = 0; k < pois.size(); k++) {
            PoiModel poiModel = new PoiModel();
            if (pois.get(k).containsKey("name")) {
            	poiModel.name = pois.get(k).getString("name");
            }
            if (pois.get(k).containsKey("id")) {
            	poiModel.id = pois.get(k).getString("id");
            }
            if (pois.get(k).containsKey("type")) {
            	poiModel.type = pois.get(k).getString("type");
            }
            if (pois.get(k).containsKey("typecode")) {
            	poiModel.typeCode = pois.get(k).getString("typecode");
            }
            if (pois.get(k).containsKey("address")) {
            	poiModel.formatted_address = pois.get(k).getString("address");
            }
            if (pois.get(k).containsKey("location")) {
            	poiModel.longitude = pois.get(k).get("location").toString().split(",")[0];
            	poiModel.latitude = pois.get(k).get("location").toString().split(",")[1];
                Area area = getDistinct(poiModel.longitude, poiModel.latitude);

                if (area == null || !area.city.equals(Area.SHENZHEN)) {//不属于深圳地区的
//                if (area == null || !area.country.equals(Area.CHINA) || !area.province.equals(Area.XINJIANG)||!area.city.equals(WLMQ)) {//不属于深圳
                    System.out.println("非深圳地区   ****      " + area.toString() + poiModel.longitude + " , " + poiModel.latitude);
//                if (area == null || !area.country.equals(Area.CHINA) || !area.province.equals(Area.XINJIANG) || !area.city.equals(Area.WLMQ)) {//不属于深圳
                    continue;
                }

                poiModel.areaInfo = area;
                
//                if (area.formatted_address.length() == 0) {
//                    storeModel.formatted_address = currentAreaName;
//                } else {
//                    storeModel.formatted_address = area.formatted_address;
//                }
            }

//            if (stores.get(k).containsKey("address")) {
//                storeModel.address = stores.get(k).getString("address");
//            }

            new GetDatas().jdbcOpreation.insertPoi(poiModel);
            storeModelList.add(poiModel);
            System.out.println("总计数： " + (total_count++) + "     " + poiModel.toString());
        }

    }

    /**
     * 获取行政区域区域信息
     *
     * @param latitude
     * @param longtitude
     * @return
     */
    public static Area getDistinct(String longtitude, String latitude) {
        String url = URLUtils.geoCodeReversURL(longtitude, latitude );
        String r = sendURLWithParams(url);
         JSONObject page = JSONObject.fromObject(r);

        if (page == null) return null;

        Area result = new Area();
        JSONObject object = page.getJSONObject("regeocode");

        if (object == null) return null;

//        result.formatted_address = object.getString("formatted_address");

        if (object.containsKey("addressComponent")) {
//        	Object object2 = object.getJSONObject("addressComponent").get("streetNumber");
//        	Object object3 = ((JSONObject) object2).get("number");
//        	System.out.println(object3);
            result.country = object.getJSONObject("addressComponent").getString("country");
            result.province = object.getJSONObject("addressComponent").getString("province");//目前只需筛选到省，自治区
            result.city = object.getJSONObject("addressComponent").getString("city");//目前只需筛选到省，自治区
            result.district = object.getJSONObject("addressComponent").getString("district");//
            result.township = object.getJSONObject("addressComponent").getString("township");//
            Object object2 = object.getJSONObject("addressComponent").get("streetNumber");
        	Object object3 = ((JSONObject) object2).get("street");
            result.street = object3.toString()+((JSONObject) object2).getString("number").toString();//

//            result.street = object.getJSONObject("addressComponent").getString("street");//

        }

        return result;
    }


}