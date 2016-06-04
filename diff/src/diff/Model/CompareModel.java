package diff.Model;

import java.util.ArrayList;
/**
 * 비교 결과를 저장하는 객체입니다.
 * 
 * ArrayList<Integer> 형태로 left,right가 있으며 각 줄의 내용이 다른 줄을 표시합니다.
 * 0:반대쪽과 다름.
 * 1:반대쪽과 같음
 * -1:반대쪽과 줄 수가 달라 공백을 넣음.
 * 
 * FileModel객체 하나를 같이 저장합니다.
 * 
 * @author 임철우
 *
 */
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
