package com.zzxy.NetDict.API;
    import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.DaoImpl.FileManageDaoImpl;
import com.zzxy.NetDict.Entity.NDFile;
import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Service.FileManageService;
import com.zzxy.NetDict.Tools.StringUtils;  
     
    // Servlet 文件上传  
    public class UploadExistFile extends HttpServlet  
    {  
        
        // doPost  
        public void doPost(HttpServletRequest req, HttpServletResponse res)  
            throws IOException, ServletException  
        {  
     
        	
            System.out.println("文件上传："+getClass());
            
            PrintWriter pw = res.getWriter();  
            
            Map<String,Object> fieldMap = new HashMap<>();//form field 参数 + 需要参数
            
            
            //获取session并获取user对象，确定用户是否登录
            HttpSession session = req.getSession();
            User user = (User)session.getAttribute("user");
            if(user == null)
            {
            	//指引用户登录
            	res.getWriter().write("<script>alert('请登录后上传文件！');window.location.href='/Erudite/WebPages/person.jsp';</script>");
            	res.getWriter().flush();
            	return ;
            }
            String userName = user.getAccount();
            
            //获取userAccount并put进fieldMap
            //TODO:
            fieldMap.put("userAccount", userName);
            
            
          //允许跨源请求   
            res.addHeader("Access-Control-Allow-Origin", "*");
//            res.setContentType("text/plain");  
            res.setContentType("text/html");  
//            req.setCharacterEncoding("utf-8");
            
            //文件接收
            try{  
                DiskFileItemFactory diskFactory = new DiskFileItemFactory();  
                // threshold 极限、临界值，即硬盘缓存 1M  
                diskFactory.setSizeThreshold(4 * 1024);  
              
                ServletFileUpload upload = new ServletFileUpload(diskFactory);  
                // 设置允许上传的最大文件大小 
                upload.setSizeMax(10000 * 1024 * 1024);  
                // 解析HTTP请求消息头  
                List fileItems = upload.parseRequest(req);  
                Iterator iter = fileItems.iterator();  
                while(iter.hasNext())  
                {  
                    FileItem item = (FileItem)iter.next();  
                    if(item.isFormField())  
                    {  
                        System.out.println("处理表单内容 ..."); 
                        processFormField(item,fieldMap);
                        
                    }else
                    {  
                        System.out.println("处理上传的文件 ...");  
//                        processUploadFile(item,fieldMap);  

                    }  
                }// end while()  
                wirteDB(fieldMap);
            }catch(Exception e){  
                System.out.println("使用 fileupload 包时发生异常 ...");  
                e.printStackTrace();  
            }// end try ... catch ...  
        }// end doPost()  
     
     
        // 处理表单内容  
        private void processFormField(FileItem item,Map<String,Object> fieldMap)  
            throws Exception  
        {  
            String name = item.getFieldName();  
            String value = item.getString();    
            System.out.println("field === "+ name +"     "+value);
            fieldMap.put(name, value);
        }  
          
        
        
        /**
         * 写数据库
         * @param fieldMap
         * @return
         */
        private static boolean wirteDB(Map<String,Object> fieldMap)
        {
        	FileManageDao fm = new FileManageDaoImpl();
        	String fId = (String)fieldMap.get("fId");
        	NDFile file = fm.getFileById(fId);
        	String modified = StringUtils.getNowToString();
        	String userName = (String)fieldMap.get("userAccount");
        	
        	file.setModified(modified);
        	file.setModifier(userName);
        	file.setOwner(userName);
        	
        	
        	fm.saveFile_User(file);
        	
        	
        	return true;
        }
        
        
        
          
        // doGet  
        public void doGet(HttpServletRequest req, HttpServletResponse res)  
            throws IOException, ServletException  
        {  
            doPost(req, res);  
        }  
    } 