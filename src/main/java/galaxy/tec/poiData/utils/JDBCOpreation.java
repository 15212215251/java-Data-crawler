package galaxy.tec.poiData.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import galaxy.tec.poiData.bean.PoiModel;

public class JDBCOpreation {
	public Connection getConn() {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://192.168.0.150:5432/hxdq_db";  
		String username = "xauser";  
        String password = "xauser";  
        Connection conn = null; 
        try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public int insertPoi(PoiModel poiModel) {
		Connection connection = getConn();
		int i = 0;
		String sql = "insert into tb_poidata(id,name,type,typecode,formatted_address,longitude,latitude,country,province,city,district,township,street) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pStatement;
		try {
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			pStatement.setString(1, poiModel.getId());
			pStatement.setString(2, poiModel.getName());
			pStatement.setString(3, poiModel.getType());
			pStatement.setString(4, poiModel.getTypeCode());
			pStatement.setString(5, poiModel.getFormatted_address());
			pStatement.setString(6, poiModel.getLongitude());
			pStatement.setString(7, poiModel.getLatitude());
			pStatement.setString(8, poiModel.getAreaInfo().country);
			pStatement.setString(9, poiModel.getAreaInfo().province);
			pStatement.setString(10, poiModel.getAreaInfo().city);
			pStatement.setString(11, poiModel.getAreaInfo().district);
			pStatement.setString(12, poiModel.getAreaInfo().township);
			pStatement.setString(13, poiModel.getAreaInfo().street);
			i = pStatement.executeUpdate();
			pStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
		
	}
}
