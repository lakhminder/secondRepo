package test;
/*
 * Appaji method to check performance of Data Source  
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.naming.Context;

public class TestDSPerformance {
        public static void main (String args[]) throws Exception
        {
        	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy.MM.dd-HH.mm:ss a");
        	
        	System.out.println("Now starts:" + dateTimeFormat.format(new Date(System.currentTimeMillis())) );

        	Hashtable ht = new Hashtable();
        	ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        	//ht.put(Context.PROVIDER_URL, "t3://bycsam09.nat.bt.com:61000");
        	ht.put(Context.PROVIDER_URL, "t3://hwcsam04.nat.bt.com:61000");
        	
        	javax.naming.InitialContext ctx = new javax.naming.InitialContext(ht);
        	//javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("System.SUN1.ApplicationType.ServiceActivation.Application.1-0;4-7;ASAP.Comp.RPCDataSource");
        	javax.sql.DataSource ds = (javax.sql.DataSource) ctx.lookup("mimeDataSource");
        	ResultSet rs = null;
        	Statement st = null;
        	Connection conn = null;
        try {	
        	System.out.println("Now starts:" + dateTimeFormat.format(new Date(System.currentTimeMillis())) );
            conn = ds.getConnection();
            System.out.println("Connection received :" + dateTimeFormat.format(new Date(System.currentTimeMillis())) );
            //conn.setAutoCommit(false);
            //conn.setReadOnly(true);
            
            st = conn.createStatement();
            
            System.out.println("connection and statment is created" + conn);
            
            rs = st.executeQuery("SELECT 1 FROM DUAL");
            
            //connection = datasource.getConnection();
            // Set the sql select statement
            //String exch1141 = "GI/AMD";           
           // String sql = "SELECT A1141,NNI,TYPE,MNEMONIC,REF_TO_USE, ROPL_ID,ROPL_SPREADSHEET_ROW,ROPL_EXCHANGE_NAME,ROPL_EXCHANGE_1141,ROPL_SECTOR_NAME,ROPL_FIRST_CHOICE_1141,ROPL_FIRST_CHOICE_ROUTE_NAME,ROPL_SECOND_CHOICE_1141,ROPL_SECOND_CHOICE_ROUTE_NAME,ROPL_THIRD_CHOICE_1141,ROPL_THIRD_CHOICE_ROUTE_NAME,ROPL_POC_FLAG, NAME FROM TABLE(ANDES.A_GET_DLE_INFO_MK2(?))";
            //PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, "837");
            //ps.executeQuery();
            //rs = ps.getResultSet();
            System.out.println("Resultset " + rs);
            
            //ResultSet rs = st.executeQuery("SELECT * FROM TABLE(A_GET_DLE_INFO_mk2(571))");
            int i = 1;          
            while (rs.next())
            {
            	//System.out.println("Total columns: " + rs.getMetaData().getColumnCount());
            	//System.out.println("Total columns: ");
            	//for (int j = 1 ; j <= 2 ; j++)
            	//{
            		System.out.println( ":"+ rs.getString(1));            		
            	//}            		
            }
            System.out.println("Now ends:" + dateTimeFormat.format(new Date(System.currentTimeMillis())) );
        }
        catch(SQLException se)
        {
        	System.out.println("sql exception" + se.getMessage());
        	throw se;        	
        }
            finally
            {
            	if (conn!=null)
            	{
            		//conn.rollback();
	            	if (rs!=null)rs.close();
	            	if(st!=null) st.close();	            	
	            	conn.close();
	            	System.out.println("connection closed");
            	}
            }
        }
}



/*
 * Outout as follows
 * 
 * 
 * Now starts:2008.01.15-16.06:03 PM
Connection received :2008.01.15-16.06:12 PM
connection and statment is createdweblogic.jdbc.rmi.SerialConnection_weblogic_jdbc_rmi_internal_ConnectionImpl_weblogic_jdbc_wrapper_PoolConnection_oracle_jdbc_driver_T4CConnection_814_WLStub@1
Resultset weblogic.jdbc.rmi.SerialResultSet_weblogic_jdbc_rmi_internal_ResultSetStub_weblogic_jdbc_rmi_internal_ResultSetImpl_weblogic_jdbc_wrapper_ResultSet_oracle_jdbc_driver_OracleResultSetImpl_814_WLStub@7
:1
Now ends:2008.01.15-16.06:14 PM
connection closed
 */

