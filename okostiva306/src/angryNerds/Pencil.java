package angryNerds;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;


public class Pencil extends Weapon {

	public Pencil() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Pencil(int damage, int level, WEAPON_TYPE weaponType, String imagePath) {
		super (damage, level, weaponType, imagePath);
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
		return "Pencil";
	}
}
