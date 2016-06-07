package diff.Service;

import java.io.*;
import javax.swing.JFileChooser;
import diff.Model.FileModel;

public class FileService {
	public FileService(){
	}
	/**
	 * ������ �ε��մϴ�
	 * 
	 * @param lr ������ true, ������ false
	 * @param file ��������.
	 * @param model �¿� ���빰 ����.
	 */	
	public FileModel load(Boolean lr,File file,FileModel fileModel){
	     
	    try {
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String s;
	        s=null;

	        if(lr==true){
	        	fileModel.resetLeftList();
	        	
		        for (; (s = in.readLine()) != null;) {
		        	fileModel.getLeft().add(s+"\r\n");
		        }
	        }
	        else{
	        	fileModel.resetRightList();
		        for (; (s = in.readLine()) != null;) {
		        	fileModel.getRight().add(s+"\r\n");
		        }

	        }
	        in.close();
	    } catch (IOException ex) {
	        //Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
	    	ex.printStackTrace();
	    }
	    
		return fileModel;
	}
	/**
	 * ������ ��ġ�� ���Ͽ� �����մϴ�
	 * 
	 * @param lr ������ true,������ false
	 * @param file ��������.
	 * @param model �¿� ���빰 ����.
	 */	
	public void save(Boolean lr,File file,FileModel fileModel){
	    FileOutputStream fos=null;	    
		try{
			fos = new FileOutputStream(file);
			
			String s = null;
			
			if(lr==true){
				for(int i=0; i<fileModel.getLeft().size(); i++){
					s+=fileModel.getLeft().get(i).substring(0, fileModel.getLeft().get(i).length());
				}
				s=s.replaceAll("\r", "");
				s=s.substring(4);
				byte[] buf = s.getBytes();
				fos.write(buf);				
			}
			else{
				for(int i=0; i<fileModel.getRight().size(); i++){
					s+=fileModel.getRight().get(i).substring(0, fileModel.getRight().get(i).length());
				}
				s=s.replaceAll("\r", "");
				s=s.substring(4);
				byte[] buf = s.getBytes();
				fos.write(buf);			
			}

		} catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
