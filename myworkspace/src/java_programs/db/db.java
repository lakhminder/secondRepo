import java.sql.*;

 public class db
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("jdbc:odbc:dsn1");
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into emp values('sdgf',2)");
			ResultSet rs=st.executeQuery("select * from emp");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getInt(2));		
			}
			st.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println("H" + e );
		}

	}
}
