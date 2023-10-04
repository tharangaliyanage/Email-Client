package email_client;
//200100K
/*
 * This is a command-line based email client
 * clientList.txt file contains all the details of the recipients
 * SentMail.ser file contains all the serialised objects of EmailDetails class 
 */

//import libraries
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email_Client {

      public static void main(String[] args) {
    	  
    	  StartEmailClient sec = new StartEmailClient();
    	  
    	  /*
    	   * This method officially starts the email client
    	   */
    	  sec.start();
    	  
    	  while(true) {

                Scanner scanner = new Scanner(System.in);
                
	            System.out.println("Enter option type: \n"
	                  + "1 - Adding a new recipient\n"
	                  + "2 - Sending an email\n"
	                  + "3 - Printing out all the recipients who have birthdays\n"
	                  + "4 - Printing out details of all the emails sent\n"
	                  + "5 - Printing out the number of recipient objects in the application");

                int option = scanner.nextInt();

			    switch(option){
			    	case 1:
			    		// input format - Official: nimal,nimal@gmail.com,ceo
			            // Use a single input to get all the details of a recipient
			            // code to add a new recipient
			              Scanner sc1 = new Scanner(System.in);
			              String line;
			              line = sc1.nextLine();
			              WriteAFile.writeFile(line);
			              CreateRecipient.createRecipient(line);

	                      // store details in clientList.txt file
	                      // Hint: use methods for reading and writing files
	                      break;
	                  case 2:
	                      // input format - email, subject, content
	                	  // code to send an email
	                	  Scanner sc2 = new Scanner(System.in);
	                      String line2 = sc2.nextLine();
	                      String[] lineVector2;
	                      lineVector2 = line2.split(",");
	                      String email = lineVector2[0];
					      String subject = lineVector2[1];
					      String content = lineVector2[2];
	                	  SendEmail mail = new SendEmail(email, subject, content);
	                	  mail.sendEmail();

	                      break;
	                  case 3:
	                      // input format - yyyy/MM/dd (ex: 2018/09/17)
	                	  // code to print recipients who have birthdays on the given date
	                	  Scanner sc3 = new Scanner(System.in);
	                	  String Birthday = sc3.nextLine();
	                	  OfficialFriendRecipient.printRecipients(Birthday);;
	                	  PersonalRecipient.printRecipients(Birthday);;

	                      break;
	                  case 4:
	                      // input format - yyyy/MM/dd (ex: 2018/09/17)
	                      // code to print the details of all the emails sent on the input date
	                	  Scanner sc4 = new Scanner(System.in);
	                	  String date = sc4.nextLine();
	                	  Deserialization.readObjectFromFile(date);
	                	  Deserialization.printEmails(date);
	                      break;
	                  case 5:
	                      // code to print the number of recipient objects in the application
	                	  System.out.println("Number of recipients: " + Recipient.getMembers());
	                	  
	                      break;
	            }

			            // start email client
			            // code to create objects for each recipient in clientList.txt
			            // use necessary variables, methods and classes



			}

      }

}

// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)