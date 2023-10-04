package email_client;

/*
 * This is a sub class of Recipient abstract class
 */
public class OfficialRecipient extends Recipient{
	private String designation;

	public OfficialRecipient(String name, String email,String designation){
		super(name,email);
		this.designation = designation;

	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
	}

}
