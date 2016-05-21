package diff;

import javax.swing.SwingUtilities;

import diff.Model.*;
import diff.View.*;
import diff.Controller.*;

public class Main
{
    public static void main(String[] args) {           
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {                                           
                Model model = new Model();
                View view = new View(); 
                Controller controller = new Controller(model,view);
                controller.contol();
            }
        });  
    }
}