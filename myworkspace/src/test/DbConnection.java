package test;

/*
 * using DATA SOURCE without JNDI
 */
/*import java.sql.*;
import javax.sql.*;
import oracle.jdbc.driver.*;
import oracle.jdbc.pool.OracleDataSource;

class DbConnection
{
	
	
	DbConnection()
	{	
		try
		{
			OracleDataSource ods = new OracleDataSource();
			ods.setUser("lucky");
			ods.setPassword("lucky");
			//ds.setURL("jdbc:oracle:thin:@localhost:1521:ngs");
			ods.setURL("jdbc:oracle:thin:@localhost:1521:csam");
			Connection conn = ods.getConnection();
			Statement stmt = conn.createStatement ();
			//ResultSet rset = stmt.executeQuery ("select USER from dual");
			ResultSet rset = stmt.executeQuery ("select * from temp");
			while (rset.next ())
				System.out.println ("User name is " + rset.getString (1));
			
			// Close the RseultSet
			rset.close();
			rset =  null;
			
			// Close the Statement
			stmt.close();
			stmt = null;
			conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}*/





/*
 * Using driver Manager
 * Oracle provides two main types of drivers.
The OCI driver.
The OCI (type 2) driver consists of java wrappers to the low-level Oracle Call Interface (OCI) libraries
 used by utilities like SQL*Plus to access the database server. The OCI driver offers potentially better
  performance that the thin driver. It however requires the OCI libraries to be installed on the local machine.

The ``thin'' driver.
Also referred to as type 4 driver, the thin driver is a pure Java implementation of Oracle's networking 
protocol (Net8). Being self-contained, it may be used on any machine with--or without Oracle installed--or 
even distributed with application classes in an applet


#####################################
Select your driver type : thin, oci, kprb...

Oralce provides four types of JDBC driver.

    * Thin Driver, a 100% Java driver for client-side use without an Oracle installation, particularly with applets. The Thin driver type is thin. To connect user scott with password tiger to a database with SID (system identifier) orcl through port 1521 of host myhost, using the Thin driver, you would write :

      Connection conn = DriverManager.getConnection
      ("jdbc:oracle:thin:@myhost:1521:orcl", "scott", "tiger");

    * OCI Driver for client-side use with an Oracle client installation. The OCI driver type is oci. To connect user scott with password tiger to a database with SID (system identifier) orcl through port 1521 of host myhost, using the OCI driver, you would write :

      Connection conn = DriverManager.getConnection
      ("jdbc:oracle:oci:@myhost:1521:orcl", "scott", "tiger");

      Note that you can also specify the database by a TNSNAMES entry. You can find the available TNSNAMES entries listed in the file tnsnames.ora on the client computer from which you are connecting. For example, if you want to connect to the database on host myhost as user scott with password tiger that has a TNSNAMES entry of MyHostString, enter:

      Connection conn = DriverManager.getConnection
      ("jdbc:oracle:oci8:@MyHostString","scott","tiger");

      If your JDBC client and Oracle server are running on the same machine, the OCI driver can use IPC (InterProcess Communication) to connect to the database instead of a network connection. An IPC connection is much faster than a network connection.

      Connection conn = DriverManager.getConnection
      ("jdbc:oracle:oci8:@","scott","tiger");

    * Server-Side Thin Driver, which is functionally the same as the client-side Thin driver, but is for code that runs inside an Oracle server and needs to access a remote server, including middle-tier scenarios. The Server-Side Thin driver type is thin and there is no difference in your code between using the Thin driver from a client application or from inside a server.
    * Server-Side Internal Driver for code that runs inside the target server, that is, inside the Oracle server that it must access. The Server-Side Internal driver type is kprb and it actually runs within a default session. You are already "connected". Therefore the connection should never be closed.
      To access the default connection, write:

      DriverManager.getConnection("jdbc:oracle:kprb:");
      or:
      DriverManager.getConnection("jdbc:default:connection:");

      You can also use the Oracle-specific defaultConnection() method of the OracleDriver class which is generally recommended:

      OracleDriver ora = new OracleDriver();
      Connection conn = ora.defaultConnection();

      Note: You are no longer required to register the OracleDriver class for connecting with the Server-Side Internal driver, although there is no harm in doing so. This is true whether you are using getConnection() or defaultConnection() to make the connection.
      Any user name or password you include in the URL string is ignored in connecting to the server default connection. The DriverManager.getConnection() method returns a new Java Connection object every time you call it. Note that although the method is not creating a new physical connection (only a single implicit connection is used), it is returning a new object.
      Again, when JDBC code is running inside the target server, the connection is an implicit data channel, not an explicit connection instance as from a client. It should never be closed. 
#####################################

 */

/*import java.sql.*;
class DbConnection
{
	DbConnection()
	{
		
		
		try
		{
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:csam","lucky","lucky");
			Statement stmt = conn.createStatement ();
			ResultSet rset = stmt.executeQuery ("select * from user_tables");
			while (rset.next ())
				System.out.println ("User name is " + rset.getString (1));
			
			// Close the RseultSet
			rset.close();
			rset =  null;
			
			// Close the Statement
			stmt.close();
			stmt = null;
			conn.close();
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con=DriverManager
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
}*/



/*
 * using DATA SOURCE with JNDI 
 */

/*import java.sql.*;
import javax.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;
class DbConnection
{
	Statement stmt,stmt1;
	Connection conn;
	ResultSet rset,rset1;
	DbConnection()
	{	
		try
		{
			Hashtable env=new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,		//when using WEBLOGIC
			"weblogic.jndi.WLInitialContextFactory");		
			//env.put(Context.PROVIDER_URL,"t3://localhost:7001");//bydefault takes this only
			//env.put(Context.SECURITY_PRINCIPAL,"weblogic");
			//env.put(Context.SECURITY_CREDENTIALS,"weblogic");
			DataSource dataSource = (DataSource) (new InitialContext(env)).lookup("luckydatasource");
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			stmt1 = conn.createStatement(); 		//as All execution methods in the Statement interface implicitly close a statment's current ResultSet object if an open one exists
			rset = stmt.executeQuery ("select * from temp");
			rset1 = stmt1.executeQuery("select * from user_tables");
			while (rset.next ())
				System.out.println ("Roll no is " + rset.getInt(1) + " and name is:" + rset.getString(2));
			while (rset1.next())
				System.out.println("first column is" + rset1.getString("table_name"));
			// Close the RseultSet
			rset.close();
			rset =  null;
			rset1.close();
			rset1 = null;
			
			// Close the Statement
			stmt.close();
			stmt = null;
			conn.close();
			conn= null;
			
			//ResultSet rs = stmt.executeQuery("select * from emp " + "where sal < 2000 " + "order by empno");
			//ods.setUser("lucky");
			//ods.setPassword("lucky");
			//ds.setURL("jdbc:oracle:thin:@localhost:1521:ngs");
			//ods.setURL("jdbc:oracle:thin:@localhost:1521:csam");
			//Connection conn = ods.getConnection();
			//Statement stmt = conn.createStatement ();
			//ResultSet rset = stmt.executeQuery ("select USER from dual");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if(rset != null)
					rset.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}*/


/*
 * Using resource bundle i.e loading specificaions from a file.
 * Also using prepared statement
 */


import java.sql.*;
import javax.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.*;
class DbConnection
{
	PreparedStatement pstmt=null,pstmt1=null;
	Connection conn=null;
	ResultSet rset=null,rset1=null;
	/**
	 * The JNDI context factory to use. This is server specific, change if not
	 * using WebLogic
	 */
	private static final String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";
	
	/** URL of the server to connect. */
	private String serverUrl = null;
	
	/**conf file from where to load specifications  */
	private static final String CONF_FILE="test/config/conf";
	
	/** Username to login to weblogic server. */
	private String userName = null;
	
	/** Login password for weblogic. */
	private String password = null;
	
	
	DbConnection()
	{	
		try
		{
			//load specifications from a properties file via resourcebundle
			ResourceBundle resource = null;
			try
			{
				resource = ResourceBundle.getBundle(CONF_FILE);
				serverUrl = resource.getString("serverUrl");
				userName = resource.getString("username"); 			//not necessary
				password = resource.getString("password");			//not necessary
			}catch(MissingResourceException e)
			{
				System.out.println("Inside Missing resource");
				e.printStackTrace();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			Hashtable env=new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,JNDI_FACTORY);						
			env.put(Context.PROVIDER_URL,serverUrl);
			env.put(Context.SECURITY_PRINCIPAL,userName);
			env.put(Context.SECURITY_CREDENTIALS,password);
			DataSource dataSource = (DataSource) (new InitialContext(env)).lookup("luckydatasource");
			conn = dataSource.getConnection();		
			pstmt = conn.prepareStatement("update temp set degree = ? where name = ?");
			pstmt.setString(1,"BSc");
			pstmt.setString(2,"lucky");			
			int count=pstmt.executeUpdate();
			System.out.println("count is:" + count);
			//while (rset.next())
				//System.out.println("first column is" + rset.getString("table_name"));
			// Close the RseultSet
			//rset.close();
			//rset =  null;
			pstmt1 = conn.prepareStatement("select * from temp where name like ?"); 		//as All execution methods in the Statement interface implicitly close a statment's current ResultSet object if an open one exists
			pstmt1.setString(1,"lucky%");
			rset1 = pstmt1.executeQuery();
			while (rset1.next())
				System.out.println ("Roll no is " + rset1.getInt(1) + " and name is:" + rset1.getString(2) + 
						"degree is:" + rset1.getString(3));
			rset1.close();
			rset1 = null;
			
			// Close the Statement
			pstmt.close();
			pstmt = null;
			pstmt1.close();
			pstmt1 = null;
			conn.close();
			conn= null;
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if(rset != null)
					rset.close();
				if(pstmt != null)
					pstmt.close();
				if(pstmt1 != null)
					pstmt1.close();
				if(conn != null)
					conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}









