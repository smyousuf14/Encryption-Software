/*
 * Encrypt the file with the specified file path
 */
package encryption_software;


// Import packages
import java.io.*;

/**
 *
 * @author Syed Yousuf
 */
public class EncryptFile 
{
    // Instance Variable
    private String inputFilePath;
    private String outputFilePath;
    
    /*
    * Default Constructor
    */
    public EncryptFile(String inputFilePath,String outputFilePath)
    {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }
    
    /*
    * Encrypt the file
    *
    */
    public void encryptFile()
    {
        // Local Variable list
        int byteRead;
        int NewByte;
        
        try
        {
            InputStream inputStream = new FileInputStream(inputFilePath);
            OutputStream outputStream = new FileOutputStream(outputFilePath);
            
            // Encrypt the file 
            while((byteRead = inputStream.read() ) != -1)
            {
                // Make sure not to increase the new byte more than the value a byte can have.
                // A byte can have a min value of -128 and max value of 127
                if(byteRead > 127)
                {
                    // Do not increment
                    NewByte = byteRead;
                }
                else
                {
                    // Increase the new byte value by one.
                    NewByte = byteRead + 1;
                }
                
                outputStream.write(NewByte);
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
        int NewByte;
        
        try
        {
            InputStream inputStream = new FileInputStream(outputFilePath);
            OutputStream outputStream = new FileOutputStream("output2.txt");
            
            // Encrypt the file 
            while((byteRead = inputStream.read() ) != -1)
            {
                // Make sure not to increase the new byte more than the value a byte can have.
                // A byte can have a min value of -128 and max value of 127
                if(byteRead > 127)
                {
                    // Do not increment
                    NewByte = byteRead;
                }
                else
                {
                    // Increase the new byte value by one.
                    NewByte = byteRead - 1;
                }
                
                outputStream.write(NewByte);
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
        EncryptFile e1 = new EncryptFile("test1.txt", "output1.txt");
        e1.decryptFile();
    }
    
    
        
    
}
