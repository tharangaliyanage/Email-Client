package email_client;
/*
 * This class creates new recipients using command-line input
 */
public class CreateRecipient {

	public static void createRecipient(String line) {

	    String[] lineVector = line.split(" ");
	    String rec_type = lineVector[0];
	    String[] rec_info = lineVector[1].split(",");

	    if (rec_type.equals("Official:")) {
	  	  OfficialRecipient new_recipient = new OfficialRecipient(rec_info[0],rec_info[1],rec_info[2]);
	    }
	    
	    else if (rec_type.equals("Office_friend:")) {
	  	  OfficialFriendRecipient new_recipient = new OfficialFriendRecipient(rec_info[0],rec_info[1],rec_info[2],rec_info[3]);
	  	  new_recipient.addDetail();

	    }
	    else if (rec_type.equals("Personal:")) {
	  	  PersonalRecipient new_recipient = new PersonalRecipient(rec_info[0],rec_info[1],rec_info[2],rec_info[3]);
	  	  new_recipient.addDetail();

	    }


    }
}
