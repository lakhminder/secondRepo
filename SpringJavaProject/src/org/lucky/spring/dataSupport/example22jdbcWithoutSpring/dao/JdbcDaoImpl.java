package org.lucky.spring.dataSupport.example22jdbcWithoutSpring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lucky.spring.dataSupport.example22jdbcWithoutSpring.model.Circle;

public class JdbcDaoImpl {

	public Circle getCircle(int circleId){
		Connection con = null;
		try {
			
			//String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			//Class.forName(driver).newInstance();
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:lucky","lucky_user","lucky_user");
			PreparedStatement ps = con.prepareStatement("select * from circle where id = ?");
			ps.setInt(1, circleId);
			
			Circle circle = null;
			ResultSet rs= ps.executeQuery();
			if(rs.next()){
				circle = new Circle(circleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
			return circle;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
