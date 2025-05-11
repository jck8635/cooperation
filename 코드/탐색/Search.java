package project;

import java.util.*;

//검색기능을 담당하는 클래스
public class Search {
	
	private Scanner scan= new Scanner(System.in);
	private String search; //검색어를 입력받아 저장하는 문자열 변수
	private String[] search_null=new String[1]; //검색어를 입력하지 않거나 빈칸만 넣었을때 반환하기위한 문자열 배열
	
	
	//사용자에게 검색어를 입력받아 , 검색어들을 배열로 변경하여 반환하는 메소드
	public String[] search() {
		System.out.println("음식점이름 사이 '/'를 사용하여 다중검색 가능");
		System.out.print("검색 : ");
		
		search=scan.nextLine();
		
		
		if(search.isEmpty()||search.isBlank()) { //검색창에 검색어를 입력하지않았다면||빈칸만 입력했다면
			
			search_null[0]="검색어를 입력해 주세요";
			return search_null; 
			
		}
		
		else{
			String[] serch_list=search.split("/"); //검색한 음식점의 이름을 배열로 바꿔서 반환
		    return serch_list;
		}
	}
	
	
	//search를 통해 입력받은 검색어를 이용해 음식점명과 비교하여 일치한다면 정보를 보여주는 메소드
	public void search_2(Eatery[] e) {
		
		String[]s=search(); //search 메소드를 실행, 결과값은 s에 저장
		Eatery[]search_result = new Eatery[10]; //검색결과 배열
		
		
		int eatery_list_num=e.length-1; //음식점 배열의 크기 -1 ( 반복문 사용에 이용 )
		int search_list_num=s.length-1; //검색어 배열의 크기 -1 ( 반복문 사용에 이용 )
		int result_num=0; //검색결과 배열의 인덱스를 조정하기 위해 사용
		
		//search의 반환값이 "검색어를 입력해 주세요" 일때 즉 검색어를 입력하지않았거나 공백만 입력했을때 경고문을 출력하며 종료
		if(s[0].equals("검색어를 입력해 주세요")) 
		{
			System.out.println(s[0]);
			return;
		}
		
		//검색어 배열과 음식점 배열을 비교하며 문자열이 같을경우 검색결과 배열에 삽입
		//탐색 자료구조를 사용해도 괜찮을듯
		for(int i=0; i<=search_list_num; i++) {
			for(int k=0; k<=eatery_list_num; k++) {
				if(s[i].equals(e[k].getName()))
				{
					search_result[result_num]=e[k];
					result_num++;
				}
			}
		}
		
		int search_r=result_num-1; //검색결과 배열을 탐색하기위해 사용
		
		//검색어와 일치하는 음식점이 하나도 없을 때
		if(search_r==-1) {
			System.out.println("검색어와 일치하는 음식점이 없습니다.");
		}
		
		//검색어와 일치하는 음식점들의 정보를 제공
		for(int z=0; z<=search_r; z++) {
			search_result[z].getInformation();
		}
		
	}


	

}
