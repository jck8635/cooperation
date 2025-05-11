package project2;
import java.util.*;
import java.util.LinkedList;

public class ReservedEatery {
	private ArrayList<String> ReservedContent;		//���೻��
	private Scanner scan;
	
	public ReservedEatery() {						//�⺻ ������
		ReservedContent = new ArrayList<String>();
		scan = new Scanner(System.in);
	}
	
	public void setReservedContent(String str) {	//���� ���� �߰� �޼ҵ�
		ReservedContent.add(str);
	}
	
	public int getReservedContent_size() {				//���� ���� ũ�� ��ȯ �޼ҵ�
		return ReservedContent.size();
	}
	
	public String getReservedContent(int index) {		//index��°�� ���� ���� ��ȯ �޼ҵ�
		return ReservedContent.get(index);
	}
	
	public void reservate(Eatery[] eat) {				//���� �޼ҵ� (�Է��� ����� �̸��� ���� ������ ����)
		System.out.println("==================================");
		if(eat.length == 0) {
			System.out.println("�ֺ��� �������� �����ϴ�.");
		} else {
			System.out.println("���� ������ ������");
			for(int i = 0; i < eat.length; i++) {
				if(i == eat.length-1) {
					System.out.print(eat[i].getName());
					break;
				}
				System.out.print(eat[i].getName() + ", ");
			}
			
			System.out.print("��� �������� �����Ͻðڽ��ϱ�? ");
			String temp = scan.next();
			boolean search = false;
			for(int i = 0; i < eat.length; i++) {
				if(temp.equals(eat[i].getName())) {
					System.out.println("�ش� �������� ����Ǿ����ϴ�.");
					ReservedContent.add(temp);
					search = true;
					break;
				}
			}
			if(!search) {
				System.out.println("�Է��Ͻ� �������� �����ϴ�.");
			}
		}
		System.out.println("==================================");
	}
	public void getInformation() {	//������ ��Ȳ ���
		System.out.println("����� ������ ��Ȳ\n" + ReservedContent.clone());
	}
}
