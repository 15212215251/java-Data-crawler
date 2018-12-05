package galaxy.tec.poiData.bean;

/**
 * poi数据点
 */
public class PoiModel {
	/**
	 * 简化地址
	 */
	public String formatted_address = "";

	public String storeName = "";

	public String longitude = "";
	public String latitude = "";

	public String locationDetailURL;

	public Area areaInfo = null;

	public PoiModel() {

	}

	@Override
	public String toString() {
		return "StoreModel{" + "formatted_address='" + formatted_address + '\'' + ", storeName='" + storeName + '\''
				+ ", longitude='" + longitude + '\'' + ", latitude='" + latitude + '\'' + ", locationDetailURL='"
				+ locationDetailURL + '\'' + ", areaInfo=" + areaInfo + '}';
	}
}
