package project;

import java.awt.*;
import project.GUIDriver;
import project.Search;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class EateryWindow extends JDialog{
	//private GUIDriver owner;
	
	
	public EateryWindow(GUIDriver owner) {
		super(owner,"음식점 정보창");
		setSize(600, 600);
		setLocationRelativeTo(owner);
		
		//입력한 값 받아오면 수정할 부분
		/*
		JLabel title = new JLabel("검색한 가게 : ");
		title.setSize(150, 30);
		title.setLocation(30, 10);
		add(title);
		*/
		
		JTextArea content = new JTextArea(10,10);
		content.setLocation(30,20);
		add(content);
		
		setVisible(true);
	}
	
	
	
}
