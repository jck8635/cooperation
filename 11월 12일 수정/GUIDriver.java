package project2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonListener;

public class GUIDriver extends JFrame{
	
	public ArrayList<Eatery> eat;
	public ReservedEatery re;
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
	
	private Font main_font = new Font("함초롬바탕", Font.BOLD, 14);
	private Font sub_font = new Font("함초롬바탕", 0, 12);
	
	
	public void getComboBox() {
		String[] items = {"이름 순 정렬", "평점 순 정렬", "위치 순 정렬"};
		sort_case = new JComboBox<String>(items);
		sort_case.setFont(main_font);
	}
	
	public GUIDriver() {
		Container contentPane = getContentPane();
		
		//데이터 불러오기 및 배경 설정
		getData();
		getComboBox();
		
		setResizable(false);
		setTitle("주문 페이지");
		setSize(900, 600);
		setLocation(400, 100);
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(180, 240, 160));
		
		
		//이름 패널 추가
		name = new JLabel("음식점 주문 페이지");
		name.setSize(150, 30);
		name.setLocation(390, 10);
		name.setFont(main_font);
		contentPane.add(name);
		
		//음식점 정보 패널
		JLabel notice1 = new JLabel("음식점 이름                           평점                평가수             위치");
		notice1.setFont(sub_font);
		notice1.setSize(425, 30);
		notice1.setLocation(50, 50);
		contentPane.add(notice1);
		
		Eateries = new JTextArea(20, 30);
		for(int i = 0; i < eat.size(); i++) {
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
		
		cancel = new JButton("취소");
		cancel.setFont(sub_font);
		cancel.setSize(70, 30);
		cancel.setLocation(50, 480);
		contentPane.add(cancel);
		
		order = new JButton("주문");
		order.setFont(sub_font);
		order.setSize(70, 30);
		order.setLocation(440, 480);
		contentPane.add(order);
	
		
		//정렬 패널, 예약 확인 패널 주문 창 열기
		sortname = new JLabel("정렬 방법");
		sortname.setFont(sub_font);
		sortname.setSize(150, 30);
		sortname.setLocation(560, 50);
		contentPane.add(sortname);
		
		sort_case.setSize(270, 30);
		sort_case.setLocation(560, 90);
		contentPane.add(sort_case);
		
		sortbutton = new JButton("정렬 실행");
		sortbutton.setFont(sub_font);
		sortbutton.setSize(270, 30);
		sortbutton.setLocation(560, 140);
		contentPane.add(sortbutton);
	
		orderTab = new JButton("주문 내역");
		orderTab.setFont(sub_font);
		orderTab.setSize(270, 30);
		orderTab.setLocation(560, 190);
		contentPane.add(orderTab);
		
		
		//음식점 찾기 패널
		findlabel = new JLabel("(음식점 검색) 찾으려는 음식점 이름을 기입하세요");
		findlabel.setFont(sub_font);
		findlabel.setSize(270, 30);
		findlabel.setLocation(560, 380);
		contentPane.add(findlabel);
		
		findfield = new JTextField(30);
		findfield.setFont(sub_font);
		findfield.setSize(270, 30);
		findfield.setLocation(560, 430);
		contentPane.add(findfield);
		
		find = new JButton("음식점 찾기");
		find.setFont(sub_font);
		find.setSize(270, 30);
		find.setLocation(560, 480);
		contentPane.add(find);
	
		
		//버튼리스너 및 기타
		ButtonListener listener = new ButtonListener();
		find.addActionListener(listener);
		orderTab.addActionListener(listener);
		sortbutton.addActionListener(listener);
		order.addActionListener(listener);
		cancel.addActionListener(listener);
		sort_case.addActionListener(listener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setData();
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			//'음식점 찾기' 버튼을 눌렀을 때
			if(event.getSource() == find) {	
				String storefind = findfield.getText();
				boolean equal_eatery = false;
				
				for(int i = 0; i < eat.size(); i++) {
					if(eat.get(i).getName().equals(storefind)) {
						/*if(eat.get(i).getName().length() >= 6) {
							EateryWindow.eatery_info += (eat.get(i).getName() + "\t" + eat.get(i).getRating() + "\t" + eat.get(i).getEval_size() + "\t" + eat.get(i).getLocation() + "\n");
						} else {
							EateryWindow.eatery_info += (eat.get(i).getName() + "\t\t" + eat.get(i).getRating() + "\t" + eat.get(i).getEval_size() + "\t" + eat.get(i).getLocation() + "\n");
						}*/
						
						equal_eatery = true;
						new EateryWindow(GUIDriver.this, eat.get(i));
						break;
						
					}
				}
				if(!equal_eatery) {
					JOptionPane.showMessageDialog(null,"해당 음식점은 없습니다.","확인 창",JOptionPane.PLAIN_MESSAGE);
				}
				
			}
			
			//'주문 내역' 버튼을 눌렀을 때
			else if (event.getSource() == orderTab){
				new OrderWindow(GUIDriver.this, re);
			} 
			//'정렬 실행'버튼을 눌렀을 때
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
			//'주문' 버튼을 눌렀을 
			else if (event.getSource() == order){				
				//텍스트 값에 입력된 값을 주문하게 함
				String temp = search.getText();
				boolean equal_eatery = false;
				for(int i = 0; i < eat.size(); i++) {
					if(eat.get(i).getName().equals(temp)) {
						if(eat.get(i).getName().length() >= 6) {
							//OrderWindow.eatery_info += (OrderWindow.eatery_amount + ".  " + eat.get(i).getName() + "\t" + eat.get(i).getRating() + "\t" + eat.get(i).getEval_size() + "\t" + eat.get(i).getLocation() + "\n");
							re.setReservedContent((re.getReservedContent_size()+1) + ".  " + eat.get(i).getName() + "\t" + eat.get(i).getRating() + "\t" + eat.get(i).getEval_size() + "\t" + eat.get(i).getLocation()
									);
						} else {
							//OrderWindow.eatery_info += (OrderWindow.eatery_amount + ".  " + eat.get(i).getName() + "\t\t" + eat.get(i).getRating() + "\t" + eat.get(i).getEval_size() + "\t" + eat.get(i).getLocation() + "\n");
							re.setReservedContent((re.getReservedContent_size()+1) + ".  " + eat.get(i).getName() + "\t\t" + eat.get(i).getRating() + "\t" + eat.get(i).getEval_size() + "\t" + eat.get(i).getLocation());
						}
						
						JOptionPane.showMessageDialog(null,search.getText()+"이 주문되었습니다.","주문 확인 창",JOptionPane.PLAIN_MESSAGE);
						equal_eatery = true;
						break;
					}
				}
				setData();
				if(!equal_eatery) {
					JOptionPane.showMessageDialog(null,"해당 음식점은 없습니다.","주문 확인 창",JOptionPane.PLAIN_MESSAGE);
				}
				
			} 
			//'취소'버튼을 눌렀을 때
			else {											
				new GUIDriver();
				search.setText(null);
			}
			
		}
	}
	
	public void getData() { 		//이 메소드로 Eatery 객체, ReservedEatery 객체 정보를 가져옴
		FileIO io = new FileIO();
		
		ArrayList<Eatery> eat = new ArrayList<Eatery>();
		ReservedEatery re = new ReservedEatery();
		io.getFile(eat, re);
		
		this.eat = eat;
		this.re = re;
	}
	
	public void setData() {
		FileIO io = new FileIO();
		
		io.setFile(eat, re);
	}
	public static void main(String[] args) {
		GUIDriver gd = new GUIDriver();
		gd.setVisible(true);
	}

}
