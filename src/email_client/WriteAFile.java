package email_client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * This class use to write details of all the recipients that created using command-line input
 */
public class WriteAFile {

	public static void writeFile(String line){
		
		FileWriter filewriter = null;
		BufferedWriter bufferwriter = null;
		try {
			filewriter = new FileWriter ("clientList.txt", true);
			bufferwriter = new BufferedWriter (filewriter);
			bufferwriter.write(line + "\n");
			

		}

		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		finally {
			try {
				
				//Closing the BufferedWriter
				bufferwriter.close();
				
				//Closing the FileWriter
				filewriter.close();
			}
			
			catch(IOException ex) {
				ex.printStackTrace();
			}			
		}
	}

}