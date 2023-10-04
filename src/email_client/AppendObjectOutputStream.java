package email_client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/*
 * This is a sub class of a ObjectOutputStream class which can override writeStreamHeader() method
 * to stop writing stream header after first object written in the file 
 */
public class AppendObjectOutputStream extends ObjectOutputStream {
	
	AppendObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }
 
	//Overriding writeStreamHeader() method in ObjectOutputStream class 
    public void writeStreamHeader() throws IOException
    {
        return;
    }
}