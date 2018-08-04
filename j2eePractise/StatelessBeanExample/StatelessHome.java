import javax.ejb.EJBHome;
import javax.ejb.CreateException;
import java.rmi.RemoteException;

public interface StatelessHome extends EJBHome
{
	public StatelessRem create() throws RemoteException, CreateException;
}

















