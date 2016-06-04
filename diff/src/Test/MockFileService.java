package Test;

import java.io.File;
import java.util.ArrayList;

import diff.Model.FileModel;
import diff.Service.FileService;

public class MockFileService extends FileService{
	public MockFileService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileModel load(Boolean lr,File file,FileModel model){
		System.out.println("load called : fileName="+file.getPath()+"; lr="+lr);
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("asdfasdf");
		temp.add("as  dfasdfasdf");
		temp.add("");
		temp.add("aaaaa");
		temp.add("bbbbb");
		if(lr == false) model.setLeft(temp);
		else model.setRight(temp);
		return model;
	}
	public void save(Boolean lr,File file,FileModel model){
		System.out.println("Mock File Saved to :"+file.getPath());
		ArrayList<String>temp= new ArrayList<String>();
		if(lr)
			temp=model.getRight();
		else
			temp=model.getLeft();
		for(int i=0;i<temp.size();i++)
		{
			System.out.println(temp.get(i));
		}
	}
}
