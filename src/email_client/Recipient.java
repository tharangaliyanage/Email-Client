package email_client;

/*
 * This is the parent class of official, official friend, personal friend classes
 */
public abstract class Recipient {

	private String name;
	private String email;
	private static int members = 0;


	public Recipient(String name, String email){
		this.name = name;
		this.email = email;
		members = members+1;

	}

	public static int getMembers() {
		return members;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
