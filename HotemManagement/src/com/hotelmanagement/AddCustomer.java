package com.hotelmanagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Stack;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2;
	JComboBox c1,c2;
	JRadioButton r1,r2;
	Choice c;
	
	AddCustomer() {
	
		JLabel j1 = new JLabel("New Customer Info");
		j1.setBounds(100, 10,200, 30);
		j1.setFont(new Font("tahoma", Font.PLAIN,15));
		j1.setForeground(Color.BLUE);
		add(j1);
		
		
		JLabel j2 = new JLabel("ID TYPE");
		j2.setBounds(35, 80,100, 30);
		j2.setFont(new Font("tahoma", Font.PLAIN,15));
		j2.setForeground(Color.BLUE);
		add(j2);
		
		c1 = new JComboBox(new String[] {"Passport","voter id card","Driving licence","Aadhaar card"});
		c1.setBounds(220, 80 ,140, 20);
		c1.setFont(new Font("tahoma", Font.PLAIN,15));
		c1.setForeground(Color.blue);
		add(c1);
		
		JLabel j3 = new JLabel("ID NUMBER");
		j3.setBounds(35, 120,100, 30);
		j3.setFont(new Font("tahoma", Font.PLAIN,15));
		j3.setForeground(Color.BLUE);
		add(j3);
		
		t1 = new JTextField();
		t1.setBounds(220, 120,140, 20);
		t1.setFont(new Font("tahoma", Font.PLAIN,15));
		t1.setForeground(Color.BLUE);
		add(t1);
		
		
		JLabel j4 = new JLabel("NAME");
		j4.setBounds(35, 160,100, 30);
		j4.setFont(new Font("tahoma", Font.PLAIN,15));
		j4.setForeground(Color.BLUE);
		add(j4);
		
		t2 = new JTextField();
		t2.setBounds(220, 160,140, 20);
		t2.setFont(new Font("tahoma", Font.PLAIN,15));
		t2.setForeground(Color.BLUE);
		add(t2);
		
		JLabel j5 = new JLabel("GENDER");
		j5.setBounds(35, 200,100, 30);
		j5.setFont(new Font("tahoma", Font.PLAIN,15));
		j5.setForeground(Color.BLUE);
		add(j5);
		
		r1 = new JRadioButton("Male");
		r1.setBounds(220, 200,60, 20);
		r1.setFont(new Font("tahoma", Font.PLAIN,15));
		r1.setForeground(Color.BLUE);
		add(r1);
		
		r2 = new JRadioButton("FeMale");
		r2.setBounds(280, 200,80, 20);
		r2.setFont(new Font("tahoma", Font.PLAIN,15));
		r2.setForeground(Color.BLUE);
		add(r2);
		
		ButtonGroup g = new ButtonGroup();
		g.add(r1);
		g.add(r2);
		
		JLabel j6 = new JLabel("Phone No.");
		j6.setBounds(35, 240,100, 30);
		j6.setFont(new Font("tahoma", Font.PLAIN,15));
		j6.setForeground(Color.BLUE);
		add(j6);
		
		t3 = new JTextField();
		t3.setBounds(220, 240,140, 20);
		t3.setFont(new Font("tahoma", Font.PLAIN,15));
		t3.setForeground(Color.BLUE);
		add(t3);
		
		JLabel j7 = new JLabel("Allocated Room Number");
		j7.setBounds(35, 280,160, 30);
		j7.setFont(new Font("tahoma", Font.PLAIN,15));
		j7.setForeground(Color.BLUE);
		add(j7);
		
		c = new Choice();
		try {
			connect co6 = new connect();
			String s = "select * from rooms where avaliable = 'Avaliable' and status = 'Cleaned'";
			ResultSet rs = co6.stmt.executeQuery(s);
			while(rs.next()) {
				c.add(rs.getString("room_number"));
				
			}
			
		} catch (Exception e) {}
			
		
		c.setBounds(220, 280,140, 20);
		c.setFont(new Font("tahoma", Font.PLAIN,15));
		c.setForeground(Color.BLUE);
		add(c);
		
		JLabel j8 = new JLabel("Checked IN");
		j8.setBounds(35, 320,100, 30);
		j8.setFont(new Font("tahoma", Font.PLAIN,15));
		j8.setForeground(Color.BLUE);
		add(j8);
		
		t4 = new JTextField();
		t4.setBounds(220, 320,140, 20);
		t4.setFont(new Font("tahoma", Font.PLAIN,15));
		t4.setForeground(Color.BLUE);
		add(t4);
		
		JLabel j9 = new JLabel("Deposit");
		j9.setBounds(35, 360,100, 30);
		j9.setFont(new Font("tahoma", Font.PLAIN,15));
		j9.setForeground(Color.BLUE);
		add(j9);
		
		t5 = new JTextField();
		t5.setBounds(220, 360,140, 20);
		t5.setFont(new Font("tahoma", Font.PLAIN,15));
		t5.setForeground(Color.BLUE);
		add(t5);
		
		b1 = new JButton("ADD");
		b1.setBounds(40, 400,100, 20);
		b1.setFont(new Font("tahoma", Font.PLAIN,15));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("CANCLE");
		b2.setBounds(220, 400,100, 20);
		b2.setFont(new Font("tahoma", Font.PLAIN,15));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/checkin.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(400, 50, 500, 300);
		add(l1);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(300, 170, 950, 500);
		setVisible(true);
		}
	
	public static void main(String[] args) {
		new AddCustomer();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			String id = (String)c1.getSelectedItem();
			String number = t1.getText();
			String name = t2.getText();
			String gender = null;
			if(r1.isSelected()) {
				gender = "Male";
			}else if(r2.isSelected()) {
				gender = "FeMale";
			}
			String phone = t3.getText();
			String room = (String)c.getSelectedItem();
			String  status= t4.getText();
			String deposit = t5.getText();
			
			String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+phone+"','"+room+"','"+status+"','"+deposit+"')";
			String str2 = "update rooms set avaliable = 'Occupide' where room_number = '"+room+"'";
			connect co1 = new connect();
			try {
				co1.stmt.executeUpdate(str);
				co1.stmt.executeUpdate(str2);
				JOptionPane.showMessageDialog(null, "NEW CUSROMER ADDED");
				
				this.setVisible(false);
				new AddCustomer();
			} catch (Exception e2) {
				
			}
		}else if(e.getSource() == b2 ) {
			this.setVisible(false);
			new Reception().setVisible(true);
			
		}
		
	}

}
