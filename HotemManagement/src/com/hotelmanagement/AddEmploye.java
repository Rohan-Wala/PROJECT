package com.hotelmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
public class AddEmploye extends JFrame implements ActionListener{
	
	JTextField t1 ,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	JComboBox c1;
	JButton b1;
	
	AddEmploye() {
	//1
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.PLAIN,17));
		name.setBounds(60, 30, 120,20);
		name.setForeground(Color.blue);
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(200,30, 130, 20);
		add(t1);
	//2
		JLabel age = new JLabel("Age");
		age.setFont(new Font("Tahoma", Font.PLAIN,17));
		age.setBounds(60, 70, 120,20);
		age.setForeground(Color.blue);
		add(age);
		
		t2  = new JTextField();
		t2.setBounds(200,70, 130, 20);
		add(t2);
		
	//3
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Tahoma", Font.PLAIN,17));
		gender.setBounds(60, 110, 120,20);
		gender.setForeground(Color.blue);
		add(gender);
		
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma", Font.PLAIN,15));
		r1.setBackground(Color.WHITE);
		r1.setBounds(200, 110, 60,20);
		add(r1);
		
		
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma", Font.PLAIN,17));
		r2.setBackground(Color.WHITE);
		r2.setBounds(290, 110, 80,20);
		add(r2);
		
		ButtonGroup g = new ButtonGroup();
		g.add(r1);
		g.add(r2);
		
		
		JLabel job = new JLabel("Job");
		job.setFont(new Font("Tahoma", Font.PLAIN,17));
		job.setBounds(60, 150, 120,20);
		job.setForeground(Color.blue);
		add(job);
		
		String str[] = {"Clerks","staff","driver","manager","housekeeping","accountanit","chef"}; 
		c1 = new JComboBox(str);
		c1.setBackground(Color.WHITE);
		c1.setBounds(200, 150, 120,20);
		add(c1);
		
		JLabel salary = new JLabel("Salary");
		salary.setFont(new Font("Tahoma", Font.PLAIN,17));
		salary.setBounds(60, 190, 120,20);
		salary.setForeground(Color.blue);
		add(salary);
		
		t3  = new JTextField();
		t3.setBounds(200,190, 130, 20);
		add(t3);
		
		JLabel phone = new JLabel("Phone");
		phone.setFont(new Font("Tahoma", Font.PLAIN,17));
		phone.setBounds(60, 230, 120,20);
		phone.setForeground(Color.blue);
		add(phone);
		
		t4  = new JTextField();
		t4.setBounds(200,230, 130, 20);
		add(t4);
		
		JLabel aadhaar = new JLabel("Aadhaar");
		aadhaar.setFont(new Font("Tahoma", Font.PLAIN,17));
		aadhaar.setBounds(60, 270, 120,20);
		aadhaar.setForeground(Color.blue);
		add(aadhaar);
		
		t5  = new JTextField();
		t5.setBounds(200,270, 130, 20);
		add(t5);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.PLAIN,17));
		email.setBounds(60, 310, 120,20);
		email.setForeground(Color.blue);
		add(email);
		
		t6  = new JTextField();
		t6.setBounds(200,310, 130, 20);
		add(t6);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/employee.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800,460, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(0,0,800,460);
		add(l1);
		
		JLabel l2 = new JLabel("ADD employe detailes");
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Tahoma", Font.PLAIN,30));
		l2.setBounds(420,20, 700, 30);
		add(l2);
		
		b1 = new JButton("submit");
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setBounds(200, 350, 100,30);
		b1.addActionListener(this);
		add(b1);
		
		
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setBounds(350,200,800,460);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String name = t1.getText();
		String age = t2.getText();
		String salary = t3.getText();
		String phone = t4.getText();
		String aadhaar = t5.getText();
		String email = t6.getText();
		
		String gender = null;
		if(r1.isSelected()) {
			gender = "Male";
		}
		if(r2.isSelected()) {
			gender = "Female";
		}
		
		String job = (String)c1.getSelectedItem();
		
		connect co2 = new connect();
		
		String str2 = "insert into employe values('"+ name +"','"+ age +"','"+ gender +"','"+ job +"','"+ salary +"','"+ phone +"','"+ aadhaar +"','"+ email +"')";
		
		if(name.equals("") || age.equals("") || job.equals("") || salary.equals("") || phone.equals("")|| aadhaar.equals("") || email.equals("")) {
			 JOptionPane.showMessageDialog(null,"You miss the field");	
		}else {
		try {
			
		 co2.stmt.executeUpdate(str2);
		 JOptionPane.showMessageDialog(null,"New employee added");
		 this.setVisible(false);
		 new AddEmploye();
		 
		 
		 
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		
	}
		}
	public static void main(String[] args) {
		new AddEmploye();
	}


	


	

}
