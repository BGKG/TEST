package diff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

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
        compareBt.setEnabled(false);
        copy2rightBt.addActionListener(this);
        copy2rightBt.setEnabled(false);      
        copy2leftBt.addActionListener(this);
        copy2leftBt.setEnabled(false);
        
        leftPanel= new TextAreaWithToolbarOnJPanel("leftpanel");
        rightPanel= new TextAreaWithToolbarOnJPanel("rightpanel");
	    sp.setLeftComponent(leftPanel);
	    sp.setRightComponent(rightPanel);   
    }
    
    public void actionPerformed(ActionEvent e){

		JButton Button = (JButton)e.getSource();
	    if(Button.equals(compareBt)){
	    	//FileModel fm = new FileModel();
	    	//fm.setLeft((ArrayList<String>) Arrays.asList(leftPanel.textarea.getText().split("\n")));
	    	//fm.setRight((ArrayList<String>) Arrays.asList(rightPanel.textarea.getText().split("\n")));
	    		leftPanel.textarea.setCompareModel(true,controller.compare(fileModel));
		    	rightPanel.textarea.setCompareModel(false,controller.compare(fileModel));
		    	super.repaint();
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
    		scrollpane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    		
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
    	
    	public ColoredJTextPane getColoredJTextPane(){
    		return textarea;
    	}
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
			    	for(int i=0; i<fileModel.getLeft().size(); i++){	            			  
			    		try {
			    			doc.insertString(doc.getLength(), fileModel.getLeft().get(i), doc.getStyle("black"));
			    		} catch (BadLocationException ex) {
			    			// TODO Auto-generated catch block
			    			ex.printStackTrace();
			    		}
			    	}
		    	}
		    	else{
		    		isLoaded=true;
			    	for(int i=0; i<fileModel.getRight().size(); i++){	            			  
			    		try {
			    			doc.insertString(doc.getLength(), fileModel.getRight().get(i), doc.getStyle("black"));
			    		} catch (BadLocationException ex) {
			    			// TODO Auto-generated catch block
			    			ex.printStackTrace();
			    		}
			    	}		    		
		    	}
		    	if(leftPanel.isLoaded==true&&rightPanel.isLoaded==true){
		    		compareBt.setEnabled(true);
		            copy2rightBt.setEnabled(true);
		            copy2leftBt.setEnabled(true);
		    	}
	    		fileModel=controller.edit(true, fileModel, leftPanel.textarea);
	    		fileModel=controller.edit(false, fileModel, rightPanel.textarea);
		    }
		    if(Button.equals(leftPanel.editBt)){
		    	if(isEditable==false)
		    	{
		    		textarea.setEditable(true);
		    		loadBt.setEnabled(false);
		    		saveBt.setEnabled(false);
		    		compareBt.setEnabled(false);
		    		copy2rightBt.setEnabled(false);
		    		copy2leftBt.setEnabled(false);
		    		rightPanel.loadBt.setEnabled(false);
		    		rightPanel.editBt.setEnabled(false);
		    		rightPanel.saveBt.setEnabled(false);
		    		switchEdit(true);
		    	}
		    	else{
		    		textarea.setEditable(false);
		    		loadBt.setEnabled(true);
		    		saveBt.setEnabled(true);
		    		compareBt.setEnabled(true);
		    		copy2rightBt.setEnabled(true);
		    		copy2leftBt.setEnabled(true);
		    		rightPanel.loadBt.setEnabled(true);
		    		rightPanel.editBt.setEnabled(true);
		    		rightPanel.saveBt.setEnabled(true);		    		
		    		fileModel=controller.edit(true, fileModel, textarea);
		    		switchEdit(false);
		    		}		    		
		    }
		    if(Button.equals(rightPanel.editBt)){
		    	if(isEditable==false)
		    	{
		    		textarea.setEditable(true);
		    		loadBt.setEnabled(false);
		    		saveBt.setEnabled(false);
		    		compareBt.setEnabled(false);
		    		copy2rightBt.setEnabled(false);
		    		copy2leftBt.setEnabled(false);
		    		leftPanel.loadBt.setEnabled(false);
		    		leftPanel.editBt.setEnabled(false);
		    		leftPanel.saveBt.setEnabled(false);
		    		switchEdit(true);
		    	}
		    	else{
		    		textarea.setEditable(false);
		    		loadBt.setEnabled(true);
		    		saveBt.setEnabled(true);
		    		compareBt.setEnabled(true);
		    		copy2rightBt.setEnabled(true);
		    		copy2leftBt.setEnabled(true);
		    		leftPanel.loadBt.setEnabled(true);
		    		leftPanel.editBt.setEnabled(true);
		    		leftPanel.saveBt.setEnabled(true);		    		
		    		fileModel=controller.edit(false, fileModel, textarea);
		    		switchEdit(false);
		    		}	    		
		    }		    	    
		    if(Button.equals(leftPanel.saveBt)){
		    	controller.save(true, file, fileModel); 
		    }
		    if(Button.equals(rightPanel.saveBt)){
		    	controller.save(false, file, fileModel); 
		    }		    
		}
    }	   
}