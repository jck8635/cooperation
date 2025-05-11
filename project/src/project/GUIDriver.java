package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonListener;

public class GUIDriver extends JFrame{
	
	private ArrayList<Eatery> eat;
	private ReservedEatery re;
	private Graph map;
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
	
	public void getComboBox() {
		String[] items = {"이름 순 정렬", "평점 순 정렬", "위치 순 정렬"};
		sort_case = new JComboBox<String>(items);
	}
	public GUIDriver() {
		Container contentPane = getContentPane();
		
		getData();
		getComboBox();
		getFunction();
		
		setResizable(false);
		setTitle("주문 페이지");
		setSize(800, 850);
		setLocation(400, 100);
		
		contentPane.setLayout(new FlowLayout());
		
		//이름 패널 추가
		JPanel namePan = new JPanel();
		name = new JLabel("음식점 주문 페이지");
		namePan.add(name);
		
		//음식점 정보 패널
		JPanel centerPan = new JPanel(new BorderLayout(20, 20));
		
		JLabel notice1 = new JLabel("음식점 이름        평점                   평가수                 위치                   전화번호");
		Eateries = new JTextArea(20, 30);
		JLabel notice2 = new JLabel("주문하려는 음식점을 입력하세요");
		
		for(int i = 0; i < eat.size(); i++) {
			Eateries.append(i+1 + ". " + eat.get(i).getName() + "\t" + eat.get(i).getRating() + "\t" + eat.get(i).getEval_size() + "\t" + eat.get(i).getLocation()+ "\t" + eat.get(i).getPhonenumber() + "\n");
		}
		JScrollPane scrollPane = new JScrollPane(Eateries);
		
		scrollPane.setBounds(0, 0, 20, 20);
		search = new JTextField(30);
		cancel = new JButton("취소");
		order = new JButton("예약");
		
		JPanel subPan1 = new JPanel(new BorderLayout(20, 20));
		JPanel subPan2 = new JPanel(new BorderLayout(20, 20));
		JPanel subPan3 = new JPanel(new BorderLayout(20, 20));
		
		subPan1.add(notice1, BorderLayout.NORTH);
		subPan1.add(Eateries, BorderLayout.CENTER);
		subPan2.add(search, BorderLayout.CENTER);
		subPan3.add(cancel, BorderLayout.WEST);
		subPan3.add(order, BorderLayout.EAST);
		subPan2.add(subPan3, BorderLayout.SOUTH);
		subPan1.add(subPan2, BorderLayout.SOUTH);
		
		centerPan.add(subPan1, BorderLayout.CENTER);
		
		//정렬 패널, 예약 확인 패널 주문 창 열기
		JPanel leftPan = new JPanel(new BorderLayout(20, 20));
		
		sortname = new JLabel("정렬 방법");
		sortbutton = new JButton("정렬 실행");
	
		orderTab = new JButton("주문 창 열기");
		
		JPanel subpan5 = new JPanel(new GridLayout(4, 1, 0, 40));
		
		subpan5.add(sortname);
		subpan5.add(sort_case);
		subpan5.add(sortbutton);
		subpan5.add(orderTab);
		leftPan.add(subpan5, BorderLayout.NORTH);
		
		
		//정보 확인 패널 - 새로운 창
		find = new JButton("음식점 찾기");
		findlabel = new JLabel("(음식점 검색 칸) 찾으려는 음식점 이름을 기입하세요");
		findfield = new JTextField(30);

		JPanel subpan6 = new JPanel(new GridLayout(3, 1, 20, 40));
		subpan6.add(findlabel);
		subpan6.add(findfield);
		subpan6.add(find);
		leftPan.add(subpan6, BorderLayout.SOUTH);
		centerPan.add(leftPan, BorderLayout.EAST);
		
		
		
		
		//최종패널 추가
		contentPane.add(namePan);
		contentPane.add(centerPan);
		

		
		//버튼리스너 및 기타
		ButtonListener listener = new ButtonListener();
		find.addActionListener(listener);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setData();
		
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == find) {
				Eateries.setText("asd");
			}
		}
	}
	
	public void getData() { 		//이 메소드로 Eatery 객체, ReservedEatery 객체 정보를 가져옴
		FileIO io = new FileIO();
		
		ArrayList<Eatery> eat = new ArrayList<Eatery>();
		ReservedEatery re = new ReservedEatery();
		Graph gr = new Graph();
		io.getFile(eat, re, gr);
		
		this.eat = eat;
		this.re = re;
		this.map = gr;
	}
	
	public void setData() {
		FileIO io = new FileIO();
		
		io.setFile(eat, re);
	}
	
	public void getFunction() {		//기능들을 준비하는 함수입니다.
		this.map.setShoplist(this.eat.toArray(new Eatery[this.eat.size()]));		//그래프에 가게 입력.
		this.sort = new Sort();														//정렬용 툴.
		this.eat = new ArrayList<>(Arrays.asList(sort.getquicksort(this.eat.toArray(new Eatery[this.eat.size()]))));	// 처음 한번 정렬하는 코드예요. 수정예쩡
	}
	
	public static void main(String[] args) {
		GUIDriver gd = new GUIDriver();
		gd.setVisible(true);
	}

}
