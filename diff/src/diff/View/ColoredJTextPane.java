package diff.View;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
//import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.plaf.ComponentUI;
//import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
//import javax.swing.text.ParagraphView;
/**
 * 각 라인을 Highlight할 수 있는 JTextPane입니다.
 */
public class ColoredJTextPane extends JTextPane{
	private ArrayList<Integer> compare;
	//private Rectangle CaretRect;
	private int row;

    public ColoredJTextPane() {
        // super.paintComponent(g);
        this.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent ce) {
                int pos = getCaretPosition();
                Element map = getDocument().getDefaultRootElement();
                row = map.getElementIndex(pos);
            }
        });
        setOpaque(false);
    }
	 /**
	  * 색칠을 담당합니다. paintComponent를 Override.
	  */
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if(compare!=null){
	        for(int i=0; i<compare.size(); i++){
	        	if(compare.get(i)<1){
	        		if(compare.get(i)==0)
	        			g.setColor(new Color(255,239,133));
	        		else
	        			g.setColor(new Color(230,230,230));
		            g.fillRect(0, 3+i*18, getWidth(), (i+1)*18);
	        	}
	        	else if(compare.get(i)==1){
	        		g.setColor(Color.WHITE);
	        		g.fillRect(0, 3+i*18, getWidth(), (i+1)*18);
	        	}
	        }
        }
		/*
        	선택된 라인 Highlighter. 있으면 거슬리기만 해서 주석처리함.
          try {
        	CaretRect = modelToView(getCaretPosition());
            if (CaretRect != null) {
                g.setColor(new Color(212,244,255));
                g.fillRect(0, CaretRect.y, getWidth(), CaretRect.height);
            }
        } catch (BadLocationException e) {
        	e.printStackTrace();
        }
        */
        super.paintComponent(g);
    }
    
    /**
     * JTextPane이 강제 개행하는 것을 막아줍니다.
     */
    public boolean getScrollableTracksViewportWidth() {
        Component parent = getParent();
        ComponentUI ui = getUI();

        return parent != null ? (ui.getPreferredSize(this).width <= parent
            .getSize().width) : true;
    }
    
    public void repaint(long tm, int x, int y, int width, int height) {
        super.repaint(tm, 0, 0, getWidth(), getHeight());
    }
    public void setCompare(ArrayList<Integer> cm){
    	compare=cm;
    }
    
    public int getRowPos(){
    	return row;
    }
}