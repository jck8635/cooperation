package project2;
import java.util.*;
import java.util.LinkedList;

public class ReservedEatery {
	private ArrayList<String> ReservedContent;		//예약내용
	private Scanner scan;
	
	public ReservedEatery() {						//기본 생성자
		ReservedContent = new ArrayList<String>();
		scan = new Scanner(System.in);
	}
	
	public void setReservedContent(String str) {	//예약 내용 추가 메소드
		ReservedContent.add(str);
	}
	
	public int getReservedContent_size() {				//예약 내용 크기 반환 메소드
		return ReservedContent.size();
	}
	
	public String getReservedContent(int index) {		//index번째의 예약 내용 반환 메소드
		return ReservedContent.get(index);
	}
	
	public void reservate(Eatery[] eat) {				//예약 메소드 (입력한 내용과 이름이 같은 음식점 예약)
		System.out.println("==================================");
		if(eat.length == 0) {
			System.out.println("주변에 음식점이 없습니다.");
		} else {
			System.out.println("예약 가능한 음식점");
			for(int i = 0; i < eat.length; i++) {
				if(i == eat.length-1) {
					System.out.print(eat[i].getName());
					break;
				}
				System.out.print(eat[i].getName() + ", ");
			}
			
			System.out.print("어느 음식점을 예약하시겠습니까? ");
			String temp = scan.next();
			boolean search = false;
			for(int i = 0; i < eat.length; i++) {
				if(temp.equals(eat[i].getName())) {
					System.out.println("해당 음식점이 예약되었습니다.");
					ReservedContent.add(temp);
					search = true;
					break;
				}
			}
			if(!search) {
				System.out.println("입력하신 음식점은 없습니다.");
			}
		}
		System.out.println("==================================");
	}
	public void getInformation() {	//음식점 현황 출력
		System.out.println("예약된 음식점 현황\n" + ReservedContent.clone());
	}
}
