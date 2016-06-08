package Util;
import diff.Model.*;
public class ModelUtil {
	public static FileModel getOriginal(CompareModel cm){
		FileModel fileModel = cm.getFileModel();
		for(int i=0;i<fileModel.getLeft().size();i++){
			if(cm.getLeft().get(i)==-1){
				cm.getLeft().remove(i);
				fileModel.getLeft().remove(i);
				i--;
			}
		}
		for(int i=0;i<fileModel.getRight().size();i++){
			if(cm.getRight().get(i)==-1){
				cm.getRight().remove(i);
				fileModel.getRight().remove(i);
				i--;
			}
		}
		return fileModel;
	}
}
