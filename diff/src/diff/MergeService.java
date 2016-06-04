package diff;

import java.util.ArrayList;

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
		
		// initialize variable
		int targetTrue=0, baseTrue=0;
		int basefront=0, baseback=0;
		int i=0; // loopcounter
		//set baseTrue
		for(;i<index;i++){
			if(basecompare.get(i)==1)
				baseTrue++;
		}
		//set basefront
		for(i=index;basecompare.get(i)==1;i--)
			basefront=i;
		//set baseback
		for(i=index;basecompare.get(i)==1;i++)
			baseback=i;
		//set targetTrue
		for(i=0;targetTrue<baseTrue;i++){
			if(targetcompare.get(i)==1)
				targetTrue++;
		}

		// merge with variable
		for(;targetcompare.get(i)==1;i++)
			targetstring.remove(i);
		for(;basefront<=baseback;basefront++)
			targetstring.add(i, basestring.get(basefront));

		//set filemodel
		if(lr)
			fileModel.setLeft(targetstring);
		else
			fileModel.setRight(targetstring);
		
		return fileModel;
	}
}
