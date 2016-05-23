package diff;

import java.io.*;
import java.nio.file.Files;

import javax.swing.JFileChooser;

public class FileService {
	private FileModel fileModel;

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
	        String[] result;
	        s=null;
	        result=null;
	        
	        if(lr==true){
	        	fileModel.resetLeftList();
		        for (int i=0; (s = in.readLine()) != null; i++) {
		        	fileModel.getLeftList().add(s+"\n");
		        }
		        fileModel.setLeftFile(f);
	        }
	        else{
	        	fileModel.resetRightList();
		        for (int i=0; (s = in.readLine()) != null; i++) {
		        	fileModel.getRightList().add(s+"\n");
		        }

		        fileModel.setRightFile(f);
	        }
	    } catch (IOException ex) {
	        //Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    
		//return fileModel;
	}
	
	public void save(Boolean lr){
		JFileChooser jf = new JFileChooser();
	    int returnval=jf.showSaveDialog(null);
	    File f = null;
	    FileOutputStream fos=null;	    
	    if(returnval == JFileChooser.APPROVE_OPTION)
	    	f=jf.getSelectedFile();
	    
		try{
			//BufferedWriter out = new BufferedWriter(new FileWriter(f));
			fos = new FileOutputStream(f);
			String s=null;
			if(lr==true){
				for(int i=0; i<fileModel.getLeftList().size(); i++){
					s+=fileModel.getLeftList().get(i);
				}
				byte[] buf = s.getBytes();
				fos.write(buf);				
			}
			else{
				for(int i=0; i<fileModel.getRightList().size(); i++){
					s+=fileModel.getRightList().get(i);
				}
				byte[] buf = s.getBytes();
				fos.write(buf);
			}

		} catch(IOException e){
			
		}
		/**
		 * TODO:�����, �ٸ� �̸����� ����, �׳� ����
		 */
	}
	
	public FileModel getFileModel(){return fileModel;}
	public File getFile(){return fileModel.getLeftFile();}
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
