package project;

import java.util.*;

//�˻������ ����ϴ� Ŭ����
public class Search {
	
	private Scanner scan= new Scanner(System.in);
	private String search; //�˻�� �Է¹޾� �����ϴ� ���ڿ� ����
	private String[] search_null=new String[1]; //�˻�� �Է����� �ʰų� ��ĭ�� �־����� ��ȯ�ϱ����� ���ڿ� �迭
	
	
	//����ڿ��� �˻�� �Է¹޾� , �˻������ �迭�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String[] search() {
		System.out.println("�������̸� ���� '/'�� ����Ͽ� ���߰˻� ����");
		System.out.print("�˻� : ");
		
		search=scan.nextLine();
		
		
		if(search.isEmpty()||search.isBlank()) { //�˻�â�� �˻�� �Է������ʾҴٸ�||��ĭ�� �Է��ߴٸ�
			
			search_null[0]="�˻�� �Է��� �ּ���";
			return search_null; 
			
		}
		
		else{
			String[] serch_list=search.split("/"); //�˻��� �������� �̸��� �迭�� �ٲ㼭 ��ȯ
		    return serch_list;
		}
	}
	
	
	//search�� ���� �Է¹��� �˻�� �̿��� ��������� ���Ͽ� ��ġ�Ѵٸ� ������ �����ִ� �޼ҵ�
	public void search_2(Eatery[] e) {
		
		String[]s=search(); //search �޼ҵ带 ����, ������� s�� ����
		Eatery[]search_result = new Eatery[10]; //�˻���� �迭
		
		
		int eatery_list_num=e.length-1; //������ �迭�� ũ�� -1 ( �ݺ��� ��뿡 �̿� )
		int search_list_num=s.length-1; //�˻��� �迭�� ũ�� -1 ( �ݺ��� ��뿡 �̿� )
		int result_num=0; //�˻���� �迭�� �ε����� �����ϱ� ���� ���
		
		//search�� ��ȯ���� "�˻�� �Է��� �ּ���" �϶� �� �˻�� �Է������ʾҰų� ���鸸 �Է������� ����� ����ϸ� ����
		if(s[0].equals("�˻�� �Է��� �ּ���")) 
		{
			System.out.println(s[0]);
			return;
		}
		
		//�˻��� �迭�� ������ �迭�� ���ϸ� ���ڿ��� ������� �˻���� �迭�� ����
		//Ž�� �ڷᱸ���� ����ص� ��������
		for(int i=0; i<=search_list_num; i++) {
			for(int k=0; k<=eatery_list_num; k++) {
				if(s[i].equals(e[k].getName()))
				{
					search_result[result_num]=e[k];
					result_num++;
				}
			}
		}
		
		int search_r=result_num-1; //�˻���� �迭�� Ž���ϱ����� ���
		
		//�˻���� ��ġ�ϴ� �������� �ϳ��� ���� ��
		if(search_r==-1) {
			System.out.println("�˻���� ��ġ�ϴ� �������� �����ϴ�.");
		}
		
		//�˻���� ��ġ�ϴ� ���������� ������ ����
		for(int z=0; z<=search_r; z++) {
			search_result[z].getInformation();
		}
		
	}


	

}
