package com.hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HotelManagenetSystem  extends JFrame implements ActionListener{
	
	public HotelManagenetSystem() {
		setBounds(100,100, 1280, 537);
		JLabel j1 = new JLabel(new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/homepage.jpg")));
		j1.setBounds(0,0,1280,537);
		add(j1);
		
		JLabel j2 = new JLabel("Hotel Management System");
		j2.setBounds(20, 350,1000, 200);
		j2.setForeground(Color.LIGHT_GRAY);
		j2.setFont(new Font("serim",Font.PLAIN,70));
		j1.add(j2);
		
		
		JButton b1 = new JButton(new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/next.jpg")));
		b1.setBounds(1100,50,90,40);
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.WHITE);
		b1.setFont(new Font("serim",Font.PLAIN,30));
		b1.addActionListener(this);
		j1.add(b1);
		
		
		
		
		setLayout(null);
		setVisible(true);
		
		while (true) {
			
			//j2.setVisible(false);
			j2.setForeground(Color.blue);
			try { 
				Thread.sleep(300);
			} catch (Exception e) {}
			
			//j2.setVisible(true);
			j2.setForeground(Color.RED);
			try {
				Thread.sleep(300);
			} catch (Exception e) {}
			
			j2.setForeground(Color.DARK_GRAY);
			try {
				Thread.sleep(300);
			} catch (Exception e) {}
			
		}
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		new login().setVisible(true);
		this.setVisible(false);
		
	}
	
	public static void main(String[] args) {
		new HotelManagenetSystem();
	}

	
	

	
	
}
