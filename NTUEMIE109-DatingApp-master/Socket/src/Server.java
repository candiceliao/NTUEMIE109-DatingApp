import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
public static final int LISTEN_PORT = 5987;
    
    public void listenRequest()
    {
        ServerSocket serverSocket = null;
        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        try
        {
            serverSocket = new ServerSocket( LISTEN_PORT );
            System.out.println("Server listening requests...");
            while ( true )
            {
                Socket socket = serverSocket.accept();
                threadExecutor.execute( new RequestThread( socket ) );
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        finally
        {
            if ( threadExecutor != null )
                threadExecutor.shutdown();
            if ( serverSocket != null )
                try
                {
                    serverSocket.close();
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
        }
    }
    
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        Server server = new Server();
        server.listenRequest();
    }
    
    /**
     * 處理Client端的Request執行續。
     *
     * @version
     */
    class RequestThread implements Runnable
    {
        private Socket clientSocket;
        
        public RequestThread( Socket clientSocket )
        {
            this.clientSocket = clientSocket;
        }
        
        /* (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run()
        {
            System.out.printf("有%s連線進來!\n", clientSocket.getRemoteSocketAddress() );
            DataInputStream input = null;
            DataOutputStream output = null;
            
            try
            {
                input = new DataInputStream( this.clientSocket.getInputStream() );
                output = new DataOutputStream( this.clientSocket.getOutputStream() );
                while ( true )
                {
                    output.writeUTF( String.format("Hi, %s!\n", clientSocket.getRemoteSocketAddress() ) );
                    output.flush();
                    // TODO 處理IO，這邊定義protocol協定！

                    break;
                }
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
            finally 
            {
                try
                {
                    if ( input != null )
                        input.close();
                    if ( output != null )
                        output.close();
                    if ( this.clientSocket != null && !this.clientSocket.isClosed() )
                        this.clientSocket.close();
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
