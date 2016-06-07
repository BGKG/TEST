package diff;


import java.io.File;

import diff.Model.CompareModel;
import diff.Model.FileModel;
import diff.Service.CompareService;
import diff.Service.EditService;
import diff.Service.FileService;
import diff.Service.MergeService;
import diff.View.ColoredJTextPane;
import diff.View.View;
/**
 * 컨트롤러. 뷰와 서비스 사이를 중계해주는 역할.
 * @author 임철우
 *
 */
public class Controller{
    private View view;
    private FileService fileService;
    private CompareService compareService;
    private MergeService mergeService;
    private EditService editService;
    
    public Controller(View v, FileModel fm, FileService fs, CompareService cs, MergeService ms, EditService es){
        this.view = v;   
        this.fileService = fs;
        this.compareService = cs;
        this.mergeService = ms;
        this.editService = es;
    }
    public FileModel load(Boolean lr,File file,FileModel fileModel){
    	return fileService.load(lr,file,fileModel);
    }   
    public void save(Boolean lr,File file,FileModel fileModel){
    	fileService.save(lr, file, fileModel);
    }   
    public CompareModel compare(FileModel fileModel){
    	return compareService.compare(fileModel);
    }  
    public FileModel merge(Boolean lr,FileModel fileModel, CompareModel cm, int a){
    	return mergeService.merge(lr,fileModel,cm,a);
    }
    public FileModel edit(Boolean lr, FileModel fileModel, ColoredJTextPane ta){
    	return editService.edit(lr, fileModel, ta);
    }     
}