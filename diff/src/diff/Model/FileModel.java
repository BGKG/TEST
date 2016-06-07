package diff.Model;

import java.util.ArrayList;

/**
 * 파일에서 불러온 결과물을 저장합니다.
 * @author 임철우
 *
 */
public class FileModel {
	private ArrayList<String> left=new ArrayList<String>();
	private ArrayList<String> right=new ArrayList<String>();
	
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
}
