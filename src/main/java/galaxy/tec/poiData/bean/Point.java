package galaxy.tec.poiData.bean;

public class Point {

	public double longitude = 0.0;

	public double latitude = 0.0;

	public Point(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "{" + longitude + ", " + latitude + '}';
	}

}
