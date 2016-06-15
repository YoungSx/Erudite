package com.zzxy.NetDict.Service;

import com.zzxy.NetDict.Config.ConfigParams;
import com.zzxy.NetDict.DB.DBBase;

public class FileConvertService {
	public static DBBase db = new DBBase();
	/**
	 * 进行文档的转换操作
	 * @param filePath 完整路径如：c:/file/aa.txt
	 */
	public static void fileConvert(String filePath)
	{
		
			int fileType = FileManageService.getFileType(filePath);
			
			//判断文件类型
			if(fileType == 0)
			{
				//txt
				//复制文件到目标文件夹
				FileManageService.nioTransferCopy(filePath, ConfigParams.TXTFILE_PATH+FileManageService.getFileFullName(filePath));
				String sql = "UPDATE files SET txt_path = ? WHERE f_id = ?";
				String txtpath = ConfigParams.TXTFILE_PATH+FileManageService.getFileFullName(filePath);
				String id = FileManageService.getFileName(filePath);
				db.saveOrUpdate(sql, txtpath,id);
				
//				FileManageService.fileConvert2previewFile(filePath, ConfigParams.HTMLFILE_PATH+FileManageService.getFileName(filePath)+".html");
//				String sql1 = "UPDATE files SET html_path = ? WHERE f_id = ?";
//				String htmlpath = ConfigParams.HTMLFILE_PATH+FileManageService.getFileName(filePath)+".html";
//				String id1 = FileManageService.getFileName(filePath);
//				db.saveOrUpdate(sql1, htmlpath,id1);
				
				
			}else if(fileType == 1)
			{
				//文档
				FileManageService.fileConvert2indexTxt(filePath,ConfigParams.TXTFILE_PATH+FileManageService.getFileName(filePath)+".txt");
				String sql = "UPDATE files SET txt_path = ? WHERE f_id = ?";
				String txtpath = ConfigParams.TXTFILE_PATH+FileManageService.getFileName(filePath)+".txt";
				String id = FileManageService.getFileName(filePath);
				db.saveOrUpdate(sql, txtpath,id);
				
				FileManageService.fileConvert2previewFile(filePath,ConfigParams.HTMLFILE_PATH+FileManageService.getFileName(filePath)+".html");
				String sql1 = "UPDATE files SET html_path = ? WHERE f_id = ?";
				//ysx
				//String htmlpath = ConfigParams.HTMLFILE_PATH+FileManageService.getFileName(filePath)+".html";
				String htmlpath = "/Erudite/htmls/"+FileManageService.getFileName(filePath)+".html";
				String id1 = FileManageService.getFileName(filePath);
				db.saveOrUpdate(sql1, htmlpath,id1);
			}else
			{
				//图片,视频等
				FileManageService.createFile(ConfigParams.NOTDOC2TXT_PATH+FileManageService.getFileName(filePath)+".txt", FileManageService.getFileFullName(filePath));
				String sql = "UPDATE files SET txt_path = ? WHERE f_id = ?";
				String txtpath = ConfigParams.NOTDOC2TXT_PATH+FileManageService.getFileName(filePath)+".txt";
				String id = FileManageService.getFileName(filePath);
				db.saveOrUpdate(sql, txtpath,id);
			}
				
	}
	

	
	
	
}
