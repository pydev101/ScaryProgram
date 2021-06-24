package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

class gui extends JWindow{
	private static final long serialVersionUID = 4100287750750544839L;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	JLabel label = new JLabel();
	ImageIcon icon = new ImageIcon();
	
	public gui(double x, double y, double w, double h, float background, String fileName) {
		super();
		
		setSize((int)Math.floor(w*screenSize.getWidth()), (int)Math.floor(h*screenSize.getHeight()));
		setLocation((int)Math.floor(x*screenSize.getWidth()), (int)Math.floor(y*screenSize.getHeight()));
		
		//setUndecorated(true);
		getContentPane().setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		setBackground(new Color(0.0f,0.0f,0.0f,background));
		getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
		
		//icon = new ImageIcon("src/assets/images/"+fileName);
		icon = new ImageIcon(getClass().getClassLoader().getResource("assets/images/"+fileName));
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance((int)Math.floor(w*screenSize.getWidth()), (int)Math.floor(h*screenSize.getHeight()),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back
		
		label = new JLabel(icon);
		label.setSize((int)Math.floor(w*screenSize.getWidth()), (int)Math.floor(h*screenSize.getHeight()));
		add(label);
		
		setAlwaysOnTop(true);
	}
	
	public void changePos(double x, double y) {
		setLocation((int)Math.floor(x*screenSize.getWidth()), (int)Math.floor(y*screenSize.getHeight()));
	}

}