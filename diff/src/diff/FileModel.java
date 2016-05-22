package diff;

import java.util.ArrayList;

public class FileModel {
	private String[] left;
	private String[] right;
	
	private ArrayList<String> testleft=new ArrayList<String>();
	
	public String[] getLeft() {
		return left;
	}
	public void setLeft(String[] left) {
		this.left = left;
	}
	public String[] getRight() {
		return right;
	}
	public void setRight(String[] right) {
		this.right = right;
	}
		
	
	
	public ArrayList<String> getAryList(){return testleft;}
	
	//public void appendArray(String s){
	//	testleft.add(s);
	//}
	
}
