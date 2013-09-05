package main;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class SplashImage extends JWindow {
	public ImageIcon splash = createImageIcon("/images/splash.png");
	private JLabel image = new JLabel(splash);
	
	
	public SplashImage() {
		getContentPane().add(image);
		setSize(400,182);
		setLocationRelativeTo(null);
		setVisible(true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setVisible(false);
		dispose();

	}

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = SplashImage.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
