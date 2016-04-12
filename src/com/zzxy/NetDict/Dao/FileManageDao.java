package com.zzxy.NetDict.Dao;

public interface FileManageDao {
    
    /**
     * 检查文件特征码
     * @param 文件特征码
     * @return int 符合记录的条数
     */
    public int fileFeatureCheck(String featureStr);
}
