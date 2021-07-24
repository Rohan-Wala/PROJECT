package com.hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener{

	JTextField t1, t2, t3;
	JComboBox c1, c2, c3;
	JButton b1, b2;

	AddRooms() {

		JLabel j1 = new JLabel("Add Room");
		j1.setBounds(150, 30, 100, 20);
		j1.setFont(new Font("tahoma", Font.PLAIN, 20));
		add(j1);

		JLabel room = new JLabel("Room Number");
		room.setBounds(60, 70, 130, 20);
		room.setFont(new Font("tahoma", Font.PLAIN, 15));
		add(room);

		t1 = new JTextField();
		t1.setBounds(220, 70, 130, 20);
		t1.setFont(new Font("tahoma", Font.PLAIN, 15));
		add(t1);

		JLabel available = new JLabel("Available");
		available.setBounds(60, 110, 130, 20);
		available.setFont(new Font("tahoma", Font.PLAIN, 15));
		add(available);

		c1 = new JComboBox(new String[] { "Avalable", "Occupide" });
		c1.setBounds(220, 110, 130, 20);
		c1.setBackground(Color.WHITE);
		add(c1);

		JLabel status = new JLabel("Cleaning status");
		status.setBounds(60, 150, 130, 20);
		status.setFont(new Font("tahoma", Font.PLAIN, 15));
		add(status);

		c2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
		c2.setBounds(220, 150, 130, 20);
		c2.setBackground(Color.WHITE);
		add(c2);

		JLabel price = new JLabel("Price");
		price.setBounds(60, 190, 130, 20);
		price.setFont(new Font("tahoma", Font.PLAIN, 15));
		add(price);

		t2 = new JTextField();
		t2.setBounds(220, 190, 130, 20);
		t2.setFont(new Font("tahoma", Font.PLAIN, 15));
		add(t2);

		JLabel type = new JLabel("Bed Type");
		type.setBounds(60, 230, 130, 20);
		type.setFont(new Font("tahoma", Font.PLAIN, 15));
		add(type);

		c3 = new JComboBox(new String[] { "Single", "Double" });
		c3.setBounds(220, 230, 130, 20);
		c3.setBackground(Color.WHITE);
		add(c3);

		b1 = new JButton("ADD");
		b1.setBounds(60, 290, 100, 20);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setFont(new Font("tahoma", Font.PLAIN, 15));
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Cancle");
		b2.setBounds(220, 290, 100, 20);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setFont(new Font("tahoma", Font.PLAIN, 15));
		b2.addActionListener(this);
		add(b2);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/twelve.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(400, 50, 500, 300);
		add(l1);

		
		setBounds(230, 150, 950, 450);
		setLayout(null);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
		
			String room = t1.getText();
			String avalable = (String)c1.getSelectedItem();
			String status = (String)c2.getSelectedItem();
			String price = t2.getText();
			String type = (String)c3.getSelectedItem();
			
			connect co3 = new connect();
			
			String str2 = "insert into rooms values('"+ room +"','"+ avalable +"','"+ status +"','"+ price +"','"+ type +"')";
			if(room.equals("") || avalable.equals("") || status.equals("") || price.equals("") || type.equals("")) {
				 JOptionPane.showMessageDialog(null,"You miss the field");	
			}else
				{try {
				co3.stmt.executeUpdate(str2);
				JOptionPane.showMessageDialog(null,"New Room added");
				 this.setVisible(false);
				 new AddRooms();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
				}
		}else if (e.getSource() == b2) {
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new AddRooms().setVisible(true);
	}

	

}
