package email_client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * This class use to serialize EmailDetails objects
 */
public class Serialization {
	
    public static void  Serialize(EmailDetails mail) {
    	
    	//Creating a new file "SentMails.ser"
    	File f = new File("C:\\Users\\thara\\eclipse-workspace\\email_client\\SentMails.ser");
    	try {
    		
			f.createNewFile();
		} 
    	
    	catch (IOException e1) {
			
			e1.printStackTrace();
		}
    	

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        AppendObjectOutputStream oos1 = null;
        if (mail != null) {
        	
            try {

                // Creating an new FileOutputStream object
                fos = new FileOutputStream("SentMails.ser", true);
 
                // If there is nothing written in the file
                if (f.length() == 0) {
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(mail);
                    oos.close();
                }
 
                else {
 
                    oos1 = new AppendObjectOutputStream(fos);
                    oos1.writeObject(mail);

                }
 

            }

            catch (Exception e) {
            	
            	e.printStackTrace();
            }
            
            finally {
            	try {
                        		
                    // Closing the ObjectOutputStream
                    oos1.close();
                    // Closing the AppendObjectOutputStream
                    oos1.close();
                    
                    // Closing the FileOutputStream
                    fos.close();            		
            	}
                catch (Exception e) {
                	
                	e.printStackTrace();
                }            	
            }
            
        }
    }
}

