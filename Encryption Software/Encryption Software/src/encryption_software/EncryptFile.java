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
                NewByte = byteRead + 1;
                outputStream.write(NewByte);
            }
        }
        catch(IOException ex)
        {
            
        }
    }
    
    
        
    
}
