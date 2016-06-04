package diff;
import java.util.ArrayList;

public class CompareService {
	private ArrayList<Integer> leftCompare;
	private ArrayList<Integer> rightCompare;
	
	/**
	 * compare 메인로직
	 * @param filemodel file input class 에서 만들어준 filemodel 을 그대로 가져옴
	 * @return comparemodel 을 만들어 리턴해줌.
	 */
	public CompareModel compare(FileModel filemodel){
		
		// initialize 
		CompareModel comparemodel = new CompareModel();
		ArrayList<String> leftString = filemodel.getLeft();
		ArrayList<String> rightString = filemodel.getRight();
		int[][] tempCompare = new int[rightString.size()+1][leftString.size()+1];
		leftCompare = new ArrayList<Integer>();
		rightCompare = new ArrayList<Integer>();
		int n=0, m=0; // for loop counter, left=n, right=m
		
		
		// initialize compare array value
		for(n=0 ; n<leftString.size()+1 ; n++){
		tempCompare[0][n] = 0;
			if(n<leftString.size())
				leftCompare.add(0);
		}
		
		for(m=0 ; m<rightString.size()+1 ; m++){
		tempCompare[m][0] = 0;
			if(m<rightString.size())
				rightCompare.add(0);
		}
		
		
		// set compare array left = n, right = m
		for(m=1 ; m < rightString.size()+1 ; m++){
			for(n=1 ; n < leftString.size()+1 ; n++){
				try {
					if (leftString.get(n - 1).equals(rightString.get(m - 1)))
						tempCompare[m][n] = tempCompare[m - 1][n - 1] + 1;

					else {
						if (tempCompare[m - 1][n] > tempCompare[m][n - 1])
							tempCompare[m][n] = tempCompare[m - 1][n];
						else
							tempCompare[m][n] = tempCompare[m][n - 1];
					}

				} catch (NullPointerException e) {
					continue;
				}
			}
		}
		
		
		RecursiveCompareLogic(n-1, m-1, tempCompare);
		for(n=0;n<leftCompare.size();n++){
			if(leftCompare.get(n)==0 && rightCompare.get(n)==1){
				rightCompare.add(n,-1);
				rightString.add(n,"\n");
			}
			if(leftCompare.get(n)==1 && rightCompare.get(n)==0){
				leftCompare.add(n,-1);
				leftString.add(n,"\n");
			}
		}
		filemodel.setLeft(leftString);
		filemodel.setRight(rightString);
		comparemodel.setLeft(leftCompare);
		comparemodel.setRight(rightCompare);
		comparemodel.setFileModel(filemodel);
		return comparemodel;
	}
	
	/**
	 * compareservice 내부에서만 사용하는 method. 사용금지
	 * @param n leftstring loopcounter
	 * @param m rightstring loopcounter
	 * @param tempCompare LCS algorithm 을 사용하기위한 2차원배열
	 */
	private void RecursiveCompareLogic(int n,int m,int[][] tempCompare){
		
		if(n==0  || m==0)
			return;
		
		if(tempCompare[m][n]==tempCompare[m][n-1]){
			leftCompare.set(n-1, 0);
			rightCompare.set(m-1, 0);
			RecursiveCompareLogic(n-1,m,tempCompare);
		}
		else if(tempCompare[m][n]==tempCompare[m-1][n]){
			leftCompare.set(n-1, 0);
			rightCompare.set(m-1, 0);
			RecursiveCompareLogic(n,m-1,tempCompare);
		}
		else if(tempCompare[m][n]!=tempCompare[m][n-1] 
				&& tempCompare[m][n]!=tempCompare[m-1][n]){
			leftCompare.set(n-1, 1);
			rightCompare.set(m-1, 1);
			RecursiveCompareLogic(n-1,m-1,tempCompare);
		}
	}
}
