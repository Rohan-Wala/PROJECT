package com.hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DashBoard extends JFrame implements ActionListener {

	JMenuBar mb;
	JMenu m1, m2;
	JMenuItem i1, i2, i3, i4;

	DashBoard() {
		mb = new JMenuBar();
		add(mb);

		m1 = new JMenu("Hotel menegement");
		m1.setForeground(Color.blue);
		mb.add(m1);

		m2 = new JMenu("Admin");
		m2.setForeground(Color.BLUE);
		mb.add(m2);

		i1 = new JMenuItem("Reception");
		i1.addActionListener(this);
		m1.add(i1);

		i2 = new JMenuItem("ADD Employe");
		i2.addActionListener(this);
		m2.add(i2);

		i3 = new JMenuItem("ADD Room");
		i3.addActionListener(this);
		m2.add(i3);

		i4 = new JMenuItem("ADD Driver");
		i4.addActionListener(this);
		m2.add(i4);

		mb.setBounds(0, 0, 1300, 20);

		ImageIcon ij1 = new ImageIcon(ClassLoader.getSystemResource("com/hotelmanagement/photos/dashboard.jpg"));
		Image ij2 = ij1.getImage().getScaledInstance(1300, 900, Image.SCALE_DEFAULT);
		ImageIcon ij3 = new ImageIcon(ij2);
		JLabel l1 = new JLabel(ij3);
		l1.setBounds(0, 0, 1300, 900);
		l1.setLayout(null);
		add(l1);

		JLabel l2 = new JLabel("WE WELCOMES YOU");
		l2.setBounds(450, 60, 1000, 50);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		l1.add(l2);
		setLayout(null);
		setBounds(0, 0, 1300, 700);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Reception")) {
			new Reception().setVisible(true);
		} else if (e.getActionCommand().equals("ADD Employe")) {
			new AddEmploye().setVisible(true);
		} else if (e.getActionCommand().equals("ADD Room")) {
			new AddRooms().setVisible(true);
		} else if (e.getActionCommand().equals("ADD Driver")) {
			new AddDriver().setVisible(true);
		}

	}

	public static void main(String[] args) {
		new DashBoard().setVisible(true);
	}

}
