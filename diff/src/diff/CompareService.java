package diff;

public class CompareService {
	CompareModel compare(FileModel filemodel){
		CompareModel comparemodel = new CompareModel();
		
		String[] leftString = filemodel.getLeft();
		String[] rightString = filemodel.getRight();
		boolean[] leftCompare = new boolean[leftString.length];
		boolean[] rightCompare = new boolean[rightString.length];
		
		// left = n, right = m
		int n,m;
		int temp=0;
		
		for(n=0;n < leftString.length;n++){
			leftCompare[n] = false;
			
			for(m=temp;m < rightString.length;m++){
				rightCompare[m] = false;
					
				if(leftString[n] == rightString[m]){
					leftCompare[n] = true;
					rightCompare[m] = true;
					temp = m+1;
					break;
				}
			}
		}
		
		comparemodel.setLeft(leftCompare);
		comparemodel.setRight(rightCompare);
		
		return comparemodel;
	}
}
