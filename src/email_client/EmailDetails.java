package email_client;

import java.io.Serializable;
/*
 * This class creates serializable objects
 */
public class EmailDetails implements Serializable{
	
	private String recipient;
	private String subject;
	private String msg;
	private String today;

	public EmailDetails(String recipient, String subject, String msg, String today) {
		this.subject = subject;
		this.recipient = recipient;
		this.msg = msg;
		this.today = today;
	}

	
	public String getRecipient() {
		return recipient;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public String getDate() {
		return today;
	}
	
}
