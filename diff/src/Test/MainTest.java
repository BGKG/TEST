package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import diff.*;
import diff.Model.FileModel;
import diff.Service.CompareService;

public class MainTest {
	private CompareService compareService = new CompareService();
	@Test
	public void Test1(){
		FileModel filemodel = new FileModel();
		ArrayList<String> a = new ArrayList<String>();
		a.add("ABCDE");
		a.add("ABCDE");
		a.add("ABCDE");
		a.add("ABCDE");
		a.add("ABCDE");
		filemodel.setLeft(a);
		filemodel.setRight((ArrayList<String>)a.clone());
		compareService.compare(filemodel);
		assertEquals(filemodel.getLeft(),filemodel.getRight());
		assertNotSame(filemodel.getLeft(),filemodel.getRight());
	}
	@Test
	public void Test2(){
		ArrayList<String> a=new ArrayList<String>();
		a.add("A");
		a.add("AB");
		a.add("ABC");
		a.add("ABCD");
		a.add(1,"ABCDE");
		System.out.println(a);
	}
}
