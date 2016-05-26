package diff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;

import diff.View;

public class Controller{
	private FileModel fileModel;
    private View view;
    private FileService fileService;
    private CompareService compareService;
    private MergeService mergeService;
    
    private ActionListener actionListener;
    
    public Controller(View v, FileModel fm, FileService fs, CompareService cs, MergeService ms){
        this.view = v;
        this.fileModel = fm;
        this.fileService = fs;
        this.compareService = cs;
        this.mergeService = ms;
    }
    public FileModel load(Boolean lr,File file,FileModel fileModel){
    	return fileService.load(lr,file,fileModel);
    }
    public void save(Boolean lr,File file,FileModel fileModel){
    	fileService.save(lr, file, fileModel);
    }
    public CompareModel compare(FileModel fileModel){
    	return compareService.compare(fileModel);
    }
    public FileModel merge(Boolean lr,FileModel fileModel){
    	return mergeService.merge(lr,fileModel);
    }
    public void contol(){        
        /*actionListener = new ActionListener() {
        	
              public void actionPerformed(ActionEvent actionEvent) {
            	  JButton Button = (JButton)actionEvent.getSource();
            	  
	            	  if(Button.equals(view.getLeftTextPanel().getLoadButton())){
	            		  int returnval=jf.showOpenDialog(null);
	            		    
	            		    if(returnval == JFileChooser.APPROVE_OPTION)     
	            		    	file = jf.getSelectedFile();
	            		  //FileService���� load�϶�� �ϰ�, 
	            		  fileController.load(true,file,fileModel);       
	            		  view.getLeftTextPanel().getTextArea().setText(null);
            			  /**
            			   *  View���� �ε��� ������ ������ �������(insertString) �Ѵ�. 
            			   *  TODO: �ڵ尡 �ſ� �������ؼ� view�� �޼ҵ� �߰� �ʿ�.	  
            			   
	            		  for(int i=0; i<fileModel.getLeftList().size(); i++){	            			  
	            			  try {
								view.getLeftTextPanel().getDoc().insertString(view.getLeftTextPanel().getDoc().getLength(),fileModel.getLeftList().get(i),view.getLeftTextPanel().getDoc().getStyle("red"));
							} catch (BadLocationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            		  }         			  
	            	  }
	            	  if(Button.equals(view.getLeftTextPanel().getEditButton())){
	            		  if(view.getLeftTextPanel().getEditable()==false)
	            		  {
	            			  view.getLeftTextPanel().getTextArea().setEditable(true);
	            			  view.getLeftTextPanel().switchEdit(true);
	            		  }
	            		  else{
		            		  view.getLeftTextPanel().getTextArea().setEditable(false);
		            		  view.getLeftTextPanel().switchEdit(false);
	            		  }
	            	  }
	            	  if(Button.equals(view.getLeftTextPanel().getSaveButton())){
	            		  fileService.save(true); 
	            	  }
	            	  /**################################################**
	            	  if(Button.equals(view.getRightTextPanel().getLoadButton())){
	            		  //FileService���� load�϶�� �ϰ�, 
	            		  fileService.load(false);  
	            		  view.getRightTextPanel().getTextArea().setText(null);
	            		  for(int i=0; i<fileModel.getRightList().size(); i++){
	            			  try {
								view.getRightTextPanel().getDoc().insertString(view.getRightTextPanel().getDoc().getLength(),fileModel.getRightList().get(i),view.getRightTextPanel().getDoc().getStyle("black"));
							} catch (BadLocationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            		  }
	            	  }
	            	  if(Button.equals(view.getRightTextPanel().getEditButton())){
	            		  if(view.getRightTextPanel().getEditable()==false)
	            		  {
	            			  view.getRightTextPanel().getTextArea().setEditable(true);
	            			  view.getRightTextPanel().switchEdit(true);
	            		  }
	            		  else{
		            		  view.getRightTextPanel().getTextArea().setEditable(false);
		            		  view.getRightTextPanel().switchEdit(false);
	            		  }
	            	  }
	            	  if(Button.equals(view.getRightTextPanel().getSaveButton())){
	            		  fileService.save(false); 
	            	  }
	            	  
	            	  
            	  
              }
        };                
       view.getLeftTextPanel().getLoadButton().addActionListener(actionListener);  //left�г��� load��ư �׼� �߰�.
       view.getLeftTextPanel().getEditButton().addActionListener(actionListener);
       view.getLeftTextPanel().getSaveButton().addActionListener(actionListener);
       view.getRightTextPanel().getLoadButton().addActionListener(actionListener);
       view.getRightTextPanel().getEditButton().addActionListener(actionListener);
       view.getRightTextPanel().getSaveButton().addActionListener(actionListener);*/
       
    }


    
    //private void func(){
        //model.somefunc();                
        //view.changestate(model.resultVal);
    //}    
    /**
      TODO: Compare ��ư�� Ŭ���Ǹ�, Controller�� View�κ��� ����ڿ��Լ� �Էµ�  �� ��(����, ������)�� str buffer ���� ��  
      Model���� �Ѱ� �ְ� Model�� ���ϵ��� ���Ѿ���.
    */
    
}