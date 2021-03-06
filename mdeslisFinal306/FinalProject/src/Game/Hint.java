/* Deslis, Shpurik, Hetrick, Combs
 * Last Updated: 12/3/12
 * 
 */
package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Hint {
	private ArrayList<String> hints;
	private String returnedHint;
	Scanner readFile;

	public Hint() {
		try {
			readFile = new Scanner(new File("textFiles/hints"));

			hints = new ArrayList<String>();

			while (readFile.hasNextLine()) {
				hints.add(readFile.nextLine());
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("The source file can't be found or does not exist."
							+ e);
		}

		returnedHint = "";
	}

	public String pickRandomHint() {
		Collections.shuffle(hints);
		Random rand = new Random();
		int index = rand.nextInt(hints.size());
		return hints.get(index);
	}

	public ArrayList<String> getHints() {
		return hints;
	}

	public void setHints(ArrayList<String> hints) {
		this.hints = hints;
	}

	public String getReturnedHint() {
		return returnedHint;
	}

	public void setReturnedHint(String returnedHint) {
		this.returnedHint = returnedHint;
	}

	// list of 10+ hints

}
