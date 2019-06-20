/*
 * Encrypt the file with the specified file path
 */
package encryption_software;


// Import packages
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Syed Yousuf
 */
public class EncryptFile 
{
    // Instance Variable
    private String FilePath;
    
    /*
    * Default Constructor
    */
    public EncryptFile(String FilePath)
    {
        this.FilePath = FilePath;
    }
    
    /*
    * Encrypt the file
    *
    */
    public void encryptFile()
    {
        // Local Variable list
        int byteRead;
        ArrayList<Integer> newByte = new ArrayList<Integer>();
        int indexNumber;
        
        try
        {
            InputStream inputStream = new FileInputStream(FilePath);
            
            // Encrypt the file 
            while((byteRead = inputStream.read() ) != -1)
            {
                // Make sure not to increase the new byte more than the value a byte can have.
                // A byte can have a min value of -128 and max value of 127
                if(byteRead > 127)
                {
                    // Do not increment
                    newByte.add(byteRead);
                }
                else
                {
                    // Increase the new byte value by one.
                    newByte.add(byteRead + 1);
                }
                
            }
            
            // Add each of the new byte of data into the output file.
            OutputStream outputStream = new FileOutputStream(FilePath);
            
            for(indexNumber = 0; indexNumber < newByte.size(); indexNumber++)
            {
                outputStream.write(newByte.get(indexNumber));
            }
            
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    /*
    * Decrypt the file from the specified file path
    */
    public void decryptFile()
    {
        // Local Variable list
        int byteRead;
        ArrayList<Integer> newByte = new ArrayList<Integer>();
        int indexNumber;
        
        try
        {
            InputStream inputStream = new FileInputStream(FilePath);
            
            
            // Encrypt the file 
            while((byteRead = inputStream.read() ) != -1)
            {
                // Make sure not to increase the new byte more than the value a byte can have.
                // A byte can have a min value of -128 and max value of 127
                if(byteRead > 127)
                {
                    // Do not increment
                    newByte.add(byteRead); 
                }
                else
                {
                    // Increase the new byte value by one.
                    newByte.add(byteRead - 1); 
                }
            }    
            
            // Add each of the new byte of data into the output file.
            OutputStream outputStream = new FileOutputStream(FilePath);

            for(indexNumber = 0; indexNumber < newByte.size(); indexNumber++)
            {
                outputStream.write(newByte.get(indexNumber));
            }
                
            
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    // Test Method
    public static void main(String[]args)
    {
        EncryptFile e1 = new EncryptFile("test2.doc");
        e1.encryptFile();
    }
    
    
        
    
}
