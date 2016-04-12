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
     
}
