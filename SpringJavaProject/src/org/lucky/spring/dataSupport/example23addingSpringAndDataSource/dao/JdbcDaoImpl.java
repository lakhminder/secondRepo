package org.lucky.spring.dataSupport.example23addingSpringAndDataSource.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.lucky.spring.dataSupport.example23addingSpringAndDataSource.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * refer spring.xml
 *
 */
@Component
public class JdbcDaoImpl {

	@Autowired
	private DataSource dataSource; 
	
	public Circle getCircle(int circleId){
		Connection con = null;
		try {
			
			con = dataSource.getConnection();
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

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
