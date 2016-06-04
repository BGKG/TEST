package diff.Model;

import java.util.ArrayList;
/**
 * �� ����� �����ϴ� ��ü�Դϴ�.
 * 
 * ArrayList<Integer> ���·� left,right�� ������ �� ���� ������ �ٸ� ���� ǥ���մϴ�.
 * 0:�ݴ��ʰ� �ٸ�.
 * 1:�ݴ��ʰ� ����
 * -1:�ݴ��ʰ� �� ���� �޶� ������ ����.
 * 
 * FileModel��ü �ϳ��� ���� �����մϴ�.
 * 
 * @author ��ö��
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
