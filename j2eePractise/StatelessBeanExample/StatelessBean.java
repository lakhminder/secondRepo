import javax.ejb.*;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.rmi.*;

public class StatelessBean implements SessionBean
{
	SessionContext ctx;

	public int sum(int a,int b)
	{
		return (a+b);
	}

	public void ejbCreate(){System.out.println("in ejbcreate ssss");}
	public void ejbRemove(){System.out.println("in ejbre");}
	public void ejbActivate(){System.out.println("in ejbac");}
	public void ejbPassivate(){System.out.println("in ejbpas");}
	public void setSessionContext(SessionContext ctx)
	{
		this.ctx=ctx;
	}
}