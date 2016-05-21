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
      TODO: Compare 버튼이 클릭되면, Controller는 View로부터 사용자에게서 입력된  두 개(왼쪽, 오른쪽)의 str buffer 얻은 후  
      Model에게 넘겨 주고 Model이 일하도록 시켜야함.
    */
    
}