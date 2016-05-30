package diff;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

public class ColoredJTextPane extends JTextPane{
	private CompareModel compModel;
	private Rectangle CaretRect, diffRect;
	private int flag=0;
	
    public ColoredJTextPane() {
        // super.paintComponent(g);
        setOpaque(false);         
    }

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if(flag!=0){
	        for(int i=1; i<=compModel.getLeft().length; i++){
	            g.setColor(Color.GREEN);
	            g.fillRect(0, i*16, getWidth(), i*16);       	
	        }
        }
	        
        try {
        	CaretRect = modelToView(getCaretPosition());
            if (CaretRect != null) {
                g.setColor(new Color(212,244,255));
                g.fillRect(0, CaretRect.y, getWidth(), CaretRect.height);
            }
        } catch (BadLocationException e) {
        	e.printStackTrace();
        }

        super.paintComponent(g);
    }
    
    public void repaint(long tm, int x, int y, int width, int height) {
        super.repaint(tm, 0, 0, getWidth(), getHeight());
    }
    
    public void setCompareModel(CompareModel cm){
    	compModel=cm;
    	flag=1;
    }
}