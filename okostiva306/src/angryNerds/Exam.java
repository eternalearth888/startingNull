package angryNerds;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Exam extends Target {

	private String subject, name;
	
	public Exam() {
		// TODO Auto-generated constructor stub
		super();
		subject = "???";
		this.name = "??";
	}
	
	public Exam(int x, int y, int health, int points, int level, String imgPath, String subject, String name) {
		super(x, y, health, points, level, imgPath);
		this.subject = subject;
		this.name = name;
	}
	
	public Exam(int x, int y, int health, int points, int level, Image image, String subject, String name) {
		super(x, y, health, points, level, image);
		this.subject = subject;
		this.name = name;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(image, x, y, null);
		
		g.setColor(Color.RED);
		g.fillRect(this.x + 2, this.y + 5 + image.getHeight(null), health, 5);
		
		g.setColor(Color.BLACK);
		g.drawRect(this.x + 2, this.y + 5 + image.getHeight(null), points, 5);
		
		return;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void paintComponent(Graphics g)
	{
		//super.paintComponent(g);
		this.draw(g);
		return;
	}
}
