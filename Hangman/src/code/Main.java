package code;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {
	
	public static void main(String[] hargs) {
		
        LetterPanel letterPanel = new LetterPanel(new WordSelector());
        letterPanel.setLayout(new BoxLayout(letterPanel,BoxLayout.Y_AXIS));
		letterPanel.setFocusable(false);
		
		HangmanPanel picturePanel = new HangmanPanel(letterPanel);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        picturePanel.setBorder(border);
		picturePanel.setFocusable(true);
		
		JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,picturePanel, letterPanel);
		pane.setDividerLocation(250);
		pane.setDividerSize(0);
		
		JFrame frame = new JFrame("Hangman");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(picturePanel);
		frame.getContentPane().add(pane);
		frame.setSize(new Dimension(500,200));
		frame.setFocusable(true);	
	}

}
