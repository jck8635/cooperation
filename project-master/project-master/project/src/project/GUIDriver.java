package project;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonListener;

public class GUIDriver extends JFrame{
	
	private ArrayList<Eatery> eat;
	private ReservedEatery re;
	private Sort sort;
	
	private JLabel name;
	private JLabel sortname;
	private JLabel findlabel;
	
	private JTextArea Eateries;
	
	private JTextField search;
	private JTextField findfield;
	
	private JComboBox sort_case;
	
	private JButton cancel;
	private JButton order;
	private JButton find;
	private JButton orderTab;
	private JButton sortbutton;
	
	private Font main_font = new Font("���ʷҹ���", Font.BOLD, 14);
	private Font sub_font = new Font("���ʷҹ���", 0, 12);
	
	
	public void getComboBox() {
		String[] items = {"�̸� �� ����", "���� �� ����", "��ġ �� ����"};
		sort_case = new JComboBox<String>(items);
		sort_case.setFont(main_font);
	}
	
	public GUIDriver() {
		Container contentPane = getContentPane();
		
		//������ �ҷ����� �� ��� ����
		getData();
		getComboBox();
		
		setResizable(false);
		setTitle("�ֹ� ������");
		setSize(900, 600);
		setLocation(400, 100);
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(180, 240, 160));
			
		//�̸� �г� �߰�
		name = new JLabel("������ �ֹ� ������");
		name.setSize(150, 30);
		name.setLocation(390, 10);
		name.setFont(main_font);
		contentPane.add(name);
		
		//������ ���� �г�
		JLabel notice1 = new JLabel("������ �̸�                           ����                �򰡼�             ��ġ");
		notice1.setFont(sub_font);
		notice1.setSize(425, 30);
		notice1.setLocation(50, 50);
		contentPane.add(notice1);
		
		Eateries = new JTextArea(20, 30);
		for(int i = 0; i < eat.size(); i++) {
			getData();
			if(eat.get(i).getName().length() >= 6) {
				Eateries.append(i+1 + ".  " + eat.get(i).getName() + "\t" + eat.get(i).getRating() + "\t" + eat.get(i).getEval_size() + "\t" + eat.get(i).getLocation() + "\n");
			} else {
				Eateries.append(i+1 + ".  " + eat.get(i).getName() + "\t\t" + eat.get(i).getRating() + "\t" + eat.get(i).getEval_size() + "\t" + eat.get(i).getLocation() + "\n");
			}
		}
		
		JScrollPane scrollPane = new JScrollPane(Eateries);
		scrollPane.setAutoscrolls(true);
		scrollPane.setLocation(50, 90);
		scrollPane.setSize(460, 300);
		
		contentPane.add(scrollPane);
			
		search = new JTextField(30);
		search.setSize(460, 30);
		search.setLocation(50, 430);
		contentPane.add(search);
		
		cancel = new JButton("���");
		cancel.setFont(sub_font);
		cancel.setSize(70, 30);
		cancel.setLocation(50, 480);
		contentPane.add(cancel);
		
		order = new JButton("�ֹ�");
		order.setFont(sub_font);
		order.setSize(70, 30);
		order.setLocation(440, 480);
		contentPane.add(order);
	
		//���� �г�, ���� Ȯ�� �г� �ֹ� â ����
		sortname = new JLabel("���� ���");
		sortname.setFont(sub_font);
		sortname.setSize(150, 30);
		sortname.setLocation(560, 50);
		contentPane.add(sortname);
		
		sort_case.setSize(270, 30);
		sort_case.setLocation(560, 90);
		contentPane.add(sort_case);
		
		sortbutton = new JButton("���� ����");
		sortbutton.setFont(sub_font);
		sortbutton.setSize(270, 30);
		sortbutton.setLocation(560, 140);
		contentPane.add(sortbutton);
	
		orderTab = new JButton("�ֹ� ����");
		orderTab.setFont(sub_font);
		orderTab.setSize(270, 30);
		orderTab.setLocation(560, 190);
		contentPane.add(orderTab);
			
		//������ ã�� �г�
		findlabel = new JLabel("(������ �˻�) ã������ ������ �̸��� �����ϼ���");
		findlabel.setFont(sub_font);
		findlabel.setSize(270, 30);
		findlabel.setLocation(560, 380);
		contentPane.add(findlabel);
		
		findfield = new JTextField(30);
		findfield.setFont(sub_font);
		findfield.setSize(270, 30);
		findfield.setLocation(560, 430);
		contentPane.add(findfield);
		
		find = new JButton("������ ã��");
		find.setFont(sub_font);
		find.setSize(270, 30);
		find.setLocation(560, 480);
		contentPane.add(find);
	
		//��ư������ �� ��Ÿ
		ButtonListener listener = new ButtonListener();
		find.addActionListener(listener);
		orderTab.addActionListener(listener);
		sortbutton.addActionListener(listener);
		order.addActionListener(listener);
		cancel.addActionListener(listener);
		sort_case.addActionListener(listener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setData();
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			//'������ ã��' ��ư�� ������ ��
			if(event.getSource() == find) {	
				String storefind = findfield.getText();
				
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
					
					for(int i = 0; i<Lines.size(); i++) {						
						if(Lines.get(i).equals(storefind)) {
							System.out.println(Lines.get(i));
						}
					}
					
				}catch(Exception e) {
				}
								
				new EateryWindow(GUIDriver.this);
			}
			//'�ֹ� ����' ��ư�� ������ ��
			else if (event.getSource() == orderTab){			
				new OrderWindow(GUIDriver.this);
			} 
			//'���� ����'��ư�� ������ ��
			else if (event.getSource() == sortbutton){		
				if(sort_case.getSelectedIndex() == 0) {
					//new Sort();
					Eateries.setText(null);
					
					//String Temp;
					
					
					
				} 
				else if(sort_case.getSelectedIndex() == 1) {
					Eateries.setText(null);
					
				} 
				else {
					Eateries.setText(null);
				}
				
			} 
			//'�ֹ�' ��ư�� ������ ��
			else if (event.getSource() == order){				
				//�ؽ�Ʈ ���� �Էµ� ���� �ֹ��ϰ� ��
				JOptionPane.showMessageDialog(null,search.getText()+"�� �ֹ��Ǿ����ϴ�.","�ֹ� Ȯ�� â",JOptionPane.PLAIN_MESSAGE);
			} 
			//'���'��ư�� ������ ��
			else {											
				new GUIDriver();
				search.setText(null);
			}
			
		}
	}
	
	//���� �޼ҵ�� Eatery��ü, ReservedEatery��ü ������ ������
	public void getData() { 		
		FileIO io = new FileIO();
		ArrayList<Eatery> eat = new ArrayList<Eatery>();
		ReservedEatery re = new ReservedEatery();
		Graph gr = new Graph();
		
		io.getFile(eat, re,gr);
		
		this.eat = eat;
		this.re = re;
	}
	
	public void setData() {
		FileIO io = new FileIO();
		io.setFile(eat, re);
	}
	
	public void getquicksort() {
		Sort namesort = new Sort();
		ArrayList<Eatery> eat = new ArrayList<Eatery>();
		//sort.getquicksort();
	}
	
	public static void main(String[] args) {
		GUIDriver gd = new GUIDriver();
		gd.setVisible(true);
	}

}
