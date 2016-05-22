package diff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import diff.View;

public class Controller {
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
            	  fileService.load(true);                                                //FileService에게 load하라고 하고,
            	  for(int i=0; i<fileModel.getAryList().size(); i++)
            		  view.getLeftTextPanel().getTextArea().append(fileModel.getAryList().get(i));//View에게 로드한 파일의 내용을 적으라고(setText) 한다.
              }
        };                
       view.getLeftTextPanel().getLoadButton().addActionListener(actionListener);  //left패널의 load버튼 액션 추가.
 
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