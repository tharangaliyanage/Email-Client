package email_client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * This class reads the clientList.txt file and creates recipient objects using details in the file
 */
public class ReadAFile{

	public static void readFile() {

		try {
			FileReader filereader = new FileReader ("clientList.txt");
			BufferedReader bufferreader = new BufferedReader (filereader);
			String line = null;
			
			//Creating new recipients by reading the "clientList.txt" file
			while ((line = bufferreader.readLine()) != null) {
				CreateRecipient.createRecipient(line);
			}
			
			//Closing the BufferedReader 
			bufferreader.close();
			
			//Closing the FileReader 
			filereader.close();
		}
		catch(FileNotFoundException e) {
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
