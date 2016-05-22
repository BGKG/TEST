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
            	  fileService.load(true);                                                //FileService���� load�϶�� �ϰ�,
            	  for(int i=0; i<fileModel.getAryList().size(); i++)
            		  view.getLeftTextPanel().getTextArea().append(fileModel.getAryList().get(i));//View���� �ε��� ������ ������ �������(setText) �Ѵ�.
              }
        };                
       view.getLeftTextPanel().getLoadButton().addActionListener(actionListener);  //left�г��� load��ư �׼� �߰�.
 
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