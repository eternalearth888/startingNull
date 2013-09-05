package angryNerds;
import java.awt.Color;
import java.awt.Graphics;

public class Book extends Weapon {

	private String subject;
	
	public Book() {
		// TODO Auto-generated constructor stub
		super();
		subject = "???";
	}
	
	public Book(int damage, int level, WEAPON_TYPE weaponType, String imgPath, String subject) {
		super(damage, level, weaponType, imgPath);
		this.subject = subject;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public void draw(Graphics g) 
	{
		if (image == null)
		{
			g.setColor(Color.BLUE);
			g.fillOval(x, y, 20, 20);
		}
		else 
		{
			g.drawImage(image, x, y, null);
		}
		return;
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		draw(g);
		return;
	}

	@Override
	public String getWeaponName() {
		return "Book";
	}

}