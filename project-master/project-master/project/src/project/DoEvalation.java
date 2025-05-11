package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//GUI 구현 메소드
public class DoEvalation extends JFrame{
	private Evaluation e; //평가 수 측정 배열
	private JLabel Grade; //평점 칸
	private JComboBox inputGrade; //평점 적는 칸
	private JLabel Food;
	private JTextField inputFood; //시켜먹은 음식 적는 칸
	private JLabel Evaluation;
	private JTextArea inputEvaluation;
	private JButton save; //저장 버튼
	private JButton exit; //종료 버튼
	
	public DoEvalation()
	{
		String[] choice = {"평점 선택", "5.0", "4.5", "4.0", "3.5", "3.0", "2.5", "2.0", "1.5", "1.0", "0.5", "0.0"};
		
		Container contentPane = getContentPane();
		setTitle("음식점 평가");
		setSize(400, 300);
		
		setLocation(400, 100);
		contentPane.setLayout(new BorderLayout());
	
		JPanel pn1 = new JPanel();
		pn1.setLayout(new FlowLayout(FlowLayout.CENTER));
		Grade = new JLabel("평점");
		pn1.add(Grade);
		inputGrade = new JComboBox(choice);
		pn1.add(inputGrade);
				
		JPanel pn2 = new JPanel();
		pn2.setLayout(new FlowLayout(FlowLayout.CENTER));
		Food = new JLabel("시켜드신 음식");
		pn2.add(Food);
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(new FlowLayout(FlowLayout.CENTER));
		inputFood = new JTextField(20);
		pn3.add(inputFood);
				
		JPanel pn4 = new JPanel();
		pn4.setLayout(new GridLayout(3, 1));
		pn4.add(pn1);
		pn4.add(pn2);
		pn4.add(pn3);
				
		JPanel pn5 = new JPanel();
		Evaluation = new JLabel("평가");
		inputEvaluation = new JTextArea(40, 35);
		pn5.setLayout(new BorderLayout());
		pn5.add(Evaluation, BorderLayout.NORTH);
		pn5.add(inputEvaluation, BorderLayout.CENTER);
				
		JPanel pn6 = new JPanel();
		pn6.setLayout(new FlowLayout(FlowLayout.CENTER));
		save = new JButton("저장");
		exit = new JButton("취소");
		pn6.add(save);
		pn6.add(exit);
				
		contentPane.add(pn4, BorderLayout.NORTH);
		contentPane.add(pn5, BorderLayout.CENTER);
		contentPane.add(pn6, BorderLayout.SOUTH);
		
		//사건 리스너 객체를 만들고 한 개의 단추 객체의 사건 리스너로 등록한다
		ButtonListener listener = new ButtonListener();
		save.addActionListener(listener);
		exit.addActionListener(listener);
						
		contentPane.setBackground(Color.yellow);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == save) {
				
				if(inputGrade.getSelectedItem() == "평점 선택") {
					JOptionPane.showMessageDialog(null, "평점을 선택해주세요");
				}
				else if(inputFood.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "시켜드신 음식을 입력하세요");
				}
				else {
					String G = inputGrade.getSelectedItem().toString();
					String F = inputFood.getText().toString();
					String E = inputEvaluation.getText().toString();
					e = new Evaluation(G, F, E);
				}
			}
			else if(event.getSource() == exit) {
				System.out.println(e.getGrade());
				System.out.println(e.getFood());
				System.out.println(e.getEvaluation());
				System.exit(0);
			}
		}
	}
}