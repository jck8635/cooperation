package project2;
import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class EateryWindow extends JDialog{
	private GUIDriver owner;
	
	public EateryWindow(GUIDriver owner) {
		super(owner, "음식점 정보창", false);
		
	
		setSize(600, 600);
		setLocationRelativeTo(owner);
		
		this.owner = owner;
		
		JLabel testLabel = new JLabel("hello");
		
		add(testLabel);
		
		setVisible(true);
		
		
	}
}
