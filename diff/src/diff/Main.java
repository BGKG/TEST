package diff;

import javax.swing.SwingUtilities;


import diff.View.*;
import diff.Controller.*;

public class Main
{
    public static void main(String[] args) {           
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {          
            	FileModel fileModel = new FileModel();
            	FileService fileService = new FileService();
            	CompareService compareService = new CompareService();
            	MergeService mergeService = new MergeService();

				View view = new View(); 
                Controller controller = new Controller(view, fileModel, fileService,compareService,mergeService);
                view.setController(controller);
                //controller.contol();
            }
        });  
    }
}