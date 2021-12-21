package code;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LetterPanel extends JPanel {

	private JLabel topLabel, bottemLabel;
	private static final long serialVersionUID = 1L;
	private String word;
	private String displayString;
	private String runningString;
	private StringBuilder alphabet;
	private StringBuilder initialString;

	public LetterPanel(WordSelector wordSelector) {
		
		this.setLayout(new BorderLayout());
		this.alphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
		this.word = wordSelector.getWord();

		this.initialString = new StringBuilder("");
		for (int i = 0; i < word.length(); i++) {
			initialString.append("-");
		}

		this.topLabel = new JLabel(initialString.toString());
		this.bottemLabel = new JLabel("Used letters: ");
		this.add(topLabel);
		this.add(bottemLabel);

	}

	public boolean redraw(String key) {
		String s = this.bottemLabel.getText();
		boolean guess = false;

		/** redraw the top panel
		 return if key is valid */
	
			for (int i = 0; i < this.word.length(); i++) {

				if(this.word.charAt(i) ==  key.charAt(0)) {
				this.initialString.deleteCharAt(i);
				this.initialString.insert(i, key);
				System.out.println("found letter");
				guess = true;
				
				}
			}
			this.topLabel.setText(this.initialString.toString());
			
			if (updateLetterBank(key)) {
				this.bottemLabel.setText(s + " " + key);
			}	

		this.repaint();
		return guess;
	}

	private boolean updateLetterBank(String key) {
		for (int i = 0; i < this.alphabet.length(); i++) {
			if (key.toCharArray()[0] == this.alphabet.charAt(i)) {
				// remove from bank
				this.alphabet.deleteCharAt(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean gameWon() {
		if (this.word.toString().equals(this.initialString.toString())){
			return true;
		}
		return false;
	}

}