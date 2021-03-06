package angryNerds;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Bully extends Target {

	private String name;
	
	public Bully() {
		// TODO Auto-generated constructor stub
		super();
		this.name = "???";
	}
	
	public Bully(int x, int y, int health, int points, int level, String imgPath, String name) {
		super(x, y, health, points, level, imgPath);
		this.name = name;
	}
	
	public Bully(int x, int y, int health, int points, int level, Image image, String name) {
		super(x, y, health, points, level, image);
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(image, x, y, null);
		
		g.setColor(Color.RED);
		g.fillRect(this.x - 22, this.y + 5 + image.getHeight(null), health, 5);
		
		g.setColor(Color.BLACK);
		g.drawRect(this.x - 22, this.y + 5 + image.getHeight(null), points, 5);
		
		return;
	}
	
	public void paintComponent(Graphics g)
	{
		//super.paintComponent(g);
		this.draw(g);
		return;
	}

}
