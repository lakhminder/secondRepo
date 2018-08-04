package Demo;
/** A simple bean that has a single String property
* called message.
*/
public class StringBean {
private String message = "No message specified";
public String getMessage() {
return(message);
}
public void setMessage(String message) {
this.message = message;
}
}