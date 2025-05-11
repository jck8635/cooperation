package project2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;



public class EateryWindow extends JDialog{
	
	private Eatery eat_temp;
	
	private JButton eval_button;
	private JButton do_eval_button;
	private JButton cancel_button;
	
	private JTextArea eval_area;
	
	private JComboBox rating;
	
	public EateryWindow(GUIDriver owner, Eatery eat) {
		super(owner,"������ ����â");
		setSize(600, 1000);
		setLocationRelativeTo(owner);
		setResizable(false);
		setLayout(null);
		
		eat_temp = eat;
		
		//��Ʈ
		Font main_font = new Font("���ʷҹ���", Font.BOLD, 16);
		Font sub_font = new Font("���ʷҹ���", 0, 12);
		
		
		//����
		JLabel title = new JLabel(eat.getName());
		title.setFont(main_font);
		title.setSize(200, 20);
		title.setLocation(240, 0);
		add(title);
		
		
		//����, �� ��
		int rating_size = (int) eat.getRating();
		String star;
		
		if(rating_size < 1) {
			star = "�١١١١�";
		} else if(rating_size < 2) {
			star = "�ڡ١١١�";
		} else if(rating_size < 3) {
			star = "�ڡڡ١١�";
		} else if(rating_size < 4) {
			star = "�ڡڡڡ١�";
		} else if(rating_size < 5){
			star = "�ڡڡڡڡ�";
		} else {
			star = "�ڡڡڡڡ�";
		}
		JLabel eval = new JLabel(star + " " + Double.toString(eat.getRating()) + " (" + Integer.toString(eat.getEval_size())+ ")");
		eval.setFont(sub_font);
		eval.setSize(200, 20);
		eval.setLocation(240, 30);
		add(eval);
		
		
		//�Ĵ� �Ұ���
		JLabel intro_title = new JLabel("�Ĵ� �Ұ�");
		intro_title.setFont(main_font);
		intro_title.setSize(100, 20);
		intro_title.setLocation(0, 100);
		add(intro_title);
		
		JTextArea introduction = new JTextArea();
		StringBuilder temp_str = new StringBuilder(eat.getIntroduction());
		int rowsize = 55;
		while(temp_str.length() > rowsize) {
			temp_str.insert(rowsize, "\n");
			rowsize += 55;
		}
		introduction.append(temp_str.toString());
		introduction.setSize(600, 100);
		introduction.setLocation(0, 120);
		add(introduction);
		
		//�޴���
		JLabel menu_title = new JLabel("�޴���");
		menu_title.setFont(main_font);
		menu_title.setSize(100, 20);
		menu_title.setLocation(0, 250);
		add(menu_title);
		
		temp_str = new StringBuilder();
		for(int i = 0; i < eat.getMenu_size(); i++) {
			temp_str.append(eat.getMenu(i).getName() + " " + eat.getMenu(i).getPrice() + "��" + "\n");
		}
		JTextArea menu = new JTextArea();
		menu.append(temp_str.toString());
		menu.setSize(600, 60);
		menu.setLocation(0, 270);
		add(menu);
		
		//��ġ
		JLabel locate_title = new JLabel("������ ��ġ");
		locate_title.setFont(main_font);
		locate_title.setSize(100, 20);
		locate_title.setLocation(0, 360);
		add(locate_title);
		
		JTextArea locate = new JTextArea();
		locate.append(eat.getLocation());
		locate.setSize(600, 20);
		locate.setLocation(0, 380);
		add(locate);
		
		//�� ����
		JLabel evl_title = new JLabel("������ ��");
		evl_title.setFont(main_font);
		evl_title.setSize(100, 20);
		evl_title.setLocation(0, 430);
		add(evl_title);
		
		temp_str = new StringBuilder();
		for(int i = 0; i < eat.getEval_size(); i++) {
			temp_str.append(i+1 + " " + eat.getEvaluate_string(i) + "\n");
		}
		
		JTextArea evl = new JTextArea();
		evl.append(temp_str.toString());
		JScrollPane evlPane = new JScrollPane(evl);

		evlPane.setAutoscrolls(true);
		evlPane.setSize(600, 80);
		evlPane.setLocation(0, 450);
		add(evlPane);
		
		
		//��
		eval_button = new JButton("���ϱ�");
		eval_button.setSize(100, 20);
		eval_button.setLocation(250, 600);
		add(eval_button);	
		
		//�򰡹�ư ������ ��� ������ ������Ʈ
		eval_area = new JTextArea();
		eval_area.setSize(600, 300);
		eval_area.setLocation(0, 570);
		eval_area.setVisible(false);
		add(eval_area);
		
		
		String[] items = {"0.0", "1.0", "2.0", "3.0", "4.0", "5.0"};
		rating = new JComboBox<String>(items);
		rating.setFont(sub_font);
		rating.setSize(80, 40);
		rating.setLocation(100, 900);
		rating.setVisible(false);
		add(rating);
		
		cancel_button = new JButton("���");
		cancel_button.setFont(sub_font);
		cancel_button.setSize(80, 40);
		cancel_button.setLocation(300, 900);
		cancel_button.setVisible(false);
		add(cancel_button);
		
		do_eval_button = new JButton("��");
		do_eval_button.setFont(sub_font);
		do_eval_button.setSize(80, 40);
		do_eval_button.setLocation(420, 900);
		do_eval_button.setVisible(false);
		add(do_eval_button);
		
		
		class ButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == eval_button) {
					eval_button.setVisible(false);
					
					eval_area.setVisible(true);
					rating.setVisible(true);
					do_eval_button.setVisible(true);
					cancel_button.setVisible(true);
					
				} else if(event.getSource() == cancel_button) {
					eval_button.setVisible(true);
					
					eval_area.setVisible(false);
					rating.setVisible(false);
					do_eval_button.setVisible(false);
					cancel_button.setVisible(false);
				} else {
					Eatery eat_temp = eat;
					
					double score;
					switch(rating.getSelectedIndex()) {
						case 0:
							score = 0.0;
							break;
						case 1:
							score = 1.0;
							break;
						case 2:
							score = 2.0;
							break;
						case 3:
							score = 3.0;
							break;
						case 4:
							score = 4.0;
							break;
						default:
							score = 5.0;
					}
					
					
					eat_temp.evaluate(score, eval_area.getText());
					
					int index = 0;
					
					while(true){
						if(owner.eat.get(index).getName().equals(eat_temp.getName())) {
							owner.eat.set(index, eat_temp);
							owner.setData();
							break;
						}
						index++;
					}
					
					
				}
			}
		}
		
		
		ButtonListener listener = new ButtonListener();
		eval_button.addActionListener(listener);
		do_eval_button.addActionListener(listener);
		cancel_button.addActionListener(listener);
		
		//remove
				
		/*JTextArea content = new JTextArea(10,10);
		content.setLocation(30,20);
		add(content);*/
		
		setVisible(true);
	}	
}