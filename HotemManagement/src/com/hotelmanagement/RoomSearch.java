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

import net.proteanit.sql.DbUtils;

public class RoomSearch extends JFrame implements ActionListener{
	JCheckBox c1;
	JComboBox k1;
	JButton b1,b2;
	JTable t1;
	RoomSearch() {
		JLabel j1 = new JLabel("SEARCH FOR ROOM");
		j1.setBounds(200, 10,300, 30);
		j1.setFont(new Font("tahoma", Font.PLAIN,30));
		j1.setForeground(Color.BLUE);
		add(j1);
		
		JLabel j2 = new JLabel("BED TYPE");
		j2.setBounds(35, 80,130, 30);
		j2.setFont(new Font("tahoma", Font.BOLD,15));
		j2.setForeground(Color.black);
		add(j2);
		
		k1 = new JComboBox(new String[] {"SINGLE","DOUBLE"});
		k1.setBounds(180, 80,130, 20);
		k1.setFont(new Font("tahoma", Font.PLAIN,15));
		k1.setForeground(Color.black);
		add(k1);
		
		c1= new JCheckBox("ONLY DISPLAY AVALIABLE");
		c1.setBounds(400, 80,220, 20);
		c1.setFont(new Font("tahoma", Font.PLAIN,15));
		c1.setForeground(Color.black);
		add(c1);
		
		t1 = new JTable();
		t1.setBounds(0, 140,700, 300);
		t1.setFont(new Font("tahoma", Font.PLAIN,15));
		t1.setForeground(Color.black);
		add(t1);
		
		JLabel j3 = new JLabel("ROOM NUMBER");
		j3.setBounds(10, 120,130, 15);
		j3.setFont(new Font("tahoma", Font.PLAIN,15));
		j3.setForeground(Color.black);
		add(j3);
		
		JLabel j4 = new JLabel("AVALIABLE");
		j4.setBounds(150, 120,130, 15);
		j4.setFont(new Font("tahoma", Font.PLAIN,15));
		j4.setForeground(Color.black);
		add(j4);
		
		JLabel j5 = new JLabel("STATUS");
		j5.setBounds(290, 120,130, 15);
		j5.setFont(new Font("tahoma", Font.PLAIN,15));
		j5.setForeground(Color.black);
		add(j5);
		
		JLabel j6 = new JLabel("PRICE");
		j6.setBounds(430, 120,130, 15);
		j6.setFont(new Font("tahoma", Font.PLAIN,15));
		j6.setForeground(Color.black);
		add(j6);
		
		JLabel j7 = new JLabel("BED TYPE");
		j7.setBounds(570, 120,130, 15);
		j7.setFont(new Font("tahoma", Font.PLAIN,15));
		j7.setForeground(Color.black);
		add(j7);
		
		
		
		
		b1 = new JButton("SUBMIT");
		b1.setBounds(170, 450,140, 20);
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
		
		
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		setBounds(400, 150, 700, 550);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RoomSearch();
	}

	
	public void actionPerformed(ActionEvent e) {
		connect co = new connect();
		if(e.getSource() == b1) {
			
			try {
				
				String s1 = "select * from rooms where bed_type = '"+ k1.getSelectedItem()+"'";
				String s2 = "select * from rooms where bed_type = '"+ k1.getSelectedItem()+"'AND avaliable = 'Avaliable' ";
				
				ResultSet rs = co.stmt.executeQuery(s1);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
				if(c1.isSelected()) {
					ResultSet rs2 = co.stmt.executeQuery(s2);
					t1.setModel(DbUtils.resultSetToTableModel(rs2));
					
				}
				
				
			} catch (Exception e2) {
				
			}
			
			
		}else if(e.getSource() == b2) {
			this.setVisible(false);
			new Reception();
		}
		
	}
}
