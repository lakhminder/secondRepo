package jms.queue;

import java.util.*;
import javax.jms.*;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This example shows how to establish a connection to a JMS
 * queue and browse (but not dequeue) the queued messages. The classes in this
 * package operate on the same JMS queue. Run the classes together to
 * observe messages being sent and received, and to browse the queue
 * for messages. This class is used to browse, but not remove, messages
 * in the queue.
 * <p>
 *
 * @author Copyright (c) 1999-2004 by BEA Systems, Inc. All Rights Reserved.
 */

public class QueueBrowse
{
  // Defines the JNDI context factory.
  public final static String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";

  // Defines the JMS connection factory for the queue.
 // public final static String JMS_FACTORY="weblogic.examples.jms.QueueConnectionFactory";
  public final static String JMS_FACTORY="/local/jms/connetionfactory/jmsfactory_1";

  // Defines the queue.
 // public final static String QUEUE="weblogic.examples.jms.exampleQueue";
  public final static String QUEUE="/local/jms/jms_server1/jms_queue1";

  private QueueConnectionFactory qconFactory;
  private QueueConnection qcon;
  private QueueSession qsession;
  private QueueBrowser qbrowser;
  private Queue queue;

  /**
   * Creates all the necessary objects for receiving
   * messages from a JMS queue.
   *
   * @param   ctx 	JNDI initial context
   * @param   queueName	 	name of queue
   * @exception NamingException if operation cannot be performed
   * @exception JMSException if JMS fails to initialize due to internal error
   */
  public void init(Context ctx, String queueName)
       throws NamingException, JMSException
  {
    qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_FACTORY);
    qcon = qconFactory.createQueueConnection();
    qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    queue = (Queue) ctx.lookup(queueName);
    qbrowser = qsession.createBrowser(queue);
    qcon.start();
  }

  /**
   * Displays the current contents of the queue.
   *
   * @exception JMSException if JMS fails to display messages on the queue due to internal error
   */
  public void displayQueue() throws JMSException {
    Enumeration e = qbrowser.getEnumeration();
    Message m = null;

    if (! e.hasMoreElements()) {
      System.out.println("There are no messages on this queue.");
    } else {
      System.out.println("Queued JMS Messages: ");
      while (e.hasMoreElements()) {
        m = (Message) e.nextElement();
        
        System.out.println("Message ID " + m.getJMSMessageID() +
                           " delivered " + new Date(m.getJMSTimestamp()) +
                           " to " + m.getJMSDestination());
       // System.out.println("Time : " + m.getJMSTimestamp());
        System.out.print("\tExpires        ");
        
        if (m.getJMSExpiration() > 0) {
          System.out.println( new Date( m.getJMSExpiration()));
        }
        else {
          System.out.println("never");
        }
        
        System.out.println("\tPriority       " + m.getJMSPriority());
        System.out.println("\tMode           " + (
                      m.getJMSDeliveryMode() == DeliveryMode.PERSISTENT ?
                                       "PERSISTENT" : "NON_PERSISTENT"));
        System.out.println("\tCorrelation ID " + m.getJMSCorrelationID());
        System.out.println("\tReply to       " + m.getJMSReplyTo());
        System.out.println("\tMessage type   " + m.getJMSType());
        
        if (m instanceof TextMessage) {
          System.out.println("\tTextMessage    \"" +
            ((TextMessage)m).getText() + "\"");
        }else {
        	System.out.println("\tTextMessage    \"" +
        			m.toString());
        }
      }
    }
  }

  /**
   * Closes JMS objects.
   *
   * @exception JMSException if JMS fails to close objects due to internal error
   */
  public void close() throws JMSException {
    qbrowser.close();
    qsession.close();
    qcon.close();
  }

  /**
   * main() method.
   *
   * @param  args WebLogic Server URL
   * @exception Exception if execution fails
   */

  public static void main(String[] args) throws Exception  {
   /* if (args.length != 1) {
      System.out.println("Usage: java examples.jms.queue.QueueBrowse WebLogicURL");
      return;
    }
    InitialContext ic = getInitialContext(args[0]);*/
	InitialContext ic = getInitialContext("t3://localhost:7001");
    QueueBrowse qb = new QueueBrowse();
    qb.init(ic, QUEUE);
    qb.displayQueue();
    qb.close();
  }

  private static InitialContext getInitialContext(String url)
    throws NamingException
  {
    Hashtable env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
    env.put(Context.PROVIDER_URL, url);
    return new InitialContext(env);
  }

}




