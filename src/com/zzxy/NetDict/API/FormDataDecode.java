package com.zzxy.NetDict.API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FormDataDecode {

	public static Map<String,String> formDataDecode(HttpServletRequest req)
	{
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    upload.setHeaderEncoding("utf-8");
	    List<FileItem> items;
	    Map<String,String> param = new HashMap<>();
	    try {
			items = upload.parseRequest(req);
			for(FileItem fileItem : items)
			{
				if(fileItem.isFormField())
				{
					param.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return param;
	}
}
	
	

