package com.zzxy.NetDict.Service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.DaoImpl.FileManageDaoImpl;

public class FileManage {
    
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
      * 将用户上传的文件转换成txt文件方便索引
      */
     public static void fileConvert2indexTxt()
     {
    	 
     }
     
     /**
      * 将用户上传的文件转换成可以在线预览的文件
      */
     public static void fileConvert2previewFile()
     {
    	 
     }
     
     /**
      * 制作相关文件的缩略图
      */
     public static void createFileThumbPic()
     {
    	 
     }
     
     
}
