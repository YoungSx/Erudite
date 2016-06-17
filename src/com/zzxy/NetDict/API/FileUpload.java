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
    public class FileUpload extends HttpServlet  
    {  
        private String filePath;    // 文件存放目录  
        private String tempPath;    // 临时文件目录  
        
     
        // 初始化  
        public void init(ServletConfig config) throws ServletException  
        {  
            super.init(config);  
            // 从配置文件中获得初始化参数  
            String fileP = config.getInitParameter("filepath");  
            String tempP = config.getInitParameter("temppath");  
     
            ServletContext context = getServletContext();  
     
            filePath = context.getRealPath(fileP);  
            tempPath = context.getRealPath(tempP);  
            System.out.println("文件存放目录、临时文件目录准备完毕 ..."+filePath+"- - - -"+tempPath);  
        }  
          
        
        
        
      //request需要提交的表单：   descrp：文件描述 ，fdId:目标文件夹id
        // doPost  
        public void doPost(HttpServletRequest req, HttpServletResponse res)  
            throws IOException, ServletException  
        {  
     
        	
//            System.out.println("文件上传："+getClass());
            
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
            String account = user.getAccount();
            
            //获取userAccount并put进fieldMap
            //TODO:
            fieldMap.put("userAccount", account);
            
            
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
                // repository 贮藏室，即临时文件目录  
                diskFactory.setRepository(new File(tempPath));  
              
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
                    	String value=item.getString();
                        System.out.println("处理上传的文件 ...");  
                        processUploadFile(item,fieldMap);  

                    }  
                }// end while()  
                /**
                 * 文件上传完毕，执行数据库写入
                 */
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
            value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
//            System.out.println("field === "+ name +"     "+value);
            fieldMap.put(name, value);
        }  
          
        
        // 处理上传的文件  
        private void processUploadFile(FileItem item,Map<String,Object> fieldMap)  
            throws Exception  
        {  
            // 此时的文件名包含了完整的路径，得注意加工一下  
            String filename = item.getName();   
            int fileType = FileManageService.getFileType(filename);
            fieldMap.put("mimeType", fileType);
            
            System.out.println("完整的文件名：" + filename); 
            
//            String fId = (String)fieldMap.get("fId");//文件MD5
            String fId = StringUtils.getNowToString();
            fieldMap.put("fId", fId);
            
            //获取文件后缀
            String fileSuffixName = FileManageService.getFileSuffixName(filename);
            
            int index = filename.lastIndexOf("\\");  
            filename = filename.substring(index + 1, filename.length());  
     
            long fileSize = item.getSize(); 
            fieldMap.put("fileSize",fileSize);
            
//            System.out.println("文件大小："+fileSize);
            
            if("".equals(filename) && fileSize == 0)  
            {             
                System.out.println("文件名为空 ...");  
            }  
            fieldMap.put("fName",filename);
//            System.out.println("path="+filePath + "/" + filename);
            String uploadFilePath = filePath + "/" + fId + fileSuffixName;
            File uploadFile = new File(uploadFilePath);  
            
            System.out.println("fileUploadPath = "+uploadFilePath);
            fieldMap.put("filePath", uploadFilePath);
            item.write(uploadFile);
            
            /**
             * 文件上传完毕，执行数据库写入
             */
            //wirteDB(fieldMap);
            
        }  
        
        /**
         * 写数据库
         * @param fieldMap
         * @return
         */
        private static boolean wirteDB(Map<String,Object> fieldMap)
        {
        	
        	NDFile file = new NDFile();
        	String fId = (String)fieldMap.get("fId");
        	String fName = (String)fieldMap.get("fName");
        	int mimeType = (int)fieldMap.get("mimeType");
        	long fileSize = (long)fieldMap.get("fileSize");
        	String filePath = (String)fieldMap.get("filePath");
        	String testArg = (String)fieldMap.get("testArg");
        	String descrp = (String)fieldMap.get("descrp");
        	String fdId = (String)fieldMap.get("fdId");
        	String modified = StringUtils.getNowToString();
        	String userName = (String)fieldMap.get("userAccount");
        	
        	file.setF_id(fId);
        	file.setOwner(userName);
        	file.setF_name(fName);
        	file.setF_type(mimeType);
        	file.setF_size(fileSize);
        	//String realPath = "/Erudite/uploadFile/"+filePath.substring(filePath.lastIndexOf("/")+1);
        	file.setReal_path(filePath);
        	file.setDescrp(descrp);
        	file.setFd_id(fdId);
        	file.setModified(modified);
        	file.setModifier(userName);
        	
        	FileManageDao fm = new FileManageDaoImpl();
        	fm.saveFile(file);
        	fm.saveFile_User(file);
        	
        	System.out.println("fid = "+fId+"\n"+"descrp = "+descrp+"\n"+"fdId = "+fdId+"\n"+"fName = "+fName+"\n"+"userName = "+userName
        			+"\n"+"filesieze = "+fileSize+"\n"+"meimeType = "+mimeType+"\n"+"filePath = "+filePath);
        	
        	
        	return true;
        }
        
        
        
          
        // doGet  
        public void doGet(HttpServletRequest req, HttpServletResponse res)  
            throws IOException, ServletException  
        {  
            doPost(req, res);  
        }  
    } 