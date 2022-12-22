package affiche;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	JButton chose = new JButton("Choisir le fichier");
	JButton send = new JButton("Envoyer le fichier");
	JLabel finish = new JLabel("File send successfully");
	String path;
	public Fenetre() throws Exception {
		super();
		 try 
		  {
		   //JFrame f = new JFrame("Ajouter une image dans JPanel");
			 JLabel jb = new JLabel("Transferer et stocker vos fichier"); 
			 JPanel p = new JPanel();
			 p.setBackground(Color.CYAN);
			 p.add(jb, BorderLayout.CENTER);
			 p.setBounds(50, 5, 300, 50);
			 
			 JPanel far = new JPanel();
			 far.setBounds(25, 225, 400, 200);;
			
			 this.getFinish().setVisible(false);
			 this.getFinish().setBounds(90, 150, 150, 25);
			 Ecouteurs ec = new Ecouteurs(this);
			 JButton quit = new JButton("Quitter");
			 quit.addMouseListener(ec);
			 quit.setVisible(true);
			 quit.setBounds(80, 120, 150, 25);
			 this.getChose().addMouseListener(ec);
			 this.getChose().setBounds(80, 50, 150, 25);
			 this.getSend().addMouseListener(ec);
			 this.getSend().setBounds(80, 80, 150, 25);
			 this.getSend().setVisible(false);
			 far.add(this.getFinish());
			 far.add(quit);
			 //far.add(sr, BorderLayout.NORTH);
			 far.add(this.getChose());
			 far.add(this.getSend());
			 far.setLayout(null);
			 
			  JPanel panel = new JPanel();
			  panel.setBounds(50, 50, 300, 300);
			  BufferedImage img = ImageIO.read(new File("img\\transfert.jpg"));
			  JLabel pic = new JLabel(new ImageIcon(img));
			  panel.add(pic, BorderLayout.CENTER);
			  
			  this.add(p);
			  this.add(panel, BorderLayout.CENTER);
			  this.add(far, BorderLayout.LINE_END);
			  this.setSize(400, 500);
			  this.setLayout(null);
			  this.setVisible(true);
			  this.repaint();
			  this.revalidate();
		  } catch(Exception e) {
			  
		  }
	}
	public JButton getChose() {
		return chose;
	}
	public void setChose(JButton chose) {
		this.chose = chose;
	}
	public JButton getSend() {
		return send;
	}
	public void setSend(JButton send) {
		this.send = send;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public JLabel getFinish() {
		return finish;
	}
	public void setFinish(JLabel finish) {
		this.finish = finish;
	}
}
