package diff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import diff.View;

public class Controller{
	private FileModel fileModel;
    private View view;
    private FileService fileService;
    
    private ActionListener actionListener;
    
    public Controller(View v, FileModel fm, FileService fs){
        this.view = v;
        this.fileModel = fm;
        this.fileService = fs;                  
    }
    
    public void contol(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {
            	  JButton Button = (JButton)actionEvent.getSource();
            	  
	            	  if(Button.equals(view.getLeftTextPanel().getLoadButton())){
	            		  //FileService에게 load하라고 하고, 
	            		  fileService.load(true);       
	            		  view.getLeftTextPanel().getTextArea().setText(null);
	            		  for(int i=0; i<fileModel.getLeftList().size(); i++)
	            			  //View에게 로드한 파일의 내용을 적으라고(setText) 한다.	            			  
	            			  view.getLeftTextPanel().getTextArea().append(fileModel.getLeftList().get(i));
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
	            	  /**################################################**/
	            	  if(Button.equals(view.getRightTextPanel().getLoadButton())){
	            		  //FileService에게 load하라고 하고, 
	            		  fileService.load(false);  
	            		  view.getRightTextPanel().getTextArea().setText(null);
	            		  for(int i=0; i<fileModel.getRightList().size(); i++)
	            			  //View에게 로드한 파일의 내용을 적으라고(setText) 한다.
	            			  view.getRightTextPanel().getTextArea().append(fileModel.getRightList().get(i));
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
       view.getLeftTextPanel().getLoadButton().addActionListener(actionListener);  //left패널의 load버튼 액션 추가.
       view.getLeftTextPanel().getEditButton().addActionListener(actionListener);
       view.getLeftTextPanel().getSaveButton().addActionListener(actionListener);
       view.getRightTextPanel().getLoadButton().addActionListener(actionListener);
       view.getRightTextPanel().getEditButton().addActionListener(actionListener);
       view.getRightTextPanel().getSaveButton().addActionListener(actionListener);
       
    }


    
    //private void func(){
        //model.somefunc();                
        //view.changestate(model.resultVal);
    //}    
    /**
      TODO: Compare 버튼이 클릭되면, Controller는 View로부터 사용자에게서 입력된  두 개(왼쪽, 오른쪽)의 str buffer 얻은 후  
      Model에게 넘겨 주고 Model이 일하도록 시켜야함.
    */
    
}