package email_client;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OfficialFriendRecipient extends Recipient implements BirthdayGreetable {
	
	private String designation;
	private String birthday;

	public OfficialFriendRecipient(String name, String email, String designation, String birthday) {
		super(name, email);
		this.designation = designation;
		this.birthday = birthday;

	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthday() {
		return birthday;
	}
	
	@Override
	public String sendBirthdayGreeting() {
		String greeting = "Wish you a Happy Birthday.  Tharanga";
		return greeting;
	}

	@Override
	public void addDetail() {
		of_birthday_info.add(this);
	}

	//Method for send birthday greeting
	public static void sendGreetingof() {

		OfficialFriendRecipient element = null;
		for (OfficialFriendRecipient element2 : of_birthday_info) {
        	element = element2;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String sentDate = formatter.format(date);
        	if (sentDate.subSequence(5, 10).equals(element.getBirthday().substring(5, 10))) {
        		SendEmail mail = new SendEmail(element.getEmail(),"Birthday Greeting",element.sendBirthdayGreeting());
        		mail.sendEmail();
        		
        	}

		}

	}

	//Method for print recipients who have birthday on given date
	public static void printRecipients(String Birthday) {

		OfficialFriendRecipient element = null;
		int x = 0;
		
		//Traversing through the of_birthday_info list
		for (OfficialFriendRecipient element2 : of_birthday_info) {
        	element = element2;
            if (Birthday.subSequence(5, 10).equals(element.getBirthday().substring(5, 10))) {
            	System.out.print("Name - " + element.getName() + ", " + "email - " + element.getEmail() + ", " + "Birthday - " + element.getBirthday() + "\n");
            	x++;
            }
		}
        
		//If any recipient doesn't have birthday on given date
        if (x == 0) {
        	System.out.println("No official friend recipient has birthday on given date");
        }
	}
}
