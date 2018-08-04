import javax.ejb.*;
import java.rmi.*;

public interface StatelessRem extends EJBObject
{
	public int sum(int a, int b) throws RemoteException;
}

















