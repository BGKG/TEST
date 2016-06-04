package diff.Service;

import diff.Model.FileModel;
import diff.View.ColoredJTextPane;

public class EditService {
	public EditService(){
	}
	public FileModel edit(Boolean lr,FileModel fileModel, ColoredJTextPane textarea){	     
	        String[] s;

	        if(lr==true){
	        	fileModel.resetLeftList();
	        	s=textarea.getText().split("\n");

		        for (int i=0; i<s.length; i++) {
		        	fileModel.getLeft().add(s[i]+"\n");
		        }
	        }
	        else{
	        	fileModel.resetRightList();
	        	s=textarea.getText().split("\n");

		        for (int i=0; i<s.length; i++) {
		        	fileModel.getRight().add(s[i]+"\n");
		        }
	        }
	    
		return fileModel;
	}
}