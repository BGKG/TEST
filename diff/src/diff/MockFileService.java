package diff;

import java.io.File;

public class MockFileService extends FileService{
	public MockFileService(FileModel fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	FileModel load(Boolean lr,FileModel model){
		System.out.println("load called : fileName="+this.getFile().getPath()+"; lr="+lr);
		String[] temp = {"abcde","fg","abc","","aa"};
		if(lr == false) model.setLeft(temp);
		else model.setRight(temp);
		return model;
	}
	void save(Boolean lr,FileModel model){
		System.out.println("Mock File Saved to :"+this.getFile().getPath());
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
