package angryNerds;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Window extends Target {
	
	private String name;
	
	public Window() {
		// TODO Auto-generated constructor stub
		super();
		this.name = "??";
	}
	
	public Window(int x, int y, int health, int points, int level, String imgPath, String name) {
		super(x, y, health, points, level, imgPath);
		this.name = name;
	}
	
	public Window(int x, int y, int health, int points, int level, Image image, String name) {
		super(x, y, health, points, level, image);
		this.name = name;
	}
	
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(image, x, y, null);
		
		g.setColor(Color.RED);
		g.fillRect(this.x + 15, this.y + 5 + image.getHeight(null), health, 5);
		
		g.setColor(Color.BLACK);
		g.drawRect(this.x + 15, this.y + 5 + image.getHeight(null), points, 5);
		
		return;
	}
	
	public void paintComponent(Graphics g)
	{
		//super.paintComponent(g);
		this.draw(g);
		return;
	}
	
	public String getName() {
		return this.name;
	}

}
