package main;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main {
	public static void main(String[] args) {
		System.out.println("STARTT");
		/*
		try {
			Robot test = new Robot();
			JFrame fram = new JFrame();
			fram.setLocationRelativeTo(null);
			fram.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			fram.setUndecorated(true);
			fram.getContentPane().setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
			fram.setBackground(new Color(0.0f,0.0f,0.0f,0.5f));
			//fram.setVisible(true);
			wait(1000);
			System.out.println("TEST");
			test.mouseMove(1800, 10);
			test.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			test.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			wait(3000);
			System.out.println("KILL");
			fram.dispose();
		}catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		Main instance = new Main();
		while(true) {
			int t = rand(0,5);
			if(t<1) {
				JFrame fram = new JFrame();
				fram.setLocationRelativeTo(null);
				fram.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				fram.setUndecorated(true);
				fram.getContentPane().setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
				fram.setBackground(new Color(0.0f,0.0f,0.0f,1));
				fram.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
				
				ImageIcon icon = new ImageIcon(instance.getClass().getClassLoader().getResource("assets/images/scary.png"));
				JLabel label = new JLabel(icon);
				fram.add(label);
				
				Clip cA = GetSound("laugh.wav");
				cA.start();
				fram.setVisible(true);
				try{Thread.sleep(cA.getMicrosecondLength()/1000);}catch(InterruptedException e){e.printStackTrace();}
				cA.stop();
				cA.close();
				fram.setVisible(false);
				fram.dispose();
			}else if(t < 4) {
				Clip c = GetSound("scaryAmb.wav");
				c.start();
				wait(15000);
				c.stop();
				c.close();
			}else if(t < 6) {
				gui x = new gui(0.75,0.8,0.25,0.25,0,"skull.png");
				for(int i=0; i<3; i++) {
					x.setVisible(true);
					wait(250);
					x.setVisible(false);
					wait(250);
				}
				x.dispose();
			}
			wait(rand(60000,600000));
		}
	}

	static void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static Clip GetSound(String fileName) {
		Main instance = new Main();
		//instance.getClass().getResourceAsStream()
		InputStream soundFile = instance.getClass().getResourceAsStream("/assets/sounds/"+fileName);
		InputStream bufferedIn = new BufferedInputStream(soundFile);
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(bufferedIn));
			return clip;
			//clip.start();
			//Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	static int rand(int l, int h) {
		return (int) Math.floor(Math.random() * (h - l + 1) + l);
	}
}
