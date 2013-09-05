package angryNerds;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;


public class Nerd {

	private String name;
	private Image picture;
	private ArrayList<Weapon> weapons;
	
	public Nerd() {
		// TODO Auto-generated constructor stub
		this.name = "???";
		this.picture = Toolkit.getDefaultToolkit().getImage("/Images/none.jpg");
		weapons = new ArrayList<Weapon>();
	}

	public Nerd(String name, Image image) {
		this.name = name;
		this.picture = image;
		weapons = new ArrayList<Weapon>();
	}
	
	public Nerd(String name, String imagePath) {
		this.name = name;
		this.picture = Toolkit.getDefaultToolkit().getImage(imagePath);
		weapons = new ArrayList<Weapon>();
	}
	
	public String getName() {
		return name;
	}
	
	public Image getPicture() {
		return picture;
	}
	
	public Weapon getWeapon(int index) {
		return weapons.get(index);
	}
	
	public void AddWeapon(Weapon weapon) {
		weapons.add(weapon);
		return;
	}
	
	public void removeWeapon(Weapon weapon) {
		weapons.remove(weapon);
		return;
	}
	
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	
	public void toss(int angle, int power) {
		weapons.remove(0);
		return;
	}
}
