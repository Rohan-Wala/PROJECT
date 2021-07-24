package com.hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DashBoard2 extends JFrame{

	JMenuBar mb ;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	
	DashBoard2() {
	
	mb = new JMenuBar();
	mb.setBounds(0, 0,1300,30);
	add(mb);
	
	m1 = new JMenu("Hotel Managenent");
	m1.setForeground(Color.getHSBColor(100, 150, 250));
	m1.setFont(new Font("Serif", Font.PLAIN,20));
	mb.add(m1);
	
	m2 = new JMenu("Menu");
	m2.setForeground(Color.DARK_GRAY);
	m2.setFont(new Font("Serif", Font.PLAIN,20));
	mb.add(m2);
	
	i1 = new JMenuItem("Reception");
	i1.setFont(new Font("Serif", Font.PLAIN,20));
	m1.add(i1);
	
	i2 = new JMenuItem("ADD employe");
	i2.setFont(new Font("Serif", Font.PLAIN,20));
	m2.add(i2);
	i3 = new JMenuItem("ADD room");
	i3.setFont(new Font("Serif", Font.PLAIN,20));
	m2.add(i3);
	i4 = new JMenuItem("ADD driver");
	i4.setFont(new Font("Serif", Font.PLAIN,20));
	m2.add(i4);
		
	ImageIcon ij = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/dashboard.jpg"));
	Image i = ij.getImage().getScaledInstance(1300,670,Image.SCALE_DEFAULT);
	ImageIcon ij2 = new ImageIcon(i);
	JLabel l2 = new JLabel(ij2);
	l2.setBounds(0, 0, 1300,670);
	add(l2);
	
	JLabel l3 = new JLabel("WE WELCOMES YOU...");
	l3.setBounds(400,50,900, 50);
	l3.setForeground(Color.WHITE);
	l3.setFont(new Font("Serif", Font.BOLD, 50));
	l2.add(l3);
	
	setBounds(-10, 0, 1300,700);
	setLayout(null);
	setVisible(true);
	}
	public static void main(String[] args) {
		new DashBoard2();
	}
}
