package diff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import diff.View;

public class Controller {

    private Model model;
    private View view;
    private ActionListener actionListener;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
                          
    }
    
    public void contol(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  //func();
              }
        };                
       // view.getButton().addActionListener(actionListener);   
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