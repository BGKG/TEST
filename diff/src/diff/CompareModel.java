package diff;

import java.util.ArrayList;

public class CompareModel {
	private ArrayList<Integer> left = new ArrayList<Integer>();
	private ArrayList<Integer> right = new ArrayList<Integer>();
	private FileModel fileModel;
	
	public FileModel getFileModel() {
		return fileModel;
	}
	public void setFileModel(FileModel fileModel) {
		this.fileModel = fileModel;
	}
	public ArrayList<Integer> getLeft() {
		return left;
	}
	public void setLeft(ArrayList<Integer> left) {
		this.left = left;
	}
	public ArrayList<Integer> getRight() {
		return right;
	}
	public void setRight(ArrayList<Integer> right) {
		this.right = right;
	}
}
