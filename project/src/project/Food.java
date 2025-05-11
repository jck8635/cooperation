package project;

public class Food {							//음식
	private int price;						//가격
	private String name;					//이름
	
	public Food(int price, String name) {	//생성자
		this.price = price;
		this.name = name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
