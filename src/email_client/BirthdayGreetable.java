package email_client;

import java.util.ArrayList;

public interface BirthdayGreetable {
	
	//Creating arraylist for add all the PersonalRecipient objects
	public static ArrayList<PersonalRecipient> pf_birthday_info = new ArrayList<>();
	
	//Creating arraylist for add all the OfficialFriendRecipient objects
	public static ArrayList<OfficialFriendRecipient> of_birthday_info = new ArrayList<>();

	//Method for send birthday greetings
	public String sendBirthdayGreeting();

	//Method for add recipient objects to the arraylist 
	public void addDetail();
}
