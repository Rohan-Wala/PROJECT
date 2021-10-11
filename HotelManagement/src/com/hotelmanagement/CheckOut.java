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

public class CheckOut extends JFrame  implements ActionListener{

	Choice c1 ;
	JTextField t1,t2;
	JButton b1,b2,b3;
	
	public CheckOut() {

		JLabel j1 = new JLabel("CHECK OUT");
		j1.setBounds(100, 10,200, 30);
		j1.setFont(new Font("tahoma", Font.PLAIN,30));
		j1.setForeground(Color.BLUE);
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
		
		JLabel j3 = new JLabel("ROOM NUMBER");
		j3.setBounds(35, 120,130, 30);
		j3.setFont(new Font("tahoma", Font.PLAIN,15));
		j3.setForeground(Color.black);
		add(j3);
		
		t1 = new JTextField();
		t1.setBounds(220, 120,140, 20);
		t1.setFont(new Font("tahoma", Font.PLAIN,15));
		t1.setForeground(Color.BLUE);
		add(t1);
		
		JLabel j4 = new JLabel("PENDING AMOUNT");
		j4.setBounds(35, 160,130, 30);
		j4.setFont(new Font("tahoma", Font.PLAIN,15));
		j4.setForeground(Color.black);
		add(j4);
		
		t2 = new JTextField();
		t2.setBounds(220, 160,140, 20);
		t2.setFont(new Font("tahoma", Font.PLAIN,15));
		t2.setForeground(Color.BLUE);
		add(t2);
		
		b1 = new JButton("CHECK OUT");
		b1.setBounds(35, 210,140, 20);
		b1.setFont(new Font("tahoma", Font.PLAIN,15));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("BACK");
		b2.setBounds(220, 210,140, 20);
		b2.setFont(new Font("tahoma", Font.PLAIN,15));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/tick.jpg"));
		Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		//JLabel l3 = new JLabel(i3);
		b3 = new JButton(i3);
		b3.setBounds(370, 80,20, 20);
		b3.addActionListener(this);
		add(b3);

		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		setBounds(400, 250, 600, 340);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CheckOut();
	}

	
	public void actionPerformed(ActionEvent e) {
		connect co1 = new connect();
		if(e.getSource() == b1) {
			
			String id  = c1.getSelectedItem();
			String room = t1.getText();
			String del = "delete from customer where number = '"+ id+"'";
			String Uroom = "update rooms set avaliable = 'Avaliable',status = 'Dirty' where room_number = '"+ room+"'";
			try {
				co1.stmt.executeUpdate(del);
				co1.stmt.executeUpdate(Uroom);
				JOptionPane.showMessageDialog(null, "CHECK OUT DONE");
				this.setVisible(false);
				new Reception();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	 }else if(e.getSource() == b3) {
		 String s1 = (String)c1.getSelectedItem();
		 String price = null;
		 String room = null;
		 String deposit = null;
		 
		 try {
			ResultSet rs = co1.stmt.executeQuery("select * from customer where number = '"+ s1+"'");
			while(rs.next()) {
				t1.setText(rs.getString("room"));
				room = rs.getString("room");
				deposit = rs.getString("deposit");
				
			}
			
			ResultSet rs2 = co1.stmt.executeQuery("select * from rooms where room_number = '"+ room +"'");
			while(rs2.next()) {
				
				price = rs2.getString("price");
				
				int amountpending = Integer.parseInt(price) - Integer.parseInt(deposit);
				
				t2.setText(Integer.toString(amountpending));
			}
			
		 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 }else if(e.getSource() == b2) {
		 new Reception().setVisible(true);
		 this.setVisible(false);
	 }
		
	}
}
