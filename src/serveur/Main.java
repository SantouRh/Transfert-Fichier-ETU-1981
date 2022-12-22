package serveur;

public class Main extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Server server = new Server();
			server.launch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
