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
            	FileService fileService = new FileService(fileModel);

                View view = new View(fileModel); 
                Controller controller = new Controller(view, fileModel, fileService);
                controller.contol();
            }
        });  
    }
}