package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import diff.Service.*;
import diff.Model.*;

public class MainTest {
	private CompareService compareService;
	private MergeService mergeService;
	@Before public void setUp(){
		compareService = new CompareService();
		mergeService = new MergeService();
	}
	@Test public void compareTest(){
		FileModel fileModel = new FileModel();
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("�׽�Ʈ��1");
		temp.add("�׽�Ʈ��2");
		temp.add("�׽�Ʈ��3");
		temp.add("�׽�Ʈ��4");
		temp.add("�׽�Ʈ��5");
		temp.add("�׽�Ʈ��6");
		fileModel.setLeft(temp);
		temp = new ArrayList<String>();
		temp.add("�׽�Ʈ��1");
		temp.add("�׽�Ʈ��2");
		temp.add("�׽�Ʈ��3");
		temp.add("�׽�Ʈ��3");
		temp.add("�׽�Ʈ��3");
		temp.add("�׽�Ʈ��5");
		temp.add("�׽�Ʈ��6");
		fileModel.setRight(temp);
		CompareModel result = compareService.compare(fileModel);
		ArrayList<Integer> comp = new ArrayList<Integer>();
		comp.add(1);
		comp.add(1);
		comp.add(1);
		comp.add(0);
		comp.add(-1);
		comp.add(1);
		comp.add(1);
		assertEquals(result.getLeft(),comp);
	}
	@Test
	public void mergeTest(){
		CompareModel cmp = new CompareModel();
		FileModel file = new FileModel();
		Integer[] arr = {0,0,1,1,1,1};
		cmp.setLeft(new ArrayList<Integer>(Arrays.asList(arr)));
		arr[1]=-1;
		cmp.setRight(new ArrayList<Integer>(Arrays.asList(arr)));
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("�׽�Ʈ��1");
		temp.add("�׽�Ʈ��2");
		temp.add("�׽�Ʈ��3");
		temp.add("�׽�Ʈ��4");
		temp.add("�׽�Ʈ��5");
		temp.add("�׽�Ʈ��6");
		file.setLeft(temp);
		temp = new ArrayList<String>();
		temp.add("�׽�Ʈ��");
		temp.add("");
		temp.add("�׽�Ʈ��3");
		temp.add("�׽�Ʈ��4");
		temp.add("�׽�Ʈ��5");
		temp.add("�׽�Ʈ��6");
		file.setRight(temp);
		FileModel res = mergeService.merge(true, file, cmp, 1);
		temp = new ArrayList<String>();
		temp.add("�׽�Ʈ��");
		temp.add("�׽�Ʈ��3");
		temp.add("�׽�Ʈ��4");
		temp.add("�׽�Ʈ��5");
		temp.add("�׽�Ʈ��6");
		assertEquals(res.getLeft(),temp);
	}
}
