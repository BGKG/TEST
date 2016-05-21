package diff;

public class MergeService {
	public FileModel merge(Boolean lr,FileModel fileModel){
		if(lr)
			fileModel.setRight(fileModel.getLeft());
		else
			fileModel.setLeft(fileModel.getRight());
		return fileModel;
	}
}
