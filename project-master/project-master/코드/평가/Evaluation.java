package project;
//ÈÄ±â °´Ã¼
public class Evaluation {
	protected String Name;
	protected String Grade;
	protected String Food;
	protected String Evaluation;
	
	public Evaluation(String Grade, String Food, String Evaluation)
	{
		setGrade(Grade);
		setFood(Food);
		setEvaluation(Evaluation);
	}
		
	public void setGrade(String Grade)
	{
		this.Grade = Grade;
	}
	
	public void setFood(String Food)
	{
		this.Food = Food;
	}
	
	public void setEvaluation(String Evaluation)
	{
		this.Evaluation = Evaluation;
	}
	
	public String getGrade()
	{
		return Grade;
	}
	
	public String getFood()
	{
		return Food;
	}
	
	public String getEvaluation()
	{
		return Evaluation;
	}
}