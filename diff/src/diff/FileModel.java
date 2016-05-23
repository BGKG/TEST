package diff;

import java.io.File;
import java.util.ArrayList;

public class FileModel {
	private String[] left;
	private String[] right;
	
	private ArrayList<String> testleft=new ArrayList<String>();
	private ArrayList<String> testright=new ArrayList<String>();
	
	File leftFile = null;
	File rightFile = null;
	
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
		
	
	
	public ArrayList<String> getLeftList(){return testleft;}
	public void resetLeftList(){testleft.clear();}
	
	public ArrayList<String> getRightList(){return testright;}	
	public void resetRightList(){testright.clear();}
	
	public File getLeftFile(){return leftFile;}
	public File getRightFile(){return rightFile;}
	public void setLeftFile(File f){leftFile = f;}
	public void setRightFile(File f){rightFile = f;}
	
	
	//public void appendArray(String s){
	//	testleft.add(s);
	//}
	
}
