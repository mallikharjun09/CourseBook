package com.classes;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/upload")
public class UploadController {
	@RequestMapping(value="/process",method=RequestMethod.GET)
	public String save(HttpServletRequest request){
		String path=request.getRealPath("\\web\\resources\\images\\");
		path=path.substring(path.lastIndexOf("CourseBook"));
		path=path.substring(path.lastIndexOf("uis"));
		DiskFileItemFactory  d=new DiskFileItemFactory();
		ServletFileUpload uploader=new ServletFileUpload(d);
		try{
			List<FileItem> lst=uploader.parseRequest(request);
			for(FileItem fileItem : lst){
				fileItem.write(new File(path+"/"+fileItem.getName()));
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return path;
		}
		System.out.println(path);
		return path;
	}
	
}
