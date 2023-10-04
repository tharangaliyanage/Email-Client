package email_client;
/*
 * This class use to officially start the apllication
 */
public class StartEmailClient {
	
	public void start() {
	
	  ReadAFile.readFile();
	  
	  //Send birthday greetings to official friends who has birthday today
	  OfficialFriendRecipient.sendGreetingof();
	  //Send birthday greetings to personal friends who has birthday today
	  PersonalRecipient.sendGreetingpf();

	}
}
