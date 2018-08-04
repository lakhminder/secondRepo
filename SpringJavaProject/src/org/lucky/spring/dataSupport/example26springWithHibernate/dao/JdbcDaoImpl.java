package org.lucky.spring.dataSupport.example26springWithHibernate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.lucky.spring.dataSupport.example26springWithHibernate.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Component;

/**
 * Minimising the code by using Spring DAO support classes
 * see SimpleDaoImpl and spring.xml
 */
@SuppressWarnings("deprecation")
//This needs to be bean defined in xml only else it gives error for @Component
//java.lang.IllegalArgumentException: 'dataSource' or 'jdbcTemplate' is required
//@Component
public class JdbcDaoImpl extends SimpleDaoImpl{

		
	public int getCircleCount(){
		String sql = "select count(*) from Circle";
		return this.getJdbcTemplate().queryForInt(sql);
	}
	
	public String getCircleName(int circleId){
		String sql = "select name from Circle where id = ?";
		return this.getJdbcTemplate().queryForObject(sql, new Object[]{circleId}, String.class);
	}
	
	

	
}
