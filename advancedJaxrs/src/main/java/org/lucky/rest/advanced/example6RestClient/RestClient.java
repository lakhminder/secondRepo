package org.lucky.rest.advanced.example6RestClient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.lucky.rest.advanced.example6RestClient.model.Message;

/**
 * Use the messenger project as Rest Application Server
 * Copy the model from messenger project(eg 9) locally
 * 
 *JAXRS 2.0 laid down the specifications for REst clients as well.
 *Before that many libraries does provide the support for rest client but 
 *with JAXRS 2.0 its more portable now.
 *
 *cast the httpResponsemessage using response.readEntity(x.class)
 *
 *see all versions below
 */
public class RestClient {

	public static void main(String[] args) {
		//version1();
		
		//version2();
		
		//version3();
		
		//makePostRequest();
		
		getAllMessages();
	}
	
	private static void version1(){
		Client client = ClientBuilder.newClient();// Can be used for multiple requests/targets
		
		Response response = client.target("http://localhost:8080/messenger/webapi/example9/messages/1")
				.request()//This gives builder
				.get();
		System.out.println(response);
		Message message = response.readEntity(Message.class);
		System.out.println(message.getMessage());
	}
	
	private static void version2(){
		Client client = ClientBuilder.newClient();
		
		Message message = client.target("http://localhost:8080/messenger/webapi/example9/messages/1")
				.request(MediaType.APPLICATION_JSON)//This puts accepts header value as text/json
				.get(Message.class);//Entity for directly unmarshalling For Debug purpose can use String.class
		System.out.println(message.getMessage());
	}
	
	/**
	 * As Best practise
	 */
	private static void version3(){
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/webapi/");
		WebTarget messageTarget = baseTarget.path("example9/messages");
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");// can be resolved dynamically
		
		Message message = singleMessageTarget
				.resolveTemplate("messageId", "1") //resolved here
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		Message message2 = singleMessageTarget
				.resolveTemplate("messageId", "2") //resolved here
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		System.out.println(message.getId());
		System.out.println(message2.getId());
		
	}
	
	private static void makePostRequest(){
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/webapi/");
		WebTarget messageTarget = baseTarget.path("example9/messages");
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");// can be resolved dynamically
		
		Message message = new Message(5, "mesage from post request", "me");
		Response res = messageTarget
				//.resolveTemplate("messageId", "1") 
				.request(MediaType.APPLICATION_JSON) // not necessary to set json for post/put
				.post(Entity.json(message));
		
		if(res.getStatus() != 200){
			throw new RuntimeException("Message was not created");
		}
		
		Message msg = res.readEntity(Message.class);
		System.out.println("Meesage created: "+ msg.getId() + msg.getMessage());
		
		//Now try put request to update same message
		msg.setMessage("updated message");
		res = singleMessageTarget
				.resolveTemplate("messageId", msg.getId()) 
				.request()
				.put(Entity.json(msg));
		
		if(res.getStatus() != 200){
			throw new RuntimeException("Message was not updated");
		}
		
		msg = res.readEntity(Message.class);
		System.out.println("Meesage updated: "+ msg.getId() + msg.getMessage());
	}
	
	/**
	 * Make Generic Type request like List<Message>
	 * use get(GenericType<T>) to let jersey know that its of generic type
	 * since GenericType constructor is protected it is subclassed inline(refer GenericType docs)
	 */
	private static void getAllMessages(){
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/webapi/");
		WebTarget messageTarget = baseTarget.path("example9/messages");
		List<Message> list = messageTarget
							.request()
							.get(new GenericType<List<Message>>(){});
		
		System.out.println(list);
		
	}

}
