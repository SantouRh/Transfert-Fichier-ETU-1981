package clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Client extends Socket{
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    
    public Client(String path,String ServerHost) throws Exception {
    	super(ServerHost,5000);
    	  //try(Socket socket = new Socket("localhost",5001)) {
              dataInputStream = new DataInputStream(this.getInputStream());
              dataOutputStream = new DataOutputStream(this.getOutputStream());

              sendFile(path);
              //sendFile("path/to/file2.pdf");
              
              dataInputStream.close();
              dataInputStream.close();
              
    }
	
      
   

    private static void sendFile(String path) throws Exception{
        int bytes = 0;
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        
        // send file size
        dataOutputStream.writeUTF(file.getName());
        dataOutputStream.writeLong(file.length());  
        // break file into chunks
        byte[] buffer = new byte[4*1024];
        while ((bytes=fileInputStream.read(buffer))!=-1){
            dataOutputStream.write(buffer,0,bytes);
            dataOutputStream.flush();
        }
        fileInputStream.close();
    }
}