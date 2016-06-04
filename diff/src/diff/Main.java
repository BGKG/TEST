package diff;

import javax.swing.SwingUtilities;
import diff.*;
import diff.Model.FileModel;
import diff.Service.CompareService;
import diff.Service.EditService;
import diff.Service.FileService;
import diff.Service.MergeService;
import diff.View.View;

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
            	EditService editService = new EditService();
            	
				View view = new View(); 
                Controller controller = new Controller(view, fileModel, fileService,compareService,mergeService,editService);
                view.setController(controller);
                //controller.contol();
            }
        });  
    }
}