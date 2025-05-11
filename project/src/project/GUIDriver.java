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
		String[] items = {"�̸� �� ����", "���� �� ����", "��ġ �� ����"};
		sort_case = new JComboBox<String>(items);
	}
	public GUIDriver() {
		Container contentPane = getContentPane();
		
		getData();
		getComboBox();
		getFunction();
		
		setResizable(false);
		setTitle("�ֹ� ������");
		setSize(800, 850);
		setLocation(400, 100);
		
		contentPane.setLayout(new FlowLayout());
		
		//�̸� �г� �߰�
		JPanel namePan = new JPanel();
		name = new JLabel("������ �ֹ� ������");
		namePan.add(name);
		
		//������ ���� �г�
		JPanel centerPan = new JPanel(new BorderLayout(20, 20));
		
		JLabel notice1 = new JLabel("������ �̸�        ����                   �򰡼�                 ��ġ                   ��ȭ��ȣ");
		Eateries = new JTextArea(20, 30);
		JLabel notice2 = new JLabel("�ֹ��Ϸ��� �������� �Է��ϼ���");
		
		for(int i = 0; i < eat.size(); i++) {
			Eateries.append(i+1 + ". " + eat.get(i).getName() + "\t" + eat.get(i).getRating() + "\t" + eat.get(i).getEval_size() + "\t" + eat.get(i).getLocation()+ "\t" + eat.get(i).getPhonenumber() + "\n");
		}
		JScrollPane scrollPane = new JScrollPane(Eateries);
		
		scrollPane.setBounds(0, 0, 20, 20);
		search = new JTextField(30);
		cancel = new JButton("���");
		order = new JButton("����");
		
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
		
		//���� �г�, ���� Ȯ�� �г� �ֹ� â ����
		JPanel leftPan = new JPanel(new BorderLayout(20, 20));
		
		sortname = new JLabel("���� ���");
		sortbutton = new JButton("���� ����");
	
		orderTab = new JButton("�ֹ� â ����");
		
		JPanel subpan5 = new JPanel(new GridLayout(4, 1, 0, 40));
		
		subpan5.add(sortname);
		subpan5.add(sort_case);
		subpan5.add(sortbutton);
		subpan5.add(orderTab);
		leftPan.add(subpan5, BorderLayout.NORTH);
		
		
		//���� Ȯ�� �г� - ���ο� â
		find = new JButton("������ ã��");
		findlabel = new JLabel("(������ �˻� ĭ) ã������ ������ �̸��� �����ϼ���");
		findfield = new JTextField(30);

		JPanel subpan6 = new JPanel(new GridLayout(3, 1, 20, 40));
		subpan6.add(findlabel);
		subpan6.add(findfield);
		subpan6.add(find);
		leftPan.add(subpan6, BorderLayout.SOUTH);
		centerPan.add(leftPan, BorderLayout.EAST);
		
		
		
		
		//�����г� �߰�
		contentPane.add(namePan);
		contentPane.add(centerPan);
		

		
		//��ư������ �� ��Ÿ
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
	
	public void getData() { 		//�� �޼ҵ�� Eatery ��ü, ReservedEatery ��ü ������ ������
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
	
	public void getFunction() {		//��ɵ��� �غ��ϴ� �Լ��Դϴ�.
		this.map.setShoplist(this.eat.toArray(new Eatery[this.eat.size()]));		//�׷����� ���� �Է�.
		this.sort = new Sort();														//���Ŀ� ��.
		this.eat = new ArrayList<>(Arrays.asList(sort.getquicksort(this.eat.toArray(new Eatery[this.eat.size()]))));	// ó�� �ѹ� �����ϴ� �ڵ忹��. ��������
	}
	
	public static void main(String[] args) {
		GUIDriver gd = new GUIDriver();
		gd.setVisible(true);
	}

}
