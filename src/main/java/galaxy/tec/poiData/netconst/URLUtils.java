package galaxy.tec.poiData.netconst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLUtils {
	/* 请求并发 */
	public static double concurrentNum = 0.0d;
	// 高德地图申请的开发者key（key 有配额限制）
	public static String KEY = "ab01a8664a1d2fe7c9bd4d5172d9fde2";

	// 高德地图地理编码API
	public static String geocoder = "https://restapi.amap.com/v3/geocode/regeo?key=" + KEY;

	public static String geoCodeReversURL(String longtitude, String lat) {
		StringBuilder sb = new StringBuilder(geocoder);
		sb.append("&location=").append(longtitude).append(",").append(lat);
		return sb.toString();
	}

	public static String sendURLWithParams(String url) {
		String result = "";// 访问返回结果
		BufferedReader read = null;// 读取访问结果
		try {
			// 创建访问的URL
			URL realurl = new URL(url);
			// 打开连接
			URLConnection connection = realurl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			read = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;// 循环读取
			while ((line = read.readLine()) != null) {
				result += line;
			}
			concurrentNum++;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (read != null) {// 关闭流
				try {
					read.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// try {
		// Thread.sleep(5);
		// } catch (Exception e) {
		// e.printStackTrace(e);
		// }
		return result;
	}

}
