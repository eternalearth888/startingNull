package angryNerds;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HelpNotes extends JDialog {
	private JLabel weapons, targets;
	String weaponsStr = "";
	String targetsStr = "";
	private JTextArea instructions, listOfWeapons, listOfTargets;
	ArrayList<Weapon> nerdWeapons;
	ArrayList<Target> allTargets;
	
	//All images to display on the JDialog
	Image pencilPicture = Toolkit.getDefaultToolkit().getImage("images/pencil.png");
	Image bookPicture = Toolkit.getDefaultToolkit().getImage("images/book.png");
	Image protPicture = Toolkit.getDefaultToolkit().getImage("images/protractor.png");
	Image windowPicture = Toolkit.getDefaultToolkit().getImage("images/window.png");
	Image bullyPicture = Toolkit.getDefaultToolkit().getImage("images/bully.png");
	Image examPicture = Toolkit.getDefaultToolkit().getImage("images/exam.png");
	
	//Convert images to icons so that they appear on the JDialog
	ImageIcon pencilIcon = new ImageIcon(pencilPicture);
	ImageIcon bookIcon = new ImageIcon(bookPicture);
	ImageIcon protIcon = new ImageIcon(protPicture);
	ImageIcon windowIcon = new ImageIcon(windowPicture);
	ImageIcon bullyIcon = new ImageIcon(bullyPicture);
	ImageIcon examIcon = new ImageIcon(examPicture);
	
	public HelpNotes(Nerd nerd, ArrayList<Target> t) {
		setTitle("Help");
		setSize(860, 800);
		Font font = new Font("Batang", Font.BOLD, 18);
		Font font2 = new Font("Matisse ITC", Font.BOLD, 20);

		nerdWeapons = nerd.getWeapons();
		allTargets = t;
		instructions = new JTextArea("You are an ANGRY NERD! \nDestroy all windows, bullies, and " +
				"exams in each level to win the game! \nEach time you hit a target, its health will decrease. " +
				"After you fire a weapon a quiz\nwill pop up. Answer each question correctly for a higher score! " +
				"(Units are not important).");
//		instructions.setFont(font2);
		instructions.setForeground(Color.WHITE);
		instructions.setBackground(Color.BLACK);
		instructions.setEditable(false);
		
		//Print out one of each type of weapon and target along with its health/damage
		ArrayList<String> oneOfEachWeapon = new ArrayList<String>();
		ArrayList<String> oneOfEachTarget = new ArrayList<String>();
		for(Weapon w : nerdWeapons) {
			if(!oneOfEachWeapon.contains(w.getWeaponName())) {
				weaponsStr += w.getWeaponName() + ": " + w.getDamage() + " damage	      ";
				oneOfEachWeapon.add(w.getWeaponName());
			}
		}
		for(Target target : allTargets) {
			if(!oneOfEachTarget.contains(target.getName())) {
				targetsStr += target.getName() + ": " + target.getHealth() + " health	      ";
				oneOfEachTarget.add(target.getName());
			}
		}
		
		listOfWeapons = new JTextArea(weaponsStr);
//		listOfWeapons.setFont(font);
		listOfWeapons.setForeground(Color.WHITE);
		listOfWeapons.setBackground(Color.BLACK);
		
		listOfTargets = new JTextArea(targetsStr);
//		listOfTargets.setFont(font);
		listOfTargets.setForeground(Color.WHITE);
		listOfTargets.setBackground(Color.BLACK);
		
		//Put the images on the JDialog for weapons
		JLabel weaponImages = new JLabel();
		weaponImages.setLayout(new GridLayout(1, 3));
		JLabel pencilImage = new JLabel(pencilIcon);
		JLabel bookImage = new JLabel(bookIcon);
		JLabel protImage = new JLabel(protIcon);
		weaponImages.add(pencilImage);
		weaponImages.add(bookImage);
		weaponImages.add(protImage);
		weaponImages.setOpaque(true);
		weaponImages.setBackground(Color.BLACK);
		
		//Put the images on the JDialog for targets
		JLabel targetImages = new JLabel();
		targetImages.setLayout(new GridLayout(1, 3));
		JLabel windowImage = new JLabel(windowIcon);
		JLabel bullyImage = new JLabel(bullyIcon);
		JLabel examImage = new JLabel(examIcon);
		targetImages.add(windowImage);
		targetImages.add(bullyImage);
		targetImages.add(examImage);
		targetImages.setOpaque(true);
		targetImages.setBackground(Color.BLACK);
		
		weapons = new JLabel("Weapons:");
//		weapons.setFont(font);
		weapons.setForeground(Color.WHITE);
		weapons.setOpaque(true);
		weapons.setBackground(Color.BLACK);
		
		targets = new JLabel("Targets: ");
		targets.setOpaque(true);
		targets.setBackground(Color.BLACK);
//		targets.setFont(font);
		targets.setForeground(Color.WHITE);

		add(instructions);
		add(weapons);
		add(weaponImages);
		add(listOfWeapons);
		add(targets);
		add(targetImages);
		add(listOfTargets);
		listOfWeapons.setEditable(false);
		listOfTargets.setEditable(false);
		setLayout(new GridLayout(0, 1));
	}
}
