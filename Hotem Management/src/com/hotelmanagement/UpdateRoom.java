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

public class UpdateRoom extends JFrame implements ActionListener{
	Choice c1,c2;
	JTextField t1,t2,t3,d1,d2,d3;
	JButton b1,b2,b3,b4,b5;
	
	UpdateRoom() {
		 
		JLabel j1 = new JLabel("UPADTE ROOM STATUS");
		j1.setBounds(100, 10,200, 30);
		j1.setFont(new Font("tahoma", Font.PLAIN,15));
		j1.setForeground(Color.green);
		add(j1);
		
		JLabel j2 = new JLabel("GUEST ID");
		j2.setBounds(35, 80,120, 30);
		j2.setFont(new Font("tahoma", Font.PLAIN,15));
		j2.setForeground(Color.green);
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
		c1.setBounds(185, 80,140, 20);
		c1.setFont(new Font("tahoma", Font.PLAIN,15));
		c1.setForeground(Color.BLUE);
		add(c1);
		
		
		JLabel j3 = new JLabel("ROOM NUMER");
		j3.setBounds(35, 120,120, 30);
		j3.setFont(new Font("tahoma", Font.PLAIN,15));
		j3.setForeground(Color.green);
		add(j3);
		
		t1 = new JTextField();
		t1.setBounds(185, 120,140, 20);
		t1.setFont(new Font("tahoma", Font.PLAIN,15));
		t1.setForeground(Color.BLUE);
		add(t1);
		
		JLabel j4 = new JLabel("AVAILABLITY");
		j4.setBounds(35, 160,120, 30);
		j4.setFont(new Font("tahoma", Font.PLAIN,15));
		j4.setForeground(Color.green);
		add(j4);
		
		t2 = new JTextField();
		t2.setBounds(185, 160,140, 20);
		t2.setFont(new Font("tahoma", Font.PLAIN,15));
		t2.setForeground(Color.BLUE);
		add(t2);
		
		JLabel j5 = new JLabel("CLEANE STATUS");
		j5.setBounds(35, 200,120, 30);
		j5.setFont(new Font("tahoma", Font.PLAIN,15));
		j5.setForeground(Color.green);
		add(j5);
		
		t3 = new JTextField();
		t3.setBounds(185, 200,140, 20);
		t3.setFont(new Font("tahoma", Font.PLAIN,15));
		t3.setForeground(Color.BLUE);
		add(t3);
		
		b1 = new JButton("CHECK");
		b1.setBounds(200, 260,100, 20);
		b1.setFont(new Font("tahoma", Font.PLAIN,15));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("UPDATE");
		b2.setBounds(50, 260,100, 20);
		b2.setFont(new Font("tahoma", Font.PLAIN,15));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
	
		
		b3 = new JButton("BACK");
		b3.setBounds(340, 320,100, 20);
		b3.setFont(new Font("tahoma", Font.PLAIN,15));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/status.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(0,0, 400, 400);
		add(l3);
		
		//driver
		JLabel j6 = new JLabel("UPADTE DRIVER STATUS");
		j6.setBounds(500, 10,200, 30);
		j6.setFont(new Font("tahoma", Font.PLAIN,15));
		j6.setForeground(Color.green);
		add(j6);
		
		JLabel j7 = new JLabel("DRIVER ID");
		j7.setBounds(450, 80,120, 30);
		j7.setFont(new Font("tahoma", Font.PLAIN,15));
		j7.setForeground(Color.green);
		add(j7);
		
		c2 = new Choice();
		try {
			connect co = new connect();
			String s2 = "select * from driver";
			ResultSet rs2 = co.stmt.executeQuery(s2);
			while(rs2.next()) {
				c2.add(rs2.getString("id"));
				
			}
			
		} catch (Exception e) {}
		c2.setBounds(600, 80,140, 20);
		c2.setFont(new Font("tahoma", Font.PLAIN,15));
		c2.setForeground(Color.BLUE);
		add(c2);
		
		JLabel j8 = new JLabel("DRIVER NAME");
		j8.setBounds(450, 120,120, 30);
		j8.setFont(new Font("tahoma", Font.PLAIN,15));
		j8.setForeground(Color.green);
		add(j8);
		
		d1 = new JTextField();
		d1.setBounds(600, 120,140, 20);
		d1.setFont(new Font("tahoma", Font.PLAIN,15));
		d1.setForeground(Color.BLUE);
		add(d1);
		
		JLabel j9 = new JLabel("AVAILABLITY");
		j9.setBounds(450, 160,120, 30);
		j9.setFont(new Font("tahoma", Font.PLAIN,15));
		j9.setForeground(Color.green);
		add(j9);
		
		d2 = new JTextField();
		d2.setBounds(600, 160,140, 20);
		d2.setFont(new Font("tahoma", Font.PLAIN,15));
		d2.setForeground(Color.BLUE);
		add(d2);
		
		b4 = new JButton("CHECK");
		b4.setBounds(450, 260,100, 20);
		b4.setFont(new Font("tahoma", Font.PLAIN,15));
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.addActionListener(this);
		add(b4);
		
		b5 = new JButton("UPDATE");
		b5.setBounds(620, 260,100, 20);
		b5.setFont(new Font("tahoma", Font.PLAIN,15));
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.addActionListener(this);
		add(b5);
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(300, 170, 800, 400);
		setVisible(true);
	
	}
	 
	 public static void main(String[] args) {
		new UpdateRoom();
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String s1 = (String)c1.getSelectedItem();
			connect c = new connect();
			String room = null;
			try {
				ResultSet rs = c.stmt.executeQuery("select * from customer where number = '"+s1+"'");

				while(rs.next()) {
					t1.setText(rs.getString("room"));
					room = rs.getString("room");
				}
				ResultSet rs2 = c.stmt.executeQuery("select * from rooms where room_number = '"+room+"'");
				while(rs2.next()) {
					t2.setText(rs2.getString("available"));
					t3.setText(rs2.getString("status"));

				}
					
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(e.getSource() == b2) {
			connect co = new connect(); 
			try {
				
				String room = t1.getText();
				String avaliable = t2.getText();
				String status = t3.getText();
				
				String str = "update rooms set available = '"+avaliable+"', status = '"+status+"' where room_number = '"+room+"'";
				co.stmt.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "STATUS UPDATED");
				this.setVisible(false);
				new Reception();

				
			} catch (Exception e2) {
				
			}
			
		}else if(e.getSource() == b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == b4) {
		
			String s2 = (String)c2.getSelectedItem();
			connect c = new connect();
			String room = null;
			try {
				ResultSet rs2 = c.stmt.executeQuery("select * from driver where id = '"+s2+"'");

				while(rs2.next()) {
					d1.setText(rs2.getString("name"));
					d2.setText(rs2.getString("available"));
					
				}
//				ResultSet rs2 = c.stmt.executeQuery("select * from rooms where room_number = '"+room+"'");
//				while(rs2.next()) {
//					t2.setText(rs2.getString("avaliable"));
//					t3.setText(rs2.getString("status"));

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if (e.getSource()== b5) {
			connect co = new connect(); 
			try {
				
				String room = t1.getText();
				String name = d1.getText();
//				String available = d2.getText();
				
				String str = "update driver set available = 'available' where name = '"+name+"'";
				co.stmt.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "STATUS UPDATED");
				this.setVisible(false);
				new Reception();

				
			} catch (Exception e2) {
				
			}
			
			
		}
		
	}
}
