package diff;
import java.util.ArrayList;

public class CompareService {
	private ArrayList<Boolean> leftCompare;
	private ArrayList<Boolean> rightCompare;
	
	/**
	 * compare ���η���
	 * @param filemodel file input class ���� ������� filemodel �� �״�� ������
	 * @return comparemodel �� ����� ��������.
	 */
	CompareModel compare(FileModel filemodel){
		
		// initialize 
		CompareModel comparemodel = new CompareModel();
		String[] leftString = filemodel.getLeft();
		String[] rightString = filemodel.getRight();
		int[][] tempCompare = new int[rightString.length+1][leftString.length+1];
		leftCompare = new ArrayList<Boolean>();
		rightCompare = new ArrayList<Boolean>();
		int n=0, m=0; // for loop counter, left=n, right=m
		
		
		// initialize compare array value
		for(n=0 ; n<leftString.length+1 ; n++){
		tempCompare[0][n] = 0;
			if(n<leftString.length)
				leftCompare.add(null);
		}
		
		for(m=0 ; m<rightString.length+1 ; m++){
		tempCompare[m][0] = 0;
			if(m<rightString.length)
				rightCompare.add(null);
		}
		
		
		// set compare array left = n, right = m
		for(m=1 ; m < rightString.length+1 ; m++){
			for(n=1 ; n < leftString.length+1 ; n++){
				if(leftString[n-1] == rightString[m-1])
					tempCompare[m][n] = tempCompare[m-1][n-1] + 1;
				
				else{
					if(tempCompare[m-1][n] > tempCompare[m][n-1])
						tempCompare[m][n] = tempCompare[m-1][n];
					else
						tempCompare[m][n] = tempCompare[m][n-1];
				}
			}
		}
		
		RecursiveCompareLogic(n-1, m-1, tempCompare);
		
		comparemodel.setLeft(leftCompare);
		comparemodel.setRight(rightCompare);
		
		return comparemodel;
	}
	
	/**
	 * compareservice ���ο����� ����ϴ� method. ������
	 * @param n leftstring loopcounter
	 * @param m rightstring loopcounter
	 * @param tempCompare LCS algorithm �� ����ϱ����� 2�����迭
	 */
	private void RecursiveCompareLogic(int n,int m,int[][] tempCompare){
		
		if(n==0  || m==0)
			return;
		
		if(tempCompare[m][n]==tempCompare[m][n-1]){
			leftCompare.set(n-1, false);
			rightCompare.set(m-1, false);
			RecursiveCompareLogic(n-1,m,tempCompare);
		}
		else if(tempCompare[m][n]==tempCompare[m-1][n]){
			leftCompare.set(n-1, false);
			rightCompare.set(m-1, false);
			RecursiveCompareLogic(n,m-1,tempCompare);
		}
		else if(tempCompare[m][n]!=tempCompare[m][n-1] 
				&& tempCompare[m][n]!=tempCompare[m-1][n]){
			leftCompare.set(n-1, true);
			rightCompare.set(m-1, true);
			RecursiveCompareLogic(n-1,m-1,tempCompare);
		}
	}
}
