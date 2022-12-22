package affiche;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Mainn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Fenetre();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		JFileChooser choose = new JFileChooser(
//		        FileSystemView
//		        .getFileSystemView()
//		        .getHomeDirectory()
//		    );
//		    // Ouvrez le fichier
//		    int res = choose.showOpenDialog(null);
//		    // Enregistrez le fichier
//		    // int res = choose.showSaveDialog(null);
//		    if (res == JFileChooser.APPROVE_OPTION) {
//		      File file = choose.getSelectedFile();
//		      System.out.println(file.getAbsolutePath());
//		    }
		
	}

}
