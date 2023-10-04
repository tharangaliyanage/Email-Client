package email_client;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalRecipient extends Recipient implements BirthdayGreetable {

	private String nick_name;
	private String birthday;

	public PersonalRecipient(String name, String nick_name, String email, String birthday) {
		super(name, email);
		this.nick_name = nick_name;
		this.birthday = birthday;

	}

	public void setNickname(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getNickname() {
		return nick_name;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthday() {
		return birthday;
	}

	@Override
	public String sendBirthdayGreeting() {
		String greeting = "hugs and love on your birthday. Tharanga";
		return greeting;
	}
	
	@Override
	public void addDetail() {
		pf_birthday_info.add(this);
	}
	
	//Method for send birthday greeting
	public static void sendGreetingpf() {

        PersonalRecipient element = null;
		for (PersonalRecipient element2 : pf_birthday_info) {
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

		PersonalRecipient element = null;
		int x = 0;
		
		//Traversing through the of_birthday_info list
		for (PersonalRecipient element2 : pf_birthday_info) {
        	element = element2;
            if (Birthday.subSequence(5, 10).equals(element.getBirthday().substring(5, 10))) {
            	System.out.print("Name - " + element.getName() + ", " + "email - " + element.getEmail() + ", " + "Birthday - " + element.getBirthday() + "\n");
            	x++;
            }
		}
        
		//If any recipient doesn't have birthday on given date
        if (x == 0) {
        	System.out.println("No personal friend recipient has birthday on given date");
        }
	}
}
