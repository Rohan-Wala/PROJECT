package com.hotelmanagement;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener{

	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	
	Reception() {
		
		b1 = new JButton("New Customer Form");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(20,20,200, 20);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("ROOM");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(20,50,200, 20);
		b2.addActionListener(this);
		add(b2);
		
//		b3 = new JButton("DEPERTMENT");
//		b3.setBackground(Color.BLACK);
//		b3.setForeground(Color.WHITE);
//		b3.setBounds(20, 90,200, 20);
//		b3.addActionListener(this);
//		add(b3);
		
		b4 = new JButton("ALL EMPLOYEE INFO");
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setBounds(20, 90,200, 20);
		b4.addActionListener(this);
		add(b4);
		
		b5 = new JButton("Customer INFO");
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.setBounds(20, 130,200, 20);
		b5.addActionListener(this);
		add(b5);
		
		b6 = new JButton("MANAGER INFO");
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.setBounds(20, 170,200, 20);
		b6.addActionListener(this);
		add(b6);
		
		b7= new JButton("CKECK OUT");
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.setBounds(20, 210,200, 20);
		b7.addActionListener(this);
		add(b7);
		
		b8 = new JButton("CHECK IN  STSTUS");
		b8.setBackground(Color.BLACK);
		b8.setForeground(Color.WHITE);
		b8.setBounds(20, 250,200, 20);
		b8.addActionListener(this);
		add(b8);
		
		b9 = new JButton("UPDATE ROOM STATUS");
		b9.setBackground(Color.BLACK);
		b9.setForeground(Color.WHITE);
		b9.setBounds(20, 290,200, 20);
		b9.addActionListener(this);
		add(b9);
		
		
		b10 = new JButton("PICH UP SERVICE");
		b10.setBackground(Color.BLACK);
		b10.setForeground(Color.WHITE);
		b10.setBounds(20, 330,200, 20);
		b10.addActionListener(this);
		add(b10);
		
		b11 = new JButton("SEARCH ROOM");
		b11.setBackground(Color.BLACK);
		b11.setForeground(Color.WHITE);
		b11.setBounds(20, 370,200, 20);
		b11.addActionListener(this);
		add(b11);
		
		b12 = new JButton("LOG OUT");
		b12.setBackground(Color.BLACK);
		b12.setForeground(Color.WHITE);
		b12.setBounds(20, 410,200, 20);
		b12.addActionListener(this);
		add(b12);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/HotelReception.jpg"));
		Image i2 = i1.getImage().getScaledInstance(750, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(0, 0, 750, 550);
		add(l1);
		
		
	//	getContentPane().setBackground(Color.WHITE);
//		setUndecorated(true);
//		setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		setLayout(null);
		setBounds(350, 170, 750, 550);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Reception();
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			new AddCustomer().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == b2) {
			new RoomInfo().setVisible(true);
			this.setVisible(false);
//		}else if(e.getSource() == b3) {
//			new Departmant().setVisible(true);
//			this.setVisible(false);
		}else if(e.getSource() == b4) {
			new EmployeeInfo().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == b5) {
			new CustomerInfo().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == b6) {
			new ManagerInfo().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == b7) {
			new CheckOut().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == b8) {
			new UpdateCheck().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == b9) {
			new UpdateRoom().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == b10) {
			new PickUP().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == b11) {
			new RoomSearch().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == b12) {
			setVisible(false);
		}
			
		
		
	}
}
