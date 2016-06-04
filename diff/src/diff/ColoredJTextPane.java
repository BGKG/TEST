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
	private int left=0;
	private int right=0;

    public ColoredJTextPane() {
        // super.paintComponent(g);
        setOpaque(false);         
    }
 /**
  * 색칠을 담당합니다
  * @param
  * @param
  * @return 
  */
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if((left==1)&&(right==0)&&(compModel.getLeft().isEmpty()==false)){
	        for(int i=0; i<compModel.getLeft().size(); i++){
	        	if(compModel.getLeft().get(i)==false){
		            g.setColor(new Color(255,239,133));
		            g.fillRect(0, 3+i*18, getWidth(), (i+1)*18);
	        	}
	        	else if(compModel.getLeft().get(i)==true){
	        		g.setColor(Color.WHITE);
	        		g.fillRect(0, 3+i*18, getWidth(), (i+1)*18);
	        	}
	        }
        }
        else if((left==0)&&(right==1)&&(compModel.getRight().isEmpty()==false)){
	        for(int i=0; i<compModel.getRight().size(); i++){
	        	if(compModel.getRight().get(i)==false){
		            g.setColor(new Color(255,239,133));
		            g.fillRect(0, 3+i*18, getWidth(), (i+1)*18);    
	        	}
	        	else if(compModel.getRight().get(i)==true){
	        		g.setColor(Color.WHITE);
	        		g.fillRect(0, 3+i*18, getWidth(), (i+1)*18);
	        	}
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
    
    public void setCompareModel(boolean isleft, CompareModel cm){
    	compModel=cm;

    	if(isleft==true){
    		left=1;
    		right=0;
    	}
    	else if(isleft==false){
    		left=0;
    		right=1;
    	}
    }
}