package project2;

public class Food {						
	private int price;			
	private String name;					
	public Food(int price, String name) {	
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