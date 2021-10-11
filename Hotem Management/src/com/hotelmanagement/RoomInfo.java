package com.hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class RoomInfo extends JFrame implements ActionListener{

	JTable t1 ;
	JButton b1,b2;
	RoomInfo() {
	
		t1 = new JTable();
		t1.setBounds(0,30,420, 400);
		add(t1);
		
		
		b1 = new JButton("Load Data");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(200, 440,120, 20);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(400, 440,120, 20);
		b2.addActionListener(this);
		add(b2);
		
		JLabel j1  = new JLabel("ROOM NUMBER");
		j1.setBounds(5, 10, 90,10);
		j1.setFont(new Font("tahoma", Font.PLAIN, 10));
		add(j1);
		
		JLabel j2  = new JLabel("AVALABLE");
		j2.setBounds(90, 10, 90,10);
		j2.setFont(new Font("tahoma", Font.PLAIN, 10));
		add(j2);
		
		JLabel j3  = new JLabel("STATUS");
		j3.setBounds(180, 10, 90,10);
		j3.setFont(new Font("tahoma", Font.PLAIN, 10));
		add(j3);
		
		JLabel j4  = new JLabel("PRICE");
		j4.setBounds(270, 10, 90,10);
		j4.setFont(new Font("tahoma", Font.PLAIN, 10));
		add(j4);
		
		JLabel j5  = new JLabel("TYPE");
		j5.setBounds(360, 10, 90,10);
		j5.setFont(new Font("tahoma", Font.PLAIN, 10));
		add(j5);
		

		
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/ROOMINFO.jpg"));
		Image i2 = i1.getImage().getScaledInstance(350,400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); 
		JLabel i4 = new JLabel(i3);
		i4.setBounds(420, 30, 350, 400);
		add(i4);		
				
		getContentPane().setBackground(Color.WHITE );
		
		setLayout(null);
		setBounds(230, 150, 800, 520);
		setVisible(true);

	}
	
	
	public static void main(String[] args) {
		new RoomInfo();
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			try {
				connect co4 = new connect();
				String str = "select * from rooms";
				ResultSet rs = co4.stmt.executeQuery(str);
				
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			
				
			} catch (Exception e2) {
				
			}
			
		}else if(e.getSource() == b2) {
			this.setVisible(false);
			new Reception().setVisible(true);
		}
	}

}
