package com.hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDriver extends JFrame implements ActionListener {

	JTextField t1, t2, t3, t4, t5 ,t6;
	JComboBox c1, c2, c3;
	JButton b1, b2;

	AddDriver() {
//		JLabel title = new JLabel("ADD DRIVER");
//		title.setBounds(100, 20, 140, 30);
//		title.setFont(new Font("tahoma", Font.BOLD, 20));
//		add(title);

		
		JLabel name = new JLabel("Name");
		name.setBounds(60, 100, 100, 20);
		name.setFont(new Font("tahoma", Font.PLAIN, 20));
		add(name);

		t1 = new JTextField();
		t1.setBounds(180, 100, 140, 25);
		t1.setFont(new Font("tahoma", Font.BOLD, 20));
		add(t1);

		JLabel age = new JLabel("Age");
		age.setBounds(60, 140, 100, 25);
		age.setFont(new Font("tahoma", Font.PLAIN, 20));
		add(age);

		t2 = new JTextField();
		t2.setBounds(180, 140, 140, 25);
		t2.setFont(new Font("tahoma", Font.BOLD, 20));
		add(t2);

		JLabel gender = new JLabel("Gender");
		gender.setBounds(60, 180, 100, 20);
		gender.setFont(new Font("tahoma", Font.PLAIN, 20));
		add(gender);

		c1 = new JComboBox(new String[] { "Male", "Female" });
		c1.setBounds(180, 180, 140, 20);
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("tahoma", Font.PLAIN, 15));
		add(c1);

		JLabel car = new JLabel("Phone No.");
		car.setBounds(60, 220, 100, 20);
		car.setFont(new Font("tahoma", Font.PLAIN, 20));
		add(car);

		t3 = new JTextField();
		t3.setBounds(180, 220, 140, 25);
		t3.setFont(new Font("tahoma", Font.BOLD, 20));
		add(t3);

		JLabel model = new JLabel("CAR Model");
		model.setBounds(60, 260, 100, 20);
		model.setFont(new Font("tahoma", Font.PLAIN, 20));
		add(model);

		t4 = new JTextField();
		t4.setBounds(180, 260, 140, 25);
		t4.setFont(new Font("tahoma", Font.BOLD, 20));
		add(t4);

		JLabel location = new JLabel("Location");
		location.setBounds(60, 300, 100, 20);
		location.setFont(new Font("tahoma", Font.PLAIN, 20));
		add(location);

		t5 = new JTextField();
		t5.setBounds(180, 300, 140, 25);
		t5.setFont(new Font("tahoma", Font.BOLD, 20));
		add(t5);

		JLabel available = new JLabel("Available");
		available.setBounds(60, 340, 100, 20);
		available.setFont(new Font("tahoma", Font.PLAIN, 20));
		add(available);

		c2 = new JComboBox(new String[] { "Available", "BUSSY" });
		c2.setBounds(180, 340, 140, 20);
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("tahoma", Font.PLAIN, 15));
		add(c2);

		b1 = new JButton("ADD");
		b1.setBounds(60, 380, 100, 20);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setFont(new Font("tahoma", Font.PLAIN, 15));
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Cancle");
		b2.setBounds(180, 380, 100, 20);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setFont(new Font("tahoma", Font.PLAIN, 15));
		b2.addActionListener(this);
		add(b2);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/car.jpg"));
		Image i2 = i1.getImage().getScaledInstance(890,500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(330,0, 890, 500);
		add(l1);

		getContentPane().setBackground(Color.black);
		setLayout(null);
		setBounds(300, 150, 890, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new AddDriver().setVisible(true);
		;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			
			String name = t1.getText();
			String age = t2.getText();
			String gender = (String)c1.getSelectedItem();
			String phone = t3.getText();
			String model = t4.getText();
			String location = t5.getText();
			String available = (String)c2.getSelectedItem();
			
			connect co4 = new connect();
			
			if(name.equals("")) {
				 JOptionPane.showMessageDialog(null,"WTF enter that field");	
			}else {
			
			
			String str2 = "insert into Driver(name,age,gender,phone,model,location,available) values('"+ name +"','"+ age +"','"+ gender +"','"+ phone +"','"+ model +"','"+ location +"','"+ available +"')";
			if(name.equals("") || age.equals("") ||  phone.equals("") ||  model.equals("") || location.equals("")) {
				 JOptionPane.showMessageDialog(null,"You miss the field");	
			}else {	
			try {
				co4.stmt.executeUpdate(str2);
				JOptionPane.showMessageDialog(null,"New DRIVER added");
				 this.setVisible(false);
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			}
		}
			
		}else if (e.getSource() == b2) {
			this.setVisible(false);
		}
		
		
	}

}
