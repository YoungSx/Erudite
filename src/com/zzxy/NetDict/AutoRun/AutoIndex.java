package com.zzxy.NetDict.AutoRun;

import java.util.List;
import java.util.TimerTask;

import com.zzxy.NetDict.DB.DBBase;
import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.DaoImpl.FileManageDaoImpl;
import com.zzxy.NetDict.Entity.NDFile;
import com.zzxy.NetDict.Service.FileConvertService;
import com.zzxy.NetDict.Service.IndexService;


public class AutoIndex extends TimerTask{
	public static DBBase db = new DBBase();
	private static boolean isRunning = false;
	
	
	@Override
	public void run() {
		if (!isRunning) {
            isRunning = true;      
            if(!SystemMonitor.isCpuANDMemoryBusy())
    		{
            	System.out.println("计划任务进行中。。。。。");
    			createIndex();
    		}
            isRunning = false;
        } else {
            System.out.println("任务尚未执行完");
        }
	}
	
	
	
	
	 //创建索引
    public static void createIndex()
    {
    	FileManageDao fm = new FileManageDaoImpl();
    	List<NDFile> fileList = fm.getNotIndexedFiles();
    	for(NDFile file : fileList)
    	{
    		String realPath = file.getReal_path();
    		String txtPath = file.getTxt_path();
    		if(realPath == null)
    		{
    			continue;
    		}
    		
    		if(txtPath == null || txtPath.equals(""))
    		{
    			//文档转换
    			FileConvertService.fileConvert(realPath);
    			continue;
    		}
    		
    		//创建索引
    		IndexService.createIndex(txtPath);
    		
    	}
    }
    
   
    
	
}
