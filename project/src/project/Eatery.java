package project;

import java.util.*;

public class Eatery {
	private String name;					//식당 이름
	private double rating;					//식당 평점
	private String location;				//식당 위치
	private String introduction;			//식당 소개
	private String phonenumber;				//전화번호 소개
	private ArrayList<Food> menu;			//메뉴판
	private ArrayList<String> evaluation;	//평가
	private ArrayList<Double> eval_rate;
	private Scanner scan;
	
	public Eatery() {
		rating = 0;
		menu = new ArrayList<Food>();
		evaluation = new ArrayList<String>();
		eval_rate = new ArrayList<Double>();
		scan = new Scanner(System.in);
	}
	
	public Eatery(String name, String location, String introduction, String phonenumber) {	//초기 생성자
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
	
	public String getName() {				//이름 반환 메소드
		return name;
	}
	
	public void setName(String name) {		//이름 변환 메소드
		this.name = name;
	}
	
	public double getRating() {				//평점 반환 메소드
		return rating;
	}
	
	public void setRating(double rating) {	//평점 변환 메소드
		this.rating = rating;
	}
	
	public String getLocation() {			//위치 반환 메소드
		return location;
	}
	
	public void setLocation(String location) {	//위치 변환 메소드
		this.location = location;
	}
	
	public String getIntroduction() {		//식당소개문 반환 메소드
		return introduction;
	}
	
	public void setIntroduction(String introduction) {		//식당소개문 변환 메소드
		this.introduction = introduction;
	}
	
	public String getPhonenumber() {		//전화번호 반환 메소드
		return phonenumber;
	}
	
	public void setPhonenumber(String phonenumber) {		//전화번호 변환 메소드
		this.phonenumber = phonenumber;
	}
	
	public Food getMenu(int index) {						//index번째의 메뉴속 음식 반환
		return menu.get(index);
	}
	
	public void addMenu(Food food) {						//메뉴에 음식 추가 메소드
		menu.add(food);
	}
	
	public int getMenu_size() {								//메뉴 크기 반환.
		return menu.size();
	}
	
	
	public void evaluate(double rate, String str) {		//평가 메소드 - 평점이 0이상 5이하일 경우에만 평가가 가능하며
		if(rate < 0 || rate > 5) {						//평가할 경우 평점,평가문 링크드리스트에 추가되고 식당 평점이 갱신됨
			System.out.println("==================================");
			System.out.println("평점은 0 이상, 5 이하의 실수여야 합니다");
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
	
	public String getEvaluate_string(int index) {		//index번째의 평가문 반환 메소드
		return evaluation.get(index);
	}
	
	public double getEvaluate_rate(int index) {			//index번째의 평점 반환 메소드		
		return eval_rate.get(index); 
	}
	
	public int getEval_size() {							//평가문 크기 반환 메소드
		return evaluation.size();
	}
	
	public void setEvaluate_string(int index, String str) {	//index번째의 평가문 변환 메소드
		evaluation.set(index, str);
	}
	
	public void setEvaluate_rate(int index, double rate) {	//index번째의 평점 변환 메소드 - 평가 메소드와 동일하게 평점이 0이상 5이하일 경우에만 실행 
		if(rate < 0 || rate > 5) {							//또한 평점을 변환할 경우 링크드리스트 index번째의 평점이 변환되고 식당 평점이 갱신됨
			System.out.println("==================================");
			System.out.println("평점은 0 이상, 5 이하의 실수여야 합니다");
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
	
	public void getInformation(int i) {	//식당 정보 알림 메소드 - 식당명, 식당 평점, 식당 위치, 식당 평가수, 식당 전화번호를 보여주고 식당 평가를 읽을 수 있음
		System.out.println("==================================");
		System.out.println(i + " 번째 식당 정보입니다.");
		if(evaluation.size() != 0) {
			System.out.println("식당 이름: " + getName() + "\n식당 평점: " + getRating() + "\n식당 위치: " + getLocation() + "\n식당 소개: " + getIntroduction() + "\n식당 전화번호: " + getPhonenumber() + "\n식당 평가수: " + evaluation.size());
		} else {
			System.out.println("식당 이름: " + getName() + "\n식당 평점: " + getRating() + "\n식당 위치: " + getLocation() + "\n식당 소개: " + getIntroduction() + "\n식당 전화번호: " + getPhonenumber() + "\n식당 평가수: 0");
		}
	}
	
	public void readEvaluation() {	//식당 평가를 읽는 메소드
		System.out.print("식당 평가를 읽으시겠습니까? 네/아니오 ");
		
		if(scan.next().equals("네")) {	//이 조건문의 경우 지금은 임의로 "네"를 입력했을때 실행되도록 했지만
										//GUI로 구현된다면 버튼 형식으로 event 유무에 따라 조건문이 실행됨
			while(true) {
				System.out.print("몇 번째 평가를 읽으시겠습니까? 1~" + evaluation.size());
				int temp = scan.nextInt();
				System.out.println("----------------------------------");
				System.out.println(temp + "번째 평가입니다.");
				System.out.println("평점: " + eval_rate.get(temp-1));
				System.out.println("평가 내용: " + evaluation.get(temp-1));
				
				System.out.println("다른 평가를 읽어보시겠습니까?");
				if(scan.next().equals("아니오")){	//이 조건문도 위와 마찬가지
					break;
				}
			}
		} 
	}
}