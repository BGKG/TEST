package diff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.*;

public class View extends JFrame{

    private JToolBar toptoolbar = new JToolBar();
    private JSplitPane sp;
    //private FileModel
    private JButton compareBt = new JButton("Compare");
    private JButton copy2rightBt = new JButton("C2R");
    private JButton copy2left = new JButton("C2L");  
    
    private JFileChooser filechooser = new JFileChooser();
    
    private TextAreaWithToolbarOnJPanel leftPanel = new TextAreaWithToolbarOnJPanel();
    private TextAreaWithToolbarOnJPanel rightPanel = new TextAreaWithToolbarOnJPanel();

    private ActionListener actionListener;
   
    
    public View(){
    	this.setTitle("Diff");
        this.setLayout(new BorderLayout());                                          
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        this.setSize(640,480);        
        this.setVisible(true);    
        
        sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
   
        toptoolbar.setFloatable(false);
        toptoolbar.add(compareBt);
        toptoolbar.add(copy2rightBt); 
        toptoolbar.add(copy2left);       
        
        
        this.add(sp, BorderLayout.CENTER);
        this.add(toptoolbar, BorderLayout.NORTH);
        
	    sp.setLeftComponent(leftPanel);
	    sp.setRightComponent(rightPanel);
	    
	    leftPanel.loadBt.addActionListener(actionListener);         

	    

	    
    }
        
    public class TextAreaWithToolbarOnJPanel extends JPanel{
    	
       	private JToolBar toolbar;   	
    	private JScrollPane scrollpane;
    	private JTextArea textarea;
    	private JButton loadBt, editBt, saveBt;
    	private String strbuf;
    	
    	public TextAreaWithToolbarOnJPanel(){
    		loadBt = new JButton("Load");
    		editBt = new JButton("Edit");
    		saveBt = new JButton("Save");

    		toolbar = new JToolBar();
    		textarea = new JTextArea();
    		scrollpane = new JScrollPane(textarea);
    		
    		
    		toolbar.add(loadBt);
    		toolbar.add(editBt);
    		toolbar.add(saveBt);
    		
    		InitToolBar(toolbar);
    		InitScrollPane(scrollpane);
    		
    		this.setLayout(new BorderLayout());  		
    		this.add(toolbar, BorderLayout.NORTH);
    		this.add(scrollpane, BorderLayout.CENTER);

    	}
    	public JButton getButton(String str){   		

    		return loadBt;
    	}
    	
    }
	public void InitScrollPane(JScrollPane sp){
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
	}
	public void InitToolBar(JToolBar tb){
		tb.setFloatable(false);
	}
	//public JButton getButton()
	/**
	 * TODO: View는 Controller 또는 Model에게서 받은 Str Buffer를 가지고 컬러 표시 처리해야함.
	 */
}