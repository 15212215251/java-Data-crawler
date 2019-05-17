package galaxy.tec.poiData.bean;

public class Area {
	
    public static final String CHINA = "中国";

    public static final String SHENZHEN = "深圳市";
    
    public static final String GD = "广东省";
    
    public String country = "";
    /**
     * 省份，自治区，直辖市
     */
    public String province = "";
    /**
     * 市
     */
    public String city = "";
    /**
     * 区，县
     */
    public String district = "";

    public String township = "";//乡镇

    /**
     * 街道
     */
    public String street = "";//街道名（行政区划中的街道层级）



    @Override
    public String toString() {
        return "Area{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", town='" + township + '\'' +
                ", street='" + street + '\''  +
                '}';
    }
}
