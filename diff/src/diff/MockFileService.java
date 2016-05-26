package diff;

import java.io.File;

public class MockFileService extends FileService{
	public MockFileService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileModel load(Boolean lr,File file,FileModel model){
		System.out.println("load called : fileName="+file.getPath()+"; lr="+lr);
		String[] temp = {"abcde","fg","abc","","aa"};
		if(lr == false) model.setLeft(temp);
		else model.setRight(temp);
		return model;
	}
	public void save(Boolean lr,File file,FileModel model){
		System.out.println("Mock File Saved to :"+file.getPath());
		String[] temp;
		if(lr)
			temp=model.getRight();
		else
			temp=model.getLeft();
		for(int i=0;i<temp.length;i++)
		{
			System.out.println(temp[i]);
		}
	}
}
