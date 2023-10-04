package email_client;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * This class use to send emails using command-line input and send birthday emails
 */
public class SendEmail{

	  public static ArrayList<SendEmail> sentMail= new ArrayList<>();
	  private String recipient;
	  private  String subject;
	  private  String msg;
	  private EmailDetails email;
	  
      Date date1 = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
      String today = formatter.format(date1);
      
	  public SendEmail(String recipient, String subject, String msg){
		  this.recipient = recipient;
		  this.subject = subject;
		  this.msg = msg;

		  //Creating new EmailDetails object
		  EmailDetails email = new EmailDetails(this.getRecipient(), this.getSubject(), this.getMessage(),this.getDate());
		  
		  //Serializing EmailDetails objects
		  Serialization.Serialize(email);
	  }

		public String getRecipient() {
			return recipient;
		}
		public String getSubject() {
			return subject;
		}
		public String getMessage() {
			return msg;
		}
		
		public String getDate() {
			return today;
		}

		public EmailDetails getEmail() {
			return email;
		}

		public void setEmail(EmailDetails email) {
			this.email = email;
		}
		
		
		
		  public void sendEmail() {
	  	      final String username = "tharangadarshani97@gmail.com";
	          final String password = "ombvmiwcrtidbzlf";
	          
	          Properties prop = new Properties();
			  prop.put("mail.smtp.host", "smtp.gmail.com");
	          prop.put("mail.smtp.port", "465");
	          prop.put("mail.smtp.auth", "true");
	          prop.put("mail.smtp.socketFactory.port", "465");
	          prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	          Session session = Session.getInstance(prop,
		                new javax.mail.Authenticator() {
	              @Override
				protected PasswordAuthentication getPasswordAuthentication() {
	                  return new PasswordAuthentication(username, password);
	              }
	          });
	          
	          try {

		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(username));
		            message.setRecipients(
		                    Message.RecipientType.TO,
		                    InternetAddress.parse(recipient)
		            );
		            message.setSubject(subject);
		            message.setText(msg);

		            Transport.send(message);
		            return;
	          }

	          catch (MessagingException e) {
	        	  e.printStackTrace();
	          }
			return;

		  }
}
