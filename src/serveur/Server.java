package serveur;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends ServerSocket {
    public Server() throws IOException {
		super(5000);
		// TODO Auto-generated constructor stub
	}


	private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    public void launch() throws Exception {
        
        //System.out.println("Server Waiting...");
    	int t = 0;
    	while(true) {
    		System.out.println("Server Waiting...");
            Socket clientSocket = this.accept();
            System.out.println(clientSocket+" connected.");
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            
            receiveFile();
            t++;
            dataInputStream.close();
            dataOutputStream.close();
            clientSocket.close();
    	}
    }

  
	private static void receiveFile() throws Exception{
        int bytes = 0;
        String  str=(String)dataInputStream.readUTF();
		//System.out.println(str);
		String[] gettyp=str.split("[.]");
		System.out.println(str);
		String path="C:\\Transfert_Fichier_1981\\file1\\";
		if (str.contains("png")||str.contains("jpeg")||str.contains("jpg")) {
			path = path+"Photos";
		}
		else if (str.contains("mp3")) {
			path = path+"Musics";
		}
		else if (str.contains("mp4")) {
			path = path+"Videos";
		}else {
			path = path+"Others";
		}
		
		File f = new File(path);
		f.mkdirs();
		FileOutputStream fileOutputStream = new FileOutputStream(f+"\\"+str);
        long size = dataInputStream.readLong();     // read file size
        byte[] buffer = new byte[4*1024];
        bytes = dataInputStream.read(buffer, 0, (int)Math.min(buffer.length, size));
        int[] bytess = new int[2];
        bytess[0] = bytes/2;
        bytess[1] = bytes/2;
        while (size > 0 && bytes != -1) {
            fileOutputStream.write(buffer,0,bytes);
            size -= bytes;      // read upto file size
        }
        fileOutputStream.close();
    }
}