/*
 * Copies a file.
 */
package encryption_software;

/*Import packages*/
import java.io.*;

/**
 *
 * @author Syed Yousuf
 */
public class CopyFiles 
{
    
    /*Test Main method*/
    public static void main(String[]args)
    {
        String inputfile = "test1.txt";
        String outputfile = "output1.txt";
        
        try
        {
            InputStream inputStream = new FileInputStream(inputfile);
            OutputStream outputStream = new FileOutputStream(outputfile);
            
            int byteRead;
            
            while((byteRead = inputStream.read() ) != -1)
            {
                System.out.println(byteRead);
                outputStream.write(byteRead);
            }
            
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
}
