package code;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangmanPanel extends JPanel implements KeyListener {
	
	private static final long serialVersionUID = 1L;

    private BufferedImage image;
    private int attempts = 1;
    private String word;
    private LetterPanel letterPanel;

    public HangmanPanel(LetterPanel letterPanel) {
		 try {                
	          image = ImageIO.read(new File("src/0.png"));
	     } catch (IOException ex) {
	            System.out.println("Unable to load image");
	       }
		 this.repaint();
         this.letterPanel = letterPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(this.word);
		if(attempts == 9) {
			System.out.println("you lost");
			System.out.println(this.word);
			 try {
				   
				   URI uri= new URI("http://www.google.com");
				   
				   java.awt.Desktop.getDesktop().browse(uri);
				    System.out.println("Web page opened in browser");
				 
				  } catch (Exception exc) {
				   
				   exc.printStackTrace();
				  
				 }
			return;
		} else {
			System.out.println("keep guessing");
		}
		
		
		boolean goodGuess = this.letterPanel.redraw( Character.toString(e.getKeyChar()));
		
		System.out.println(e.getKeyChar());
		if (!goodGuess) {
		 try {                
	          image = ImageIO.read(new File("src/" + Integer.toString(attempts)+".png"));

	       } catch (IOException ex) {
	            System.out.println("Unable to load image");
	       }
		 this.repaint();
		 attempts++;
		 
		 if(this.letterPanel.gameWon()) {
			 System.out.println("won!");
			 JOptionPane.showMessageDialog(null, "You won", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
		 }
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
