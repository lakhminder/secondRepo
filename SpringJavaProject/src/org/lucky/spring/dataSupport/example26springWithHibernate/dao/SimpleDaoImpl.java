package org.lucky.spring.dataSupport.example26springWithHibernate.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

/**
 * This class is the base class for all Dao classes which needs 
 * Spring dao support(JDBC Template and dataSource)
 * However looks like there is problem if we define this as bean in xml and rest dao classes
 * which will extend this as stereotypes(@Component)
 * So better we can directly extend SimpleJdbcDaoSupport in all dao classes and 
 * then define them as beans in xml for wiring data source 
 * 
 * See spring.xml for wiring data source to this class by referring to member variable from 
 * parent class(template/DAO support class)
 * 
 *
 */
public class SimpleDaoImpl extends SimpleJdbcDaoSupport {

}
