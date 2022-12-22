package affiche;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import clients.Client;

public class Ecouteurs implements MouseListener{
	Fenetre f;
	public Fenetre getF() {
		return f;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.getF().getChose()) {
			System.out.println("Choisir un fichier ");
			JFileChooser choose = new JFileChooser(
					FileSystemView
					.getFileSystemView()
					.getHomeDirectory());
			choose.setVisible(true);
			choose.setSize(300,300);

			// Ouvrez le fichier
			int res = choose.showOpenDialog(null);
			// Enregistrez le fichier
			// int res = choose.showSaveDialog(null);

			if (res == JFileChooser.APPROVE_OPTION) {
				File file = choose.getSelectedFile();
				System.out.println(file.getAbsolutePath());
				this.getF().setPath(file.getAbsolutePath());
				this.getF().getChose().setVisible(false);
				this.getF().getFinish().setVisible(false);
				this.getF().getSend().setVisible(true);
				this.getF().repaint();
				this.getF().revalidate();
			}
		}
		if (e.getSource() == this.getF().getSend()) {
			System.out.println("Envoie du fichier");		
			try {
				// ServerHost = localhost
				Client client = new Client(this.getF().getPath(),"localhost");
				this.getF().getChose().setVisible(true);
				this.getF().getFinish().setVisible(true);
				this.getF().getSend().setVisible(false);
				this.getF().repaint();
				this.getF().revalidate();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(new JFrame(), e1.getMessage(),"Probleme de connection",JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
			
		}
		if (e.getSource() instanceof JButton) {
			JButton btn = (JButton) e.getSource();
			if (btn.getText().contains("Quitter")) {
				System.out.println("Quitter le programme");
				System.exit(0);
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void setF(Fenetre f) {
		this.f = f;
	}

	public Ecouteurs(Fenetre f) {
		super();
		this.f = f;
	}
}
