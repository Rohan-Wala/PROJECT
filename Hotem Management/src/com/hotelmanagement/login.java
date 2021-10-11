package com.hotelmanagement;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.AEADBadTagException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener {

	JLabel l1, l2,l3,l4;
	JTextField t1, t2;
	JButton b1, b2;

	login() {
		
		
		
		l1 = new JLabel("Username");
		l1.setForeground(Color.WHITE);
		l1.setBounds(40,30, 100, 30);
		add(l1);
		
		l2 = new JLabel("Password");
		l2.setForeground(Color.WHITE);
		l2.setBounds(40, 70, 100, 30);
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150, 30, 100, 30);
		add(t1);
		
		t2 = new JPasswordField();
		t2.setBounds(150, 70, 100, 30);
		add(t2);
		
		
		b1 = new JButton("login"); 
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(40,150,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel"); 
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(170,150,120,30);
		b2.addActionListener(this);
		add(b2);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(0,0, 600, 300);
		add(l3);
		
		ImageIcon i9 =  new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/loginpage.png"));
		Image i8=i9.getImage().getScaledInstance(200,170,Image.SCALE_DEFAULT);
		ImageIcon i7 = new ImageIcon(i8);
		l4 = new JLabel(i7);
		l4.setBounds(340,50,200,170);
		l3.add(l4);
		
		
		
//		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(500, 300, 600, 300);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String username = t1.getText();
			String password	= t2.getText();	
			
			connect co = new connect();
			String str = "select * from login where username ='" + username +"' and password ='"+ password +"'";
			try {
				ResultSet rs =  co.stmt.executeQuery(str);
				if(rs.next()) {
					new DashBoard().setVisible(true);
					this.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"not present");
					this.setVisible(false);
					new login();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else if(ae.getSource() == b2){
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		login g = new login();
	}

	
	

}
