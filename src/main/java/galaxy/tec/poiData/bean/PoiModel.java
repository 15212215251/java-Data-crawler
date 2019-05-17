package galaxy.tec.poiData.bean;

public class PoiModel {

	// poi的id，也是poi唯一标示符
	public String id = "";
	// poi name
	public String name = "";
	// poi类型
	public String type = "";
	// poi类型编码
	public String typeCode = "";
	// 综合地址
	public String formatted_address = "";
	// 经度
	public String longitude = "";
	// 纬度
	public String latitude = "";
	// 区域信息
	public Area areaInfo = null;

	public PoiModel() {

	}

	@Override
	public String toString() {
		return "PoiModel {" + "id='" + id + '\'' + ", name='" + name + '\'' + ", type='" + type + '\'' + ", typeCode='"
				+ typeCode + '\'' + ", formatted_address='" + formatted_address + '\'' + ", longitude='" + longitude
				+ '\'' + ", latitude='" + latitude + '\'' + ", areaInfo=" + areaInfo + "}";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Area getAreaInfo() {
		return areaInfo;
	}

	public void setAreaInfo(Area areaInfo) {
		this.areaInfo = areaInfo;
	}
	
	
}
