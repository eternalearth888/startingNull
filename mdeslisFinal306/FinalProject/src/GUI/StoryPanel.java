package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class StoryPanel extends JFrame {

	public StoryPanel() {
		setSize(new Dimension(600, 400));
		setResizable(false);
		setTitle("Background Story");
		Font font = new Font("Arial", Font.PLAIN, 16);
		
		JTextArea story = new JTextArea();
		Scanner readStory;
		String addStory = "";
		
		try {
			readStory = new Scanner(new File("textFiles/story"));

			while (readStory.hasNext()) {
				addStory = addStory + readStory.nextLine();
			}
			story.setText(addStory);

			readStory.close();

		} catch (FileNotFoundException e) {
			System.out.println("The story file can't be found or does not exist."
							+ e);
		}

		story.setBorder(new TitledBorder(new EtchedBorder(), "Background Story"));
		story.setLineWrap(true);
		story.setEditable(false);
		story.setFont(font);
		add(story);
	}
}
