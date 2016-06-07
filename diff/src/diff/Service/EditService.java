package diff.Service;

import diff.Model.FileModel;
import diff.View.ColoredJTextPane;

public class EditService {
	public EditService(){
	}
	/**
	 * edit을 위한 서비스. edit 후의 filemodel을 재설정함.
	 * @param lr 좌true 우false
	 * @param fileModel filemodel
	 * @param textarea 해당 패널의 textarea
	 */
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