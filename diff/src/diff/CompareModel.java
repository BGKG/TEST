package diff;

import java.util.ArrayList;

public class CompareModel {
	private ArrayList<Boolean> left = new ArrayList<Boolean>();
	private ArrayList<Boolean> right = new ArrayList<Boolean>();
	
	public ArrayList<Boolean> getLeft() {
		return left;
	}
	public void setLeft(ArrayList<Boolean> left) {
		this.left = left;
	}
	public ArrayList<Boolean> getRight() {
		return right;
	}
	public void setRight(ArrayList<Boolean> right) {
		this.right = right;
	}
}
