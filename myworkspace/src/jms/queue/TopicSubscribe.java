package jms.queue;

import java.util.Hashtable;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



/**
 * This example shows how to establish a connection to
 * and receive messages from a JMS queue. The classes in this
 * package operate on the same JMS queue. Run the classes together to
 * witness messages being sent and received, and to browse the queue
 * for messages.  This class is used to receive and remove messages
 * from the queue.
 *
 * @author Copyright (c) 1999-2004 by BEA Systems, Inc. All Rights Reserved.
 */
public class TopicSubscribe implements MessageListener {
	// Defines the JNDI context factory.
	public final static String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

	// Defines the JMS connection factory for the queue.
	//public final static String JMS_FACTORY="weblogic.examples.jms.QueueConnectionFactory";
	public final static String JMS_FACTORY = "System.SUN1.ApplicationType.ServiceActivation.Application.1-0;4-7;ASAP.Comp.TopicConnectionFactory";
	//public final static String JMS_FACTORY = "com/bt/csam/mda/mdaCsamConnectionFactory";

	// Defines the queue.
	//public final static String QUEUE = "mslv/oms/oms1/internal/jms/events";
	public final static String TOPIC = "System.SUN1.ApplicationType.ServiceActivation.Application.1-0;4-7;ASAP.Comp.XVTEventTopic";
	//public final static String QUEUE = "com/bt/csam/nrs/nrsxmlQueue";
	//public final static String QUEUE = "com/bt/csam/mda/csamMdaReceiveQueue";
	//public final static String QUEUE = "com/bt/andes/mime/xmlQueue";
	//public final static String QUEUE = "System.SUN1.ApplicationType.ServiceActivation.Application.1-0;5-2;ASAP.Comp.MessageQueue";
	

	private TopicConnectionFactory topicFactory;

	private TopicConnection topicConnection;

	private TopicSession topicSession;

	private TopicSubscriber topicSubscriber;

	private Topic topic;

	private boolean quit = false;

	/**
	 * Message listener interface.
	 * @param msg  message
	 */
	public void onMessage(Message msg) {
		try {
			String msgText;
			if (msg instanceof TextMessage) {
				System.out.println("entered for text");
				msgText = ((TextMessage) msg).getText();
			} else if (msg instanceof BytesMessage) {
				System.out.println("entered for byte message");
				BytesMessage byteMsg = (BytesMessage) msg;
				byte[] receivedBytes = new byte[4000];
				//byte[] receivedBytes = byteMsg.GETbY;
				byteMsg.readBytes(receivedBytes);
				msgText = new String(receivedBytes);
			} else if (msg instanceof ObjectMessage) {
				System.out.println("entered for object message");
				ObjectMessage objMsg = (ObjectMessage) msg;
				msgText = objMsg.toString();

			} else {
				msgText = msg.toString();
			}

			System.out.println("Message Received: " + msgText);

			if (msgText.equalsIgnoreCase("quit")) {
				synchronized (this) {
					quit = true;
					this.notifyAll(); // Notify main thread to quit
				}
			}
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		}
	}

	/**
	 * Creates all the necessary objects for receiving
	 * messages from a JMS queue.
	 *
	 * @param   ctx	JNDI initial context
	 * @param	queueName	name of queue
	 * @exception NamingException if operation cannot be performed
	 * @exception JMSException if JMS fails to initialize due to internal error
	 */
	public void init(Context ctx, String topicName) throws NamingException,
			JMSException {
		topicFactory = (TopicConnectionFactory) ctx.lookup(JMS_FACTORY);
		topicConnection = topicFactory.createTopicConnection();
		topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ctx.lookup(topicName);
		System.out.println("topic name:"+topic.getTopicName());
		topicSubscriber=topicSession.createSubscriber(topic);
		topicSubscriber.setMessageListener(this);
		System.out.println("topic associated with subscriber:"+topicSubscriber.getTopic());
		topicConnection.start();
	}

	/**
	 * Closes JMS objects.
	 * @exception JMSException if JMS fails to close objects due to internal error
	 */
	public void close() throws JMSException {
		//qreceiver.close();
		topicSubscriber.close();
		topicSession.close();
		topicConnection.close();
	}

	/**
	 * main() method.
	 *
	 * @param args  WebLogic Server URL
	 * @exception  Exception if execution fails
	 */

	public static void main(String[] args) throws Exception {
		/*if (args.length != 1) {
		 System.out.println("Usage: java examples.jms.queue.QueueReceive WebLogicURL");
		 return;
		 }
		 InitialContext ic = getInitialContext(args[0]);*/
		InitialContext ic = getInitialContext("t3://172.25.63.2:61000");
		TopicSubscribe qr = new TopicSubscribe();
		qr.init(ic, TOPIC);
		System.out.println("connected to topic");
		System.out
				.println("JMS Ready To Receive Messages (To quit, send a \"quit\" message).");

		// Wait until a "quit" message has been received.
		synchronized (qr) {
			while (!qr.quit) {
				try {
					qr.wait();
				} catch (InterruptedException ie) {
				}
			}
		}
		qr.close();
	}

	private static InitialContext getInitialContext(String url)
			throws NamingException {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);
	}

}
