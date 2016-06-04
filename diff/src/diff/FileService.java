package diff;

import java.io.*;
import java.nio.file.Files;

import javax.swing.JFileChooser;

public class FileService {
	public FileService(){
	}
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
	
	public void save(Boolean lr,File file,FileModel fileModel){
		JFileChooser jf = new JFileChooser();
	    int returnval=jf.showSaveDialog(null);
	    File f = null;
	    FileOutputStream fos=null;	    
	    if(returnval == JFileChooser.APPROVE_OPTION)
	    	f=jf.getSelectedFile();
	    
		try{
			//BufferedWriter out = new BufferedWriter(new FileWriter(f));
			fos = new FileOutputStream(f);
			
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

		} catch(IOException e){
			
		}
		/**
		 * TODO:덮어쓰기, 다른 이름으로 저장, 그냥 저장
		 */
	}
	/**
	 * 지정한 위치의 파일에 저장합니다
	 * 
	 * @param lr 왼쪽이 false,오른쪽 true
	 * @param file 파일정보.
	 * @param model 좌우 내용물 정보.
	 */
}
