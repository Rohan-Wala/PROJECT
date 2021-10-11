package com.hotelmanagement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

	JTable t1;
	JButton b1, b2;

	CustomerInfo() {
		t1 = new JTable();
		t1.setBounds(0,30, 1100, 400);
		add(t1);
		
		JLabel j1 = new JLabel("ID TYPE");
		j1.setBounds(40,10,120, 20);
		add(j1); 
		
		JLabel j2 = new JLabel("NUMBER");
		j2.setBounds(180,10,120, 20);
		add(j2);
		
		JLabel j3 = new JLabel("NAME");
		j3.setBounds(320,10,120, 20);
		add(j3);
		
		JLabel j4 = new JLabel("GENDER");
		j4.setBounds(460,10,120, 20);
		add(j4);
		
		JLabel j5 = new JLabel("COUNTRY");
		j5.setBounds(600,10,120, 20);
		add(j5);
		
		JLabel j6 = new JLabel("ROOM");
		j6.setBounds(740,10,120, 20);
		add(j6);
		
		JLabel j7 = new JLabel("STATUS");
		j7.setBounds(880,10,120, 20);
		add(j7);
		
		JLabel j8 = new JLabel("DEPOSIT");
		j8.setBounds(1010,10,120, 20);
		add(j8);
		
		
		b1 = new JButton("Load Data");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(300, 440,120, 20);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(500, 440,120, 20);
		b2.addActionListener(this);
		add(b2);
		

		setLayout(null);
		setBounds(230, 150, 1100, 520);
		setVisible(true);

	}

	public static void main(String[] args) {
		new CustomerInfo();
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			try {
				connect co4 = new connect();
				String str = "select * from customer";
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
