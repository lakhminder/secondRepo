package org.lucky.spring.dataSupport.example24usingJdbcTemplate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.lucky.spring.dataSupport.example24usingJdbcTemplate.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * see setDataSource()
 * getCircle() won't work as dataSource is not initialized, use jdbcTemplate instead as in
 * getCircleCount()
 * 
 * see getCircleName() as well
 * 
 * refer getCircleForId() & getCircleList() (CircleMapper as well)
 * 
 * use update for DML and execute for DDL
 * refer insertCircle() & createTriangle() 
 * & insertCircle1 for namedParameters
 * 
 * Also can use SimpleJdbcTemplate for java5 stuff like varargs and autoboxing
 */
@Component
public class JdbcDaoImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
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
	
	public int getCircleCount(){
		String sql = "select count(*) from Circle";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getCircleName(int circleId){
		String sql = "select name from Circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
	}
	
	public Circle getCircleForId(int circleId){
		String sql = "select * from Circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());
	}
	
	public List<Circle> getCircleList(){
		String sql = "select * from Circle ";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public void insertCircle(Circle circle){
		String sql = "insert into Circle values(? ,?)";
		jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
	}
	
	public void insertCircle1(Circle circle){
		String sql = "insert into Circle values(:id , :name)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", circle.getId())
		.addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, sqlParameterSource);

	}
	
	public void createTriangle(){
		String sql = "CREATE TABLE TRIANGLE(ID INTEGER,NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	//Initialize jdbcTemplate here only
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		//this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}
		
	}
}
