package diff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JFileChooser;

public class FileService {
	private FileModel fileModel;
	private File loadedFile;
	
	public FileService(FileModel fm){
		this.fileModel=fm;
	}
	public void load(Boolean lr){
		JFileChooser jf = new JFileChooser();
	    int returnval=jf.showOpenDialog(null);
	    File f = null;
	    
	    if(returnval == JFileChooser.APPROVE_OPTION)     
	    	f = jf.getSelectedFile(); 
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(f));
	        String s;
	        String[] result = null;
	        for (int i=0; (s = in.readLine()) != null; i++) {
	        	fileModel.getAryList().add(s+"\n");
	        }
	        fileModel.setLeft(result);
	    } catch (IOException ex) {
	        //Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
		//return fileModel;
	}
	
	public FileModel getFileModel(){return fileModel;}
	public File getFile(){return loadedFile;}
	/**
	 * ������ ��ġ�� ���Ͽ� �����մϴ�
	 * 
	 * @param lr ������ false,������ true
	 * @param file ��������.
	 * @param model �¿� ���빰 ����.
	 */
	public void save(Boolean lr,File file,FileModel model){
		
	}
}
