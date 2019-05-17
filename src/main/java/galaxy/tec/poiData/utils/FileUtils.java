package galaxy.tec.poiData.utils;

import galaxy.tec.poiData.bean.PoiModel;

import java.io.*;
import java.util.List;

/**
 * 文件工具类
 */
public class FileUtils {
	// 文件输出磁盘目录
	public static final String outPutPath = "D:" + File.separator;
	// 输出文件文件名
	public static String fileName = "gaodeMapPoi-shenzhen.csv";// 文件名称

	/**
	 * 创建CSV文件
	 */
	public static void writeIntoCSV(List<PoiModel> headList) {
		File csvFile = null;
		BufferedWriter csvWtriter = null;
		try {
			csvFile = new File(outPutPath + fileName);
			if (!csvFile.exists()) {// 不存在则创建
				File parent = csvFile.getParentFile();
				if (parent != null && !parent.exists()) {
					parent.mkdirs();
				}
				csvFile.createNewFile();
			}

			// GB2312使正确读取分隔符","
			csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile, true), "GB2312"),
					1024);
			writeRow(headList, csvWtriter, csvFile);
			csvWtriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvWtriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 写一行数据
	 *
	 * @param row
	 *            数据列表
	 * @param csvWriter
	 * @param csvFile
	 * @throws IOException
	 */
	private static void writeRow(List<PoiModel> row, BufferedWriter csvWriter, File csvFile) throws IOException {
		for (int j = 0; j < row.size(); j++) {
			PoiModel poiModel = row.get(j);

			for (int i = 0; i < 13; i++) {
				StringBuffer sb = new StringBuffer();

				int offset = 0;
				if (csvFile.length() > 0) {
					offset = (int) (csvFile.length() - 1);
				}
				String rowStr;
				switch (i) {
				case 0:
					rowStr = sb.append("\"").append(poiModel.id).append("\",").toString();
					csvWriter.append(rowStr);
					break;
				case 1:
					rowStr = sb.append("\"").append(poiModel.name).append("\",").toString();
					csvWriter.append(rowStr);
					break;
				case 2:
					rowStr = sb.append("\"").append(poiModel.type).append("\",").toString();
					csvWriter.append(rowStr);
					break;
				case 3:
					rowStr = sb.append("\"").append(poiModel.typeCode).append("\",").toString();
					csvWriter.append(rowStr);
					break;
				case 4:
					rowStr = sb.append("\"").append(poiModel.formatted_address).append("\",").toString();
					csvWriter.append(rowStr);
					break;

				case 5:
					rowStr = sb.append("\"").append(poiModel.longitude).append("\",").toString();
					csvWriter.append(rowStr);
					break;
				case 6:
					rowStr = sb.append("\"").append(poiModel.latitude).append("\",").toString();
					csvWriter.append(rowStr);
					break;

				/// 如下是详细地址区划信息
				case 7:
					if (poiModel.areaInfo == null)
						break;
					rowStr = sb.append("\"").append(poiModel.areaInfo.country).append("\",").toString();
					csvWriter.append(rowStr);
					break;
				case 8:
					if (poiModel.areaInfo == null)
						break;
					rowStr = sb.append("\"").append(poiModel.areaInfo.province).append("\",").toString();
					csvWriter.append(rowStr);
					break;
				case 9:
					if (poiModel.areaInfo == null)
						break;
					rowStr = sb.append("\"").append(poiModel.areaInfo.city).append("\",").toString();
					csvWriter.append(rowStr);
					break;

				case 10:
					if (poiModel.areaInfo == null)
						break;
					rowStr = sb.append("\"").append(poiModel.areaInfo.district).append("\",").toString();
					csvWriter.append(rowStr);
					break;
				case 11:
					if (poiModel.areaInfo == null)
						break;
					rowStr = sb.append("\"").append(poiModel.areaInfo.township).append("\",").toString();
					csvWriter.append(rowStr);
					break;

				case 12:
					if (poiModel.areaInfo == null)
						break;
					rowStr = sb.append("\"").append(poiModel.areaInfo.street).append("\",").toString();
					csvWriter.append(rowStr);
					break;

				}

			}
			csvWriter.newLine();

		}

	}

}
