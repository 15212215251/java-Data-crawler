package galaxy.tec.poiData;

import static galaxy.tec.poiData.utils.FileUtils.writeIntoCSV;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import galaxy.tec.poiData.bean.Area;
import galaxy.tec.poiData.bean.Point;
import galaxy.tec.poiData.bean.Rectangle;
import galaxy.tec.poiData.bean.PoiModel;
import galaxy.tec.poiData.netconst.URLUtils;
import galaxy.tec.poiData.utils.Cosnt;

public class App {
	public static void main(String[] args) throws SQLException {
		long startTime = System.currentTimeMillis();

		// write表头
		writeHeader();
		String[] typeList = new GetDatas().types.split("\\|");
		System.out.println(typeList);
		List<Rectangle> tasklist = getTaskList();
		for (int i = 0; i < tasklist.size(); i++) {
			for (int j = 0; j < typeList.length; j++) {
				GetDatas.getByBounds(tasklist.get(i),typeList[j]);
			}
		}

		long endTime = System.currentTimeMillis();
		long costTime = endTime - startTime;

		StringBuilder sb = new StringBuilder();
		sb.append(costTime % 1000).append("毫秒");
		if (costTime > 1000) {
			costTime = costTime / 1000;
			sb.insert(0, "秒");
			sb.insert(0, costTime % 60);
			System.out.println(
					" 并发总数 ： " + URLUtils.concurrentNum + "   每分钟并发量：" + (URLUtils.concurrentNum / costTime) * 60.0);
		}
		if (costTime > 60) {
			costTime = costTime / 60;
			sb.insert(0, "分钟");
			sb.insert(0, costTime % 60);

		}
		if (costTime > 60) {
			costTime = costTime / 60;
			sb.insert(0, "小时");
			sb.insert(0, costTime % 60);
		}
		System.out.println("任务耗时" + sb.toString());
	}

	public static List<Rectangle> getTaskList() {
		List<Rectangle> shenzhen = Cosnt
				.getCuttedAreaList(new Rectangle(new Point(113.751453,22.861748), new Point(114.628466,22.396344)));
		     
		return shenzhen;

	}

	public static void writeHeader() {
		List<PoiModel> rowList = new ArrayList<PoiModel>(20);

		PoiModel header = new PoiModel();
		
		header.id = "id";
		
		header.name = "name";
		
		header.type = "type";
		
		header.typeCode = "typeCode";
		
		header.formatted_address = "address";
		
		header.longitude = "lng";
		
		header.latitude = "lat";
		
		header.areaInfo = new Area();
		header.areaInfo.country = "country";
		header.areaInfo.province = "province";
		header.areaInfo.city = "city";
		header.areaInfo.district = "district";
		header.areaInfo.township = "township";
		header.areaInfo.street = "street";
		// header.areaInfo.adcode = "邮编代码";

		rowList.add(header);
		writeIntoCSV(rowList);
	}
	
//	public static void main(String[] args) {
//		System.out.println("===");
//		new App().writeHeader();
//	}

}
