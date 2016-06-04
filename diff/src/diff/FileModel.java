package diff;

import java.io.File;
import java.util.ArrayList;

public class FileModel {
	private ArrayList<String> left=new ArrayList<String>();
	private ArrayList<String> right=new ArrayList<String>();
	
	private File leftFile = null;
	private File rightFile = null;
	
	public FileModel() {
	}

	public ArrayList<String> getLeft() {
		return left;
	}

	public void setLeft(ArrayList<String> left) {
		this.left = left;
	}

	public ArrayList<String> getRight() {
		return right;
	}

	public void setRight(ArrayList<String> right) {
		this.right = right;
	}

	public void resetLeftList() {
		left.clear();
	}

	public void resetRightList() {
		right.clear();
	}

	/*
	 * public File getLeftFile(){return leftFile;} public File
	 * getRightFile(){return rightFile;} public void setLeftFile(File
	 * f){leftFile = f;} public void setRightFile(File f){rightFile = f;}
	 */

	// public void appendArray(String s){
	// testleft.add(s);
	// }
	
}
