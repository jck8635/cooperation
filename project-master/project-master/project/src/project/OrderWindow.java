package project;

import java.awt.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class OrderWindow extends JDialog{
	private GUIDriver owner;
	
	public OrderWindow(GUIDriver owner) {
		super(owner, "������ ����â", false);	
	
		setSize(600, 600);
		setLocationRelativeTo(owner);
		
		//�ֹ� ����� ��� �ϴ� ������ ���� ���� �־��
		try {
			File storelist = new File("c:/Users/USER/git/project-master/project-master/test(write).txt");
			FileReader fr = new FileReader(storelist);
			BufferedReader bf = new BufferedReader(fr);
			
			List<String> Lines = new ArrayList<String>();
			
			String line = "";
			
			while((line = bf.readLine()) != null ) {
				Lines.add(line);
			}
			bf.close();
			
			JTextArea content = new JTextArea(500,500);
			content.setLocation(30,100);
			add(content);
			
			for(int i = 0; i<Lines.size(); i++) {
				content.append(Lines.get(i));
			}
			
		}catch(Exception e) {
		}
		
		setVisible(true);
	}
	
	static boolean checkBeforeFile(File orderlist) {
		if(orderlist.exists()) {
			if(orderlist.isFile() && orderlist.canRead()) {
				return true;
			}
		}
		return false;
	}
}
