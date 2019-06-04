import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	 public static void main( String[] args ) throws IOException
	    {
	        String host = "";
	        int port = 5987;
	        Socket socket = null;
	        Scanner consoleInput = new Scanner( System.in );
	        System.out.println("½Ð¿é¤JServerºÝ¦ì§}");
	        host = consoleInput.nextLine();
	        try
	        {
	            socket = new Socket( host, port );
	            DataInputStream input = null;
	            DataOutputStream output = null;
	            
	            try
	            {
	                input = new DataInputStream( socket.getInputStream() );
	                output = new DataOutputStream( socket.getOutputStream() );
	                while ( true )
	                {
	                    System.out.println( input.readUTF() );
	                    break;
	                }
	            }
	            catch ( IOException e )
	            {
	            }
	            finally 
	            {
	                if ( input != null )
	                    input.close();
	                if ( output != null )
	                    output.close();
	            }
	        }
	        catch ( IOException e )
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            if ( socket != null )
	                socket.close();
	            if ( consoleInput != null )
	                consoleInput.close();
	        }
	    }
}
