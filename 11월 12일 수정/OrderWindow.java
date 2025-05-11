package project2;
import java.awt.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class OrderWindow extends JDialog{
	
	public OrderWindow(GUIDriver owner, ReservedEatery re) {
		super(owner, "음식점 주문창", false);	
		
		setSize(600, 600);
		
		setLocationRelativeTo(owner);
		setResizable(false);
		setLayout(null);
		
		
		JLabel notice = new JLabel("음식점 이름                           평점                평가수             위치");
		notice.setFont(new Font("함초롬바탕", 0, 12));
		notice.setSize(600, 15);
		notice.setLocation(0, 0);
		add(notice);
		
		JTextArea content = new JTextArea(200,200);
		JScrollPane scrollPane = new JScrollPane(content);
		scrollPane.setAutoscrolls(true);
		scrollPane.setLocation(0, 20);
		scrollPane.setSize(600, 540);
		scrollPane.setLocation(0, 20);
		for(int i = 0; i < re.getReservedContent_size(); i++) {
			content.append(re.getReservedContent(i) + "\n");	
		}
		add(scrollPane);
		
		
		setVisible(true);
	}
	
}
