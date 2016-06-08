package diff.Service;

import java.util.ArrayList;

import diff.Model.CompareModel;
import diff.Model.FileModel;

public class MergeService {
	/**
	 * Mergeservice 를 위한 method.
	 * @param lr Left to Right : false, Right to Left : true
	 * @param fileModel merge를 위해 전해지는 filemodel
	 * @param index current curser index
	 * @param comparemodel filemodel 의 comapremodel
	 * @return filemodel after merging
	 */
	public FileModel merge(Boolean lr,FileModel fileModel,CompareModel comparemodel, int index){
		// initialize
		ArrayList<String> targetstring;
		ArrayList<String> basestring;
		ArrayList<Integer> targetcompare;
		ArrayList<Integer> basecompare;
		
		if(lr){
			targetstring = fileModel.getLeft();
			basestring = fileModel.getRight();
			targetcompare = comparemodel.getLeft();
			basecompare = comparemodel.getRight();
		}
		else{
			targetstring = fileModel.getRight();
			basestring = fileModel.getLeft();
			targetcompare = comparemodel.getRight();
			basecompare = comparemodel.getLeft();
		}
		
		if(basecompare.get(index)==1)
			return fileModel;
		
		int i, baseFrontCheck;
		
		for(baseFrontCheck=index;baseFrontCheck>=0;baseFrontCheck--){
			if(basecompare.get(baseFrontCheck) == 1)
				break;
		}
		
	
		
		for(i=baseFrontCheck+1;i<basecompare.size();i++){
			if(basecompare.get(i)==1)
					break;
			if(basecompare.get(i) == 0){
				targetstring.set(i, basestring.get(i));
				targetcompare.set(i, 1);
				basecompare.set(i, 1);
			}
			else if(basecompare.get(i) == -1){
				targetstring.remove(i);
				basestring.remove(i);
				targetcompare.remove(i);
				basecompare.remove(i);
				i--;
			}
		}
		
		
		//set filemodel
		if(lr){
			fileModel.setLeft(targetstring);
			fileModel.setRight(basestring);
			comparemodel.setLeft(targetcompare);
			comparemodel.setRight(basecompare);
		}
		else{
			fileModel.setRight(targetstring);
			fileModel.setLeft(basestring);
			comparemodel.setRight(targetcompare);
			comparemodel.setLeft(basecompare);
		}
		
		return fileModel;
	}
}
