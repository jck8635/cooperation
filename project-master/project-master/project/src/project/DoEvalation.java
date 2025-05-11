package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//GUI ���� �޼ҵ�
public class DoEvalation extends JFrame{
	private Evaluation e; //�� �� ���� �迭
	private JLabel Grade; //���� ĭ
	private JComboBox inputGrade; //���� ���� ĭ
	private JLabel Food;
	private JTextField inputFood; //���Ѹ��� ���� ���� ĭ
	private JLabel Evaluation;
	private JTextArea inputEvaluation;
	private JButton save; //���� ��ư
	private JButton exit; //���� ��ư
	
	public DoEvalation()
	{
		String[] choice = {"���� ����", "5.0", "4.5", "4.0", "3.5", "3.0", "2.5", "2.0", "1.5", "1.0", "0.5", "0.0"};
		
		Container contentPane = getContentPane();
		setTitle("������ ��");
		setSize(400, 300);
		
		setLocation(400, 100);
		contentPane.setLayout(new BorderLayout());
	
		JPanel pn1 = new JPanel();
		pn1.setLayout(new FlowLayout(FlowLayout.CENTER));
		Grade = new JLabel("����");
		pn1.add(Grade);
		inputGrade = new JComboBox(choice);
		pn1.add(inputGrade);
				
		JPanel pn2 = new JPanel();
		pn2.setLayout(new FlowLayout(FlowLayout.CENTER));
		Food = new JLabel("���ѵ�� ����");
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
		Evaluation = new JLabel("��");
		inputEvaluation = new JTextArea(40, 35);
		pn5.setLayout(new BorderLayout());
		pn5.add(Evaluation, BorderLayout.NORTH);
		pn5.add(inputEvaluation, BorderLayout.CENTER);
				
		JPanel pn6 = new JPanel();
		pn6.setLayout(new FlowLayout(FlowLayout.CENTER));
		save = new JButton("����");
		exit = new JButton("���");
		pn6.add(save);
		pn6.add(exit);
				
		contentPane.add(pn4, BorderLayout.NORTH);
		contentPane.add(pn5, BorderLayout.CENTER);
		contentPane.add(pn6, BorderLayout.SOUTH);
		
		//��� ������ ��ü�� ����� �� ���� ���� ��ü�� ��� �����ʷ� ����Ѵ�
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
				
				if(inputGrade.getSelectedItem() == "���� ����") {
					JOptionPane.showMessageDialog(null, "������ �������ּ���");
				}
				else if(inputFood.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "���ѵ�� ������ �Է��ϼ���");
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