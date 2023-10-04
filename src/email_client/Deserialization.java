package email_client;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/*
 * This class reads objects from SentMails.ser file and add them to sentMail arraylist
 * and
 * Prints all the emails sent on a date specified by user input
 */
public class Deserialization {
	
	//Creating arraylist for add all the EmailDetails objects 
	public static ArrayList<EmailDetails> sentMail= new ArrayList<EmailDetails>();
	
	public static void readObjectFromFile(String date) {
		
    	ObjectInputStream oin = null;
    	FileInputStream fin = null;

        try {
        	sentMail.clear();
        	// Creating an new FileInputStream object
        	fin = new FileInputStream("SentMails.ser");
        	
        	// Creating an new ObjectInputStream object
        	oin = new ObjectInputStream(fin);
        	
        	//Loop while file has to read more objects 
        	while(fin.available() > 0) {
        		
        		EmailDetails mail = (EmailDetails)oin.readObject();
        		sentMail.add(mail);
        		
        	}     
        	
     	
            
        }catch(EOFException e) {
        
        } 
        
        catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        finally {
        	try {
            	// Closing the ObjectInputStream
            	oin.close();
            	
            	// Closing  FileInputStream
            	fin.close();           		
        	}
        	
        	catch (IOException e) {
    			e.printStackTrace();        		
        	}
        }

	}
	
	public static void printEmails(String date) {
		
		int x = 0;
		for (EmailDetails element2 : sentMail) {
			if(element2.getDate().equals(date)) {
				System.out.println("Sent Date: " + element2.getDate() + ", Email Adress: " + element2.getRecipient() + ", Subject: " + element2.getSubject() + ", Content: " +  element2.getMsg());
				x++;
			}
		}
		
		if (x == 0) {
			System.out.println("No email was sent on the given date");
		}
	}
}
