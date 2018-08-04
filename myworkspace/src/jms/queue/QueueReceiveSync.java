package jms.queue;

import java.util.Hashtable;
import javax.jms.*;
import javax.naming.*;
import java.util.Date;

/*
 * 
 * This is for synchronous receipt of messages.
 * else use message listener to receive messages asynchronously. 
 */
class QueueReceiveSync
{
	private static final String QUEUE="/local/jms/jms_server1/jms_queue1";
	private static final String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";
	private static final String JMS_FACTORY="/local/jms/connetionfactory/jmsfactory_1";
	
	private QueueConnectionFactory qconfactory;
	private QueueConnection qcon;
	private QueueSession qsession;
	private Queue queue;
	private QueueReceiver qreceiver;
	private InitialContext ic;
	
	public static void main(String args[])
	{
		QueueReceiveSync qr=new QueueReceiveSync();
		qr.init();
		qr.receive();		
		qr.close();
	}
	
	private InitialContext getInitialContext(String url)
	throws NamingException//InitialContext() throws NamingException or either call InitialContext()in try catch block
	{
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);//InitialContext() throws NamingException
		
	}
	
	private void init()
	{
		try
		{
			//ic=qr.getInitialContext("t3://localhost:7001");  //qr cannot be resolved
			ic=this.getInitialContext("t3://localhost:7001");
			//ic=getInitialContext("t3://localhost:7001");
			qconfactory = (QueueConnectionFactory) ic.lookup(JMS_FACTORY);
			queue = (Queue) ic.lookup(QUEUE);
			qcon = qconfactory.createQueueConnection();
			qsession = qcon.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			qreceiver = qsession.createReceiver(queue);
			qcon.start();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void receive()
	//throws JMSException
	{
		try
		{
			Message m = qreceiver.receive();
			System.out.println("Message was Delivered at: " + new Date(m.getJMSTimestamp()));
			if(m instanceof TextMessage)
			{				
				System.out.println("TextMessage is : " + ((TextMessage) m).getText());
				
			}else
			{
				System.out.println("Message is : " + m.toString());
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void close()
	//throws Exception
	{
		try
		{qreceiver.close();
	    qsession.close();
	    qcon.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
