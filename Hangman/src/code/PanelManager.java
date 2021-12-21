package code;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class PanelManager extends JPanel implements KeyListener {
	
	private HangmanPanel picturePanel;
	private LetterPanel letterPanel;
	private int attempts = 1;
    private BufferedImage image;
    private JSplitPane pane;

	public PanelManager(JSplitPane pane, HangmanPanel picturePanel, LetterPanel letterPanel) {
		this.picturePanel = picturePanel;
		this.letterPanel = letterPanel;
		this.pane = pane;
		
		 try {                
	          image = ImageIO.read(new File("src/0.png"));
	     } catch (IOException ex) {
	            System.out.println("unable to load image");
	       }
		 picturePanel.repaint();
		 letterPanel.repaint();
		 pane.getIgnoreRepaint();
	}
	
  @Override
  protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(image, 0, 0, picturePanel);         
  }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		if(attempts == 9) {
			System.out.println("you lost");
			return;
		} else {
			System.out.println("keep guessing");
		}
		
		System.out.println(e.getKeyChar());
		
		 try {                
	          image = ImageIO.read(new File("src/" + Integer.toString(attempts)+".png"));
	          System.out.println(image);
	          
	       } catch (IOException ex) {
	            System.out.println("unable to load image");
	       }
		 picturePanel.repaint();
		 letterPanel.repaint();
		 pane.repaint();
		 attempts++;
		
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
