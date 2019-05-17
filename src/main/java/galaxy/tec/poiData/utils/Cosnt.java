package galaxy.tec.poiData.utils;

import java.util.ArrayList;
import java.util.List;

import galaxy.tec.poiData.bean.Point;
import galaxy.tec.poiData.bean.Rectangle;

public class Cosnt {

	public static final double DIS = 0.2;

	public static void main(String[] args) {

		// System.out.println(Cosnt.getCuttedAreaList(new Rectangle(new Point(8.0,
		// 10.0), new Point(10.0, 8.0))));
		//
		//
		// System.out.println("===");
		//
		// List<Rectangle> shenzhen = getCuttedAreaList(new Rectangle(new
		// Point(113.751453,22.861748), new Point(114.628466,22.396344)));
		// System.out.println(shenzhen);
	}

	// 将矩形区域分割成多个小区域
	public static List<Rectangle> getCuttedAreaList(Rectangle rectangle) {
		List<Rectangle> list = new ArrayList<Rectangle>(20);
		int pieces_long = getPieces(rectangle.leftTop.longitude, rectangle.rightBottom.longitude); // 经度切片数目
		int pieces_lat = getPieces(rectangle.leftTop.latitude, rectangle.rightBottom.latitude);// 纬度度切片数目
		for (int i = 1; i <= pieces_lat; i++) {
			double lt_lat = rectangle.leftTop.latitude - DIS * (i - 1);// 起始纬度
			double rb_lat = rectangle.leftTop.latitude - DIS * i;// 终止纬度
			if (rb_lat < rectangle.rightBottom.latitude) {// 不超过最大纬度
				rb_lat = rectangle.rightBottom.latitude;
			}
			for (int j = 1; j <= pieces_long; j++) {
				double lt_long = rectangle.leftTop.longitude + DIS * (j - 1);// 起始经度
				double rb_long = rectangle.leftTop.longitude + DIS * j;// 终止经度
				if (rb_long > rectangle.rightBottom.longitude) {
					rb_long = rectangle.rightBottom.longitude;
				}
				Rectangle r = new Rectangle(new Point(lt_long, lt_lat), new Point(rb_long, rb_lat));
				list.add(r);
			}
		}
		return list;
	}

	// 获得分割后的小区域的总数
	public static int getPieces(double from, double to) {

		double distance = Math.abs(to - from);
		return (int) (distance / DIS + 1);
	}
}
