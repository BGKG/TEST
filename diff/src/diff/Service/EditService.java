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
	        FileModel ret = new FileModel();
	        if(lr==true){
	        	s=textarea.getText().split("\n");

		        for (int i=0; i<s.length; i++) {
		        	ret.getLeft().add(s[i]+"\n");
		        }
		        ret.setRight(fileModel.getRight());
	        }
	        else{
	        	s=textarea.getText().split("\n");

		        for (int i=0; i<s.length; i++) {
		        	ret.getRight().add(s[i]+"\n");
		        }
		        ret.setLeft(fileModel.getLeft());
	        }
	    
		return ret;
	}
}