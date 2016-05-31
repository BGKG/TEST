package diff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class View extends JFrame implements ActionListener{
	
    private JToolBar toptoolbar = new JToolBar();
    private JSplitPane sp;
    private JButton compareBt = new JButton("Compare");
    private JButton copy2rightBt = new JButton("C2R");
    private JButton copy2leftBt = new JButton("C2L");  
    private JFileChooser filechooser = new JFileChooser();
    private Controller controller;
	private FileModel fileModel = new FileModel();
    private TextAreaWithToolbarOnJPanel leftPanel;
    private TextAreaWithToolbarOnJPanel rightPanel;   
    private CompareModel testcm = new CompareModel();
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
        toptoolbar.add(copy2leftBt);       
                
        this.add(sp, BorderLayout.CENTER);
        this.add(toptoolbar, BorderLayout.NORTH);
        
        compareBt.addActionListener(this);
        copy2rightBt.addActionListener(this);
        copy2leftBt.addActionListener(this);
        
        leftPanel= new TextAreaWithToolbarOnJPanel("leftpanel");
        rightPanel= new TextAreaWithToolbarOnJPanel("rightpanel");
	    sp.setLeftComponent(leftPanel);
	    sp.setRightComponent(rightPanel);   
    }
    
    public void actionPerformed(ActionEvent e){
		JButton Button = (JButton)e.getSource();
	    if(Button.equals(compareBt)&&leftPanel.isLoaded==true){
	    		leftPanel.textarea.setCompareModel(true,testcm);
		    	rightPanel.textarea.setCompareModel(false,testcm);		    		
	    }
    }

    public TextAreaWithToolbarOnJPanel getLeftTextPanel(){return leftPanel;}
    public TextAreaWithToolbarOnJPanel getRightTextPanel(){return rightPanel;}
    
    public JFileChooser getFileChooser(){return filechooser;}
    
	public void InitScrollPane(JScrollPane sp){
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
	}
	public void InitToolBar(JToolBar tb){
		tb.setFloatable(false);
	}
	public void setController(Controller ct){
        controller=ct;
	}
    public class TextAreaWithToolbarOnJPanel extends JPanel implements ActionListener{
    	
       	private JToolBar toolbar;   	
    	private JScrollPane scrollpane;
    	private ColoredJTextPane textarea;
    	private StyledDocument doc;
    	private Style def, s;
    	private JButton loadBt, editBt, saveBt;
    	private boolean isEditable, isLeft;
    	private boolean isLoaded=false;
    	
    	public TextAreaWithToolbarOnJPanel(String str){
    		loadBt = new JButton("Load");
    		editBt = new JButton("Edit");
    		isEditable = false;
    		saveBt = new JButton("Save");

    		if(str=="leftpanel") isLeft = true;
    		else 				 isLeft = false;
    		
    		toolbar = new JToolBar();
    		textarea = new ColoredJTextPane();
    		
    		loadBt.addActionListener(this);
    		editBt.addActionListener(this);
    		saveBt.addActionListener(this);
    		
    		doc=textarea.getStyledDocument();
    		def=StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
    		s = doc.addStyle("black", def);
    		StyleConstants.setForeground(s, Color.black);
    		s = doc.addStyle("blue", def);
    		StyleConstants.setForeground(s, Color.blue);
    		s = doc.addStyle("red", def);
    		StyleConstants.setForeground(s, Color.red);
    		
    		textarea.setEditable(false);
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
    	public JButton getLoadButton(){return loadBt;}
    	public JButton getEditButton(){return editBt;}    	
    	public JButton getSaveButton(){return saveBt;}
    	public JTextPane getTextArea(){return textarea;}
    	public StyledDocument getDoc(){return doc;}
    	
    	public boolean getEditable(){return isEditable;}
    	public boolean getLoaded(){return isLoaded;}
    	public void switchEdit(boolean b){isEditable=b;}
    	public boolean isLeft(){return isLeft;}
    	
    	public void actionPerformed(ActionEvent e){
			JButton Button = (JButton)e.getSource();
			File file = null;
			
		    if(Button.equals(loadBt)){
			    int returnval=filechooser.showOpenDialog(null);
			    			    
			    if(returnval == JFileChooser.APPROVE_OPTION)     
			    	file = filechooser.getSelectedFile();
		    	
		    	fileModel=controller.load(isLeft,file,fileModel);       
		    	textarea.setText(null);
		    	if(isLeft){
		    		isLoaded=true;
			    	for(int i=0; i<fileModel.getLeftList().size(); i++){	            			  
			    		try {
			    			doc.insertString(doc.getLength(), fileModel.getLeftList().get(i), doc.getStyle("black"));
			    		} catch (BadLocationException ex) {
			    			// TODO Auto-generated catch block
			    			ex.printStackTrace();
			    		}
			    	}
			    	//textarea.diffColor(g);
		    	}
		    	else{
		    		isLoaded=true;
			    	for(int i=0; i<fileModel.getRightList().size(); i++){	            			  
			    		try {
			    			doc.insertString(doc.getLength(), fileModel.getRightList().get(i), doc.getStyle("black"));
			    		} catch (BadLocationException ex) {
			    			// TODO Auto-generated catch block
			    			ex.printStackTrace();
			    		}
			    	}		    		
		    	}        			  
		    }
		    if(Button.equals(editBt)){
		    	if(isEditable==false)
		    	{
		    		textarea.setEditable(true);
		    		switchEdit(true);
		    	}
		    	else{
		    		textarea.setEditable(false);
		    		switchEdit(false);
		    	}
		    }
		    if(Button.equals(saveBt)){
		    	//Controller.save(true, file, fm); 
		    }

		}
    }	
    
}