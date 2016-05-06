package com.zzxy.NetDict.Dao;

import java.util.List;

public interface FileManageDao {
    
    /**
     * 检查文件特征码
     * @param 文件特征码
     * @return int 符合记录的条数
     */
    public int fileFeatureCheck(String featureStr);
    
    /**
     * 根据id获取小分类下的所有文件
     * @param id
     * @return 文件列表，若无元素，列表为空
     */
    public List getFileListById(String id);
}
