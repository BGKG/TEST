package diff;

import java.util.ArrayList;

public class MergeService {
	/**
	 * Mergeservice �� ���� method.
	 * @param lr Left to Right : false, Right to Left : true
	 * @param fileModel merge�� ���� �������� filemodel
	 * @param index current curser index
	 * @param comparemodel filemodel �� comapremodel
	 * @return filemodel after merging
	 */
	public FileModel merge(Boolean lr,FileModel fileModel,CompareModel comparemodel, int index){
		// initialize
		ArrayList<String> targetstring;
		ArrayList<String> basestring;
		ArrayList<Boolean> targetcompare;
		ArrayList<Boolean> basecompare;
		
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
			if(basecompare.get(i))
				baseTrue++;
		}
		//set basefront
		for(i=index;basecompare.get(i);i--)
			basefront=i;
		//set baseback
		for(i=index;basecompare.get(i);i++)
			baseback=i;
		//set targetTrue
		for(i=0;targetTrue<baseTrue;i++){
			if(targetcompare.get(i))
				targetTrue++;
		}

		// merge with variable
		for(;targetcompare.get(i);i++)
			targetstring.remove(i);
		for(;basefront<=baseback;basefront++)
			targetstring.add(i, basestring.get(basefront));
		
		return fileModel;
	}
}
