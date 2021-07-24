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

public class Departmant extends JFrame implements ActionListener{
	
	JComboBox k1;
	JButton b1,b2;
	JTable t1;
	Departmant() {
		JLabel j1 = new JLabel("DEPARTMENT");
		j1.setBounds(200, 10,300, 30);
		j1.setFont(new Font("tahoma", Font.PLAIN,30));
		j1.setForeground(Color.BLUE);
		add(j1);
		
		
		
		t1 = new JTable();
		t1.setBounds(0, 100,700, 300);
		t1.setFont(new Font("tahoma", Font.PLAIN,15));
		t1.setForeground(Color.black);
		add(t1);
		
		JLabel j3 = new JLabel("Department");
		j3.setBounds(150, 70,100, 20);
		j3.setFont(new Font("tahoma", Font.PLAIN,15));
		j3.setForeground(Color.black);
		add(j3);
		
		JLabel j4 = new JLabel("Budget");
		j4.setBounds(430, 70,100, 20);
		j4.setFont(new Font("tahoma", Font.PLAIN,15));
		j4.setForeground(Color.black);
		add(j4);
		
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
		new Departmant();
	}

	
	public void actionPerformed(ActionEvent e) {
		connect co = new connect();
		if(e.getSource() == b1) {
			
			try {
				
				String s1 = "select * from department ";
				
				ResultSet rs = co.stmt.executeQuery(s1);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
		
			} catch (Exception e2) {}
			
			
		}else if(e.getSource() == b2) {
			this.setVisible(false);
			new Reception();
		}
		
	}
}
