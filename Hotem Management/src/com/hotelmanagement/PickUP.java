package com.hotelmanagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class PickUP extends JFrame implements ActionListener{
	Choice c1,c2;
	JComboBox k1,k2;
	JButton b1,b2,b3;
	JTextField a1,a2,a3;
	JTable t1;
	PickUP() {
//		JLabel j1 = new JLabel("PICK UP ");
//		j1.setBounds(200, 10,300, 30);
//		j1.setFont(new Font("tahoma", Font.PLAIN,30));
//		j1.setForeground(Color.BLUE);
//		add(j1);
		
		JLabel j2 = new JLabel("TYPE OF CAR");
		j2.setBounds(35, 30,100, 30);
		j2.setFont(new Font("tahoma", Font.BOLD,15));
		j2.setForeground(Color.black);
		add(j2);
		
		c1 = new Choice();
		try {
			connect co = new connect();
			ResultSet rs = co.stmt.executeQuery("select * from driver");
			while(rs.next()) {
				c1.add(rs.getString("model"));
			}
			
		} catch (Exception e) {}
		c1.setBounds(200, 30,130, 30);
		c1.setFont(new Font("tahoma", Font.BOLD,15));
		c1.setForeground(Color.black);
		add(c1);
	
		
		t1 = new JTable();
		t1.setBounds(0, 80,700, 200);
		t1.setFont(new Font("tahoma", Font.PLAIN,15));
		t1.setForeground(Color.black);
		add(t1);
		
		JLabel j3 = new JLabel("NAME");
		j3.setBounds(10, 60,100, 15);
		j3.setFont(new Font("tahoma", Font.PLAIN,15));
		j3.setForeground(Color.black);
		add(j3);
		
		JLabel j4 = new JLabel("AGE");
		j4.setBounds(130, 60,100, 15);
		j4.setFont(new Font("tahoma", Font.PLAIN,15));
		j4.setForeground(Color.black);
		add(j4);
		
		JLabel j5 = new JLabel("GENDER");
		j5.setBounds(230, 60,100, 15);
		j5.setFont(new Font("tahoma", Font.PLAIN,15));
		j5.setForeground(Color.black);
		add(j5);
		
		JLabel j6 = new JLabel("PHONE");
		j6.setBounds(330, 60,100, 15);
		j6.setFont(new Font("tahoma", Font.PLAIN,15));
		j6.setForeground(Color.black);
		add(j6);
		
		JLabel j7 = new JLabel("MODEL");
		j7.setBounds(430, 60,100, 15);
		j7.setFont(new Font("tahoma", Font.PLAIN,15));
		j7.setForeground(Color.black);
		add(j7);
		
		JLabel j8 = new JLabel("LOCATION");
		j8.setBounds(520, 60,100, 15);
		j8.setFont(new Font("tahoma", Font.PLAIN,15));
		j8.setForeground(Color.black);
		add(j8);
		
		JLabel j9 = new JLabel("STATUS");
		j9.setBounds(620, 60,100, 15);
		j9.setFont(new Font("tahoma", Font.PLAIN,15));
		j9.setForeground(Color.black);
		add(j9);
		
//		a1 = new JTextField();
//		a1.setBounds(180, 300, 140, 25);
//		a1.setFont(new Font("tahoma", Font.BOLD, 20));
//		add(a1);
		
		JLabel j10 = new JLabel("CUSTOMER ID");
		j10.setBounds(40, 380,100, 15);
		j10.setFont(new Font("tahoma", Font.PLAIN,15));
		j10.setForeground(Color.black);
		add(j10);
		
		c2 = new Choice();
		try {
			connect co = new connect();
			ResultSet rs2 = co.stmt.executeQuery("select * from customer");
			while(rs2.next()) {
				c2.add(rs2.getString("number"));
			}
			
		} catch (Exception e) {}
		c2.setBounds(160, 380,130, 30);
		c2.setFont(new Font("tahoma", Font.BOLD,15));
		c2.setForeground(Color.black);
		add(c2);
		
		b1 = new JButton("SUBMIT");
		b1.setBounds(170, 300,140, 20);
		b1.setFont(new Font("tahoma", Font.PLAIN,15));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("BACK");
		b2.setBounds(400, 450,140, 20);
		b2.setFont(new Font("tahoma", Font.PLAIN,15));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("BOOK");
		b3.setBounds(170, 450,140, 20);
		b3.setFont(new Font("tahoma", Font.PLAIN,15));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		add(b3);
		
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		setBounds(400, 150, 700, 550);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PickUP();
	}

	
	public void actionPerformed(ActionEvent e) {
		connect co = new connect();
		if(e.getSource() == b1) {
			
			try {
				
				String s1 = "select * from driver where model = '"+ c1.getSelectedItem()+"'";
				
				ResultSet rs = co.stmt.executeQuery(s1);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
					
				
				
				
			} catch (Exception e2) {
				
			}
			
			
		}else if(e.getSource() == b2) {
			this.setVisible(false);
			new Reception();
		}
		
	}
}
