package com.zzxy.NetDict.Service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.DaoImpl.FileManageDaoImpl;
import com.zzxy.NetDict.Entity.NDFile;

public class FileManageService {
    
    /**
     * 查询文件特征码
     * @param req
     * @param resp
     * @return 与文件相同特征码的文件数量
     */
     public int fileFeatureCheck(HttpServletRequest req,HttpServletResponse resp)
     {
         String fileFeature = req.getParameter("fileFeature");
         
         FileManageDao fileManage = new FileManageDaoImpl();
         
         return fileManage.fileFeatureCheck(fileFeature);     
     }
     
 	/**
 	 * 获取文件夹下所有文件
 	 * @return 文件路径列表
 	 */
     public static List<String> getFileList(String srcPath) {  
     	List<String> filePathList = new ArrayList<>();
         File dir = new File(srcPath);  
         File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组  
         if (files != null) {  
             for (int i = 0; i < files.length; i++) {  
                 if (files[i].isDirectory()) { // 判断是文件还是文件夹  
                     getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径  
                 } else {
                     String strFileName = files[i].getAbsolutePath();  
                     System.out.println("---" + strFileName);  
                     filePathList.add(strFileName);  
                 }
             }  
   
         }  
         return filePathList;  
     } 
     
     
     /**
      * 将用户上传的文件转换成txt文件方便索引
      */
     public static void fileConvert2indexTxt(String sourcePath,String targetPath)
     {
 		File inputFile = new File(sourcePath);
 		File outputFile = new File(targetPath);
 		OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
 		try {
 			connection.connect();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
 		converter.convert(inputFile, outputFile);
// 		connection.disconnect();
 	
     }
     
     /**
      * 将用户上传的文件转换成可以在线预览的文件
      */
     public static void fileConvert2previewFile(String sourcePath,String targetPath)
     {
  		File inputFile = new File(sourcePath);
  		File outputFile = new File(targetPath);
  		OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
  		try {
  			connection.connect();
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
  		converter.convert(inputFile, outputFile);
//  		connection.disconnect();
     }
     
     /**
      * 制作相关文件的缩略图
      */
     public static void createFileThumbPic(String sourPath,String targetPath)
     {
    	 
     }
     
     
     
     
     
     /**
      * 获取文件类型
      * @param filePath 文件路径
      * @return -1无匹配，0：txt，1：文档，2：图片，3：视频 ,4:其他。。。
      */
     public static int getFileType(String filePath)
     {
    	 int fileTypeNum = -1;
    	 String type = filePath.substring(filePath.lastIndexOf(".") + 1);
    	 
    	 String typeLower = type.toLowerCase();
    	 
    	 switch(typeLower)
    	 {
    	 //txt文件
    	 case "txt":
    		 fileTypeNum = 0;
    		 break;
    	
         //文档
    	 case "doc":
    	 case "docx":
    	 case "xls":
    	 case "xlsx":
    		 fileTypeNum = 1;
    		 break;
    		 
    	 //图片
    	 case "jpg":
    	 case "jpeg":
    		 fileTypeNum = 2;
    		 break;
    		 
    	//视频
    	 case "mov":
    	 case "rmvb":
    	 case "rm":
    		 fileTypeNum = 3;
    		 break;
    	 
    	 default :
    		 fileTypeNum = 4;
    	 	break;
    	 }
    			 
    	 return fileTypeNum;
     }
     
     
     /**
      * 返回文件id
      * @param filePath 文件完整路径
      * @return 文件上传时的MD5 或者“”
      */
     public static String getFileName(String filePath)
     {
    	 String filePathStr = filePath;
    	 if(filePath.contains("\\"))
    	 {
    		 filePathStr = filePath.replace("\\", "/");
    	 }
    	 
    	 if(!filePathStr.contains("/")||(!filePathStr.contains(".")))
    	 {
    		 return "";
    	 }
    	 String fileName = filePathStr.substring(filePathStr.lastIndexOf("/") + 1);
    	 String fileId = fileName.substring(0, fileName.lastIndexOf("."));
    	 return fileId;
     }
     
     /**
      * 获取文件名（MD5）+扩展名
      * @param filePath
      * @return
      */
     public static String getFileFullName(String filePath)
     {
    	 String filePathStr = filePath;
    	 if(filePath.contains("\\"))
    	 {
    		 filePathStr = filePath.replace("\\", "/");
    	 }
    	return filePathStr.substring(filePathStr.lastIndexOf("/") + 1);
     }
     
     
     
     
     /**
 	 * 根据文件Id获取文件名称，数据库中保存的文件名
 	 * @param fileId 文件id
 	 * @return 文件名
 	 */
 	public static String getFileNameFromDB(String fileId)
 	{
 		NDFile ndFile = new NDFile();
 		FileManageDao fmd = new FileManageDaoImpl();
 		ndFile = fmd.getFileById(fileId);
 		return ndFile.getF_name();
 	}

 	
 	/**
 	 * 根据文件路径获取文件内容
 	 * @param filePath 文件路径
 	 * @return 文件内容
 	 */
 	public static String getFileContent(String filePath)
 	{
 		 String filePathStr = filePath;
    	 if(filePath.contains("\\"))
    	 {
    		 filePathStr = filePath.replace("\\", "/");
    	 }
    	 
 		String fileContent = "";
 		File file = new File(filePathStr);
         BufferedReader reader = null;
         try {
             
             reader = new BufferedReader(new FileReader(file));
             
             String tempString = null;
             int line = 1;
             // 一次读入一行，直到读入null为文件结束
             while ((tempString = reader.readLine()) != null) {
                 
                 fileContent += tempString;
                 
                 line++;
             }
             reader.close();
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             if (reader != null) {
                 try {
                     reader.close();
                 } catch (IOException e1) {
                 }
             }
         }
 		return fileContent;
 	}
     
 	
 	
 	
 	/**
 	 * 文件复制
 	 * @param source 
 	 * @param target
 	 */
    public static void nioTransferCopy(String sourcePath, String targetPath) {  
        FileChannel in = null;  
        FileChannel out = null;  
        FileInputStream inStream = null;  
        FileOutputStream outStream = null;  
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        try {  
            inStream = new FileInputStream(sourceFile);  
            outStream = new FileOutputStream(targetFile);  
            in = inStream.getChannel();  
            out = outStream.getChannel();  
            in.transferTo(0, in.size(), out);  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
        	try{
        	if(inStream != null){
        		inStream.close();
        	}
        	if(in != null){
        		in.close();
        	}
        	if(outStream != null){
        		outStream.close();
        	}
        	if(out != null){
        		out.close();
        	}
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        }  
    }  
 	
    /**
     * 创建文件，并在文件中写入内容
     * @param filePath
     * @param content
     */
 	public static void createFile(String filePath,String content)
 	{
 		 File file = new File(filePath);
 		  if (!file.getParentFile().exists()) {
 		   file.getParentFile().mkdirs();
 		  }
 		  try {
 		   file.createNewFile();
 		  } catch (IOException e) {
 		   e.printStackTrace();
 		  }

 		  try {
 		   FileWriter fw = new FileWriter(file, true);
 		   BufferedWriter bw = new BufferedWriter(fw);
 		   bw.write(content);
 		   bw.flush();
 		   bw.close();
 		   fw.close();
 		  } catch (IOException e) {
 		   e.printStackTrace();
 		  }
 	}
 	
 	
 	/**
 	 * 获取文件扩展名
 	 * @param filePathOrFileName
 	 * @return 如“.txt";
 	 */
 	public static String getFileSuffixName(String filePathOrFileName)
 	{
 		if(!filePathOrFileName.contains("."))
 		{
 			return "";
 		}
 		return filePathOrFileName.substring(filePathOrFileName.lastIndexOf("."));
 	}
 	
}
