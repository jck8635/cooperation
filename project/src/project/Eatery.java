package project;

import java.util.*;

public class Eatery {
	private String name;					//�Ĵ� �̸�
	private double rating;					//�Ĵ� ����
	private String location;				//�Ĵ� ��ġ
	private String introduction;			//�Ĵ� �Ұ�
	private String phonenumber;				//��ȭ��ȣ �Ұ�
	private ArrayList<Food> menu;			//�޴���
	private ArrayList<String> evaluation;	//��
	private ArrayList<Double> eval_rate;
	private Scanner scan;
	
	public Eatery() {
		rating = 0;
		menu = new ArrayList<Food>();
		evaluation = new ArrayList<String>();
		eval_rate = new ArrayList<Double>();
		scan = new Scanner(System.in);
	}
	
	public Eatery(String name, String location, String introduction, String phonenumber) {	//�ʱ� ������
		this.name = name;
		rating = 0;
		this.location = location;
		this.introduction = introduction;
		this.phonenumber = phonenumber;
		menu = new ArrayList<Food>();
		evaluation = new ArrayList<String>();
		eval_rate = new ArrayList<Double>();
		scan = new Scanner(System.in);
	}
	
	public String getName() {				//�̸� ��ȯ �޼ҵ�
		return name;
	}
	
	public void setName(String name) {		//�̸� ��ȯ �޼ҵ�
		this.name = name;
	}
	
	public double getRating() {				//���� ��ȯ �޼ҵ�
		return rating;
	}
	
	public void setRating(double rating) {	//���� ��ȯ �޼ҵ�
		this.rating = rating;
	}
	
	public String getLocation() {			//��ġ ��ȯ �޼ҵ�
		return location;
	}
	
	public void setLocation(String location) {	//��ġ ��ȯ �޼ҵ�
		this.location = location;
	}
	
	public String getIntroduction() {		//�Ĵ�Ұ��� ��ȯ �޼ҵ�
		return introduction;
	}
	
	public void setIntroduction(String introduction) {		//�Ĵ�Ұ��� ��ȯ �޼ҵ�
		this.introduction = introduction;
	}
	
	public String getPhonenumber() {		//��ȭ��ȣ ��ȯ �޼ҵ�
		return phonenumber;
	}
	
	public void setPhonenumber(String phonenumber) {		//��ȭ��ȣ ��ȯ �޼ҵ�
		this.phonenumber = phonenumber;
	}
	
	public Food getMenu(int index) {						//index��°�� �޴��� ���� ��ȯ
		return menu.get(index);
	}
	
	public void addMenu(Food food) {						//�޴��� ���� �߰� �޼ҵ�
		menu.add(food);
	}
	
	public int getMenu_size() {								//�޴� ũ�� ��ȯ.
		return menu.size();
	}
	
	
	public void evaluate(double rate, String str) {		//�� �޼ҵ� - ������ 0�̻� 5������ ��쿡�� �򰡰� �����ϸ�
		if(rate < 0 || rate > 5) {						//���� ��� ����,�򰡹� ��ũ�帮��Ʈ�� �߰��ǰ� �Ĵ� ������ ���ŵ�
			System.out.println("==================================");
			System.out.println("������ 0 �̻�, 5 ������ �Ǽ����� �մϴ�");
			System.out.println("==================================");
		} else {
			eval_rate.add(rate);
			evaluation.add(str);
			double sum = 0;
			for(double temp : eval_rate) {
				sum += Math.round(temp*100)/100.0;
			}
			rating = Math.round(sum/eval_rate.size()*100)/100.0;
		}
	}
	
	public String getEvaluate_string(int index) {		//index��°�� �򰡹� ��ȯ �޼ҵ�
		return evaluation.get(index);
	}
	
	public double getEvaluate_rate(int index) {			//index��°�� ���� ��ȯ �޼ҵ�		
		return eval_rate.get(index); 
	}
	
	public int getEval_size() {							//�򰡹� ũ�� ��ȯ �޼ҵ�
		return evaluation.size();
	}
	
	public void setEvaluate_string(int index, String str) {	//index��°�� �򰡹� ��ȯ �޼ҵ�
		evaluation.set(index, str);
	}
	
	public void setEvaluate_rate(int index, double rate) {	//index��°�� ���� ��ȯ �޼ҵ� - �� �޼ҵ�� �����ϰ� ������ 0�̻� 5������ ��쿡�� ���� 
		if(rate < 0 || rate > 5) {							//���� ������ ��ȯ�� ��� ��ũ�帮��Ʈ index��°�� ������ ��ȯ�ǰ� �Ĵ� ������ ���ŵ�
			System.out.println("==================================");
			System.out.println("������ 0 �̻�, 5 ������ �Ǽ����� �մϴ�");
			System.out.println("==================================");
		} else {
			eval_rate.set(index, rate);
			double sum = 0;
			for(double temp : eval_rate) {
				sum += Math.round(temp*100)/100.0;
			}
			rating = Math.round(sum/eval_rate.size()*100)/100.0;
		}
	}
	
	public void getInformation(int i) {	//�Ĵ� ���� �˸� �޼ҵ� - �Ĵ��, �Ĵ� ����, �Ĵ� ��ġ, �Ĵ� �򰡼�, �Ĵ� ��ȭ��ȣ�� �����ְ� �Ĵ� �򰡸� ���� �� ����
		System.out.println("==================================");
		System.out.println(i + " ��° �Ĵ� �����Դϴ�.");
		if(evaluation.size() != 0) {
			System.out.println("�Ĵ� �̸�: " + getName() + "\n�Ĵ� ����: " + getRating() + "\n�Ĵ� ��ġ: " + getLocation() + "\n�Ĵ� �Ұ�: " + getIntroduction() + "\n�Ĵ� ��ȭ��ȣ: " + getPhonenumber() + "\n�Ĵ� �򰡼�: " + evaluation.size());
		} else {
			System.out.println("�Ĵ� �̸�: " + getName() + "\n�Ĵ� ����: " + getRating() + "\n�Ĵ� ��ġ: " + getLocation() + "\n�Ĵ� �Ұ�: " + getIntroduction() + "\n�Ĵ� ��ȭ��ȣ: " + getPhonenumber() + "\n�Ĵ� �򰡼�: 0");
		}
	}
	
	public void readEvaluation() {	//�Ĵ� �򰡸� �д� �޼ҵ�
		System.out.print("�Ĵ� �򰡸� �����ðڽ��ϱ�? ��/�ƴϿ� ");
		
		if(scan.next().equals("��")) {	//�� ���ǹ��� ��� ������ ���Ƿ� "��"�� �Է������� ����ǵ��� ������
										//GUI�� �����ȴٸ� ��ư �������� event ������ ���� ���ǹ��� �����
			while(true) {
				System.out.print("�� ��° �򰡸� �����ðڽ��ϱ�? 1~" + evaluation.size());
				int temp = scan.nextInt();
				System.out.println("----------------------------------");
				System.out.println(temp + "��° ���Դϴ�.");
				System.out.println("����: " + eval_rate.get(temp-1));
				System.out.println("�� ����: " + evaluation.get(temp-1));
				
				System.out.println("�ٸ� �򰡸� �о�ðڽ��ϱ�?");
				if(scan.next().equals("�ƴϿ�")){	//�� ���ǹ��� ���� ��������
					break;
				}
			}
		} 
	}
}