package com.hotelmanagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCheck extends JFrame implements ActionListener{
	
	JButton b1,b2,b3;
	Choice c1;
	JTextField t1,t2,t3,t4,t5,t6;
	
	UpdateCheck() {
		
		JLabel j1 = new JLabel("CHECK-IN DETAILS");
		j1.setBounds(100, 10,200, 30);
		j1.setFont(new Font("tahoma", Font.PLAIN,15));
		j1.setForeground(Color.black);
		add(j1);
		
		JLabel j2 = new JLabel("CUSTOMER ID");
		j2.setBounds(35, 80,130, 30);
		j2.setFont(new Font("tahoma", Font.PLAIN,15));
		j2.setForeground(Color.black);
		add(j2);
		
		c1 = new Choice();
		try {
			connect co = new connect();
			String s = "select * from Customer";
			ResultSet rs = co.stmt.executeQuery(s);
			while(rs.next()) {
				c1.add(rs.getString("number"));
				
			}
			
		} catch (Exception e) {}
		c1.setBounds(220, 80,140, 20);
		c1.setFont(new Font("tahoma", Font.PLAIN,15));
		c1.setForeground(Color.BLUE);
		add(c1);
		
		JLabel j3 = new JLabel("ROOM NUMER");
		j3.setBounds(35, 120,130, 30);
		j3.setFont(new Font("tahoma", Font.PLAIN,15));
		j3.setForeground(Color.black);
		add(j3);
		
		t1 = new JTextField();
		t1.setBounds(220, 120,140, 20);
		t1.setFont(new Font("tahoma", Font.PLAIN,15));
		t1.setForeground(Color.BLUE);
		add(t1);
		
		JLabel j4 = new JLabel("NAME");
		j4.setBounds(35, 160,130, 30);
		j4.setFont(new Font("tahoma", Font.PLAIN,15));
		j4.setForeground(Color.black);
		add(j4);
		
		t2 = new JTextField();
		t2.setBounds(220, 160,140, 20);
		t2.setFont(new Font("tahoma", Font.PLAIN,15));
		t2.setForeground(Color.BLUE);
		add(t2);
		
		JLabel j5 = new JLabel("CHECK IN");
		j5.setBounds(35, 200,130, 30);
		j5.setFont(new Font("tahoma", Font.PLAIN,15));
		j5.setForeground(Color.black);
		add(j5);
		
		t3 = new JTextField();
		t3.setBounds(220, 200,140, 20);
		t3.setFont(new Font("tahoma", Font.PLAIN,15));
		t3.setForeground(Color.BLUE);
		add(t3);
		
		JLabel j6 = new JLabel("AMOUNT PAID");
		j6.setBounds(35, 240,130, 30);
		j6.setFont(new Font("tahoma", Font.PLAIN,15));
		j6.setForeground(Color.black);
		add(j6);
		
		t4 = new JTextField();
		t4.setBounds(220, 240,140, 20);
		t4.setFont(new Font("tahoma", Font.PLAIN,15));
		t4.setForeground(Color.BLUE);
		add(t4);
		
		JLabel j7 = new JLabel("PENDING AMOUNT");
		j7.setBounds(35, 280,130, 30);
		j7.setFont(new Font("tahoma", Font.PLAIN,15));
		j7.setForeground(Color.black);
		add(j7);
		
		t5 = new JTextField();
		t5.setBounds(220, 280,140, 20);
		t5.setFont(new Font("tahoma", Font.PLAIN,15));
		t5.setForeground(Color.BLUE);
		add(t5);
		
		JLabel j8 = new JLabel("ROOM PRICE");
		j8.setBounds(35, 320,130, 30);
		j8.setFont(new Font("tahoma", Font.PLAIN,15));
		j8.setForeground(Color.black);
		add(j8);
		
		t6 = new JTextField();
		t6.setBounds(220, 320,140, 20);
		t6.setFont(new Font("tahoma", Font.PLAIN,15));
		t6.setForeground(Color.BLUE);
		add(t6);
		
		b1 = new JButton("CHECK");
		b1.setBounds(135, 360,100, 20);
		b1.setFont(new Font("tahoma", Font.PLAIN,15));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("UPDATE");
		b2.setBounds(50, 400,100, 20);
		b2.setFont(new Font("tahoma", Font.PLAIN,15));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("BACK");
		b3.setBounds(220, 400,100, 20);
		b3.setFont(new Font("tahoma", Font.PLAIN,15));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/checkinout.png"));
		Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(400,0, 400, 500);
		add(l3);
		
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		setBounds(400, 170, 800, 500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new UpdateCheck();
	}


	
	public void actionPerformed(ActionEvent e) {
		connect c = new connect();
		if(e.getSource() == b1) {
			String s1 = (String)c1.getSelectedItem();
			
			String room = null;
			String deposit = null;
			int amountpaid;
			String price = null;
			try {
				ResultSet rs = c.stmt.executeQuery("select * from customer where number = '"+s1+"'");

				while(rs.next()) {
					t1.setText(rs.getString("room"));
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("status"));
					t4.setText(rs.getString("deposit"));
					room = rs.getString("room");
					deposit = rs.getString("deposit");
				}
				
				ResultSet rs2 = c.stmt.executeQuery("select * from rooms where room_number = '"+ room +"'");
				while(rs2.next()) {
					
					price = rs2.getString("price");
					amountpaid = Integer.parseInt(price) - Integer.parseInt(deposit) ;
					t5.setText(Integer.toString(amountpaid));
					t6.setText(rs2.getString("price"));
				}
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(e.getSource() == b2) {
			String price = null;
			String s1 = (String)c1.getSelectedItem();
			String room = null;
			try {
				
					room = t1.getText();
					price = t6.getText();
				
				 c.stmt.executeUpdate(" update customer set status = '"+"CHECK IN"+"',deposit = '"+price+"' where room = '"+ room+"'");	
				JOptionPane.showMessageDialog(null, "CUSTOMER IS CHICK IN");
					
			} catch (Exception e2) {
				
			}
			
		}else if(e.getSource() == b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
}
