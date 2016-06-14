package com.zzxy.NetDict.Dao;

import java.util.List;
import java.util.Map;

import com.zzxy.NetDict.Entity.NDFile;
import com.zzxy.NetDict.Entity.User;

public interface FileManageDao {
    
    /**
     * 检查文件特征码
     * @param 文件特征码
     * @return int 符合记录的条数
     */
    public int fileFeatureCheck(String featureStr);
    
    /**
     * 根据文件夹id获取小分类下的所有文件
     * @param id
     * @return 文件列表，若无元素，列表为空
     */
    public List<NDFile> getFileListById(String folderId);
    
    /**
     * 根据文件id查询所有文件信息
     * @param fileId
     * @return
     */
    public NDFile getFileById(String fileId);
    
    /**
     * 获取所有未进行索引的文件
     * @return
     */
    public List<NDFile> getNotIndexedFiles();
    
    
    /**
     * 对某个表的某一个字段进行update
     * @param tableName 表名
     * @param columnName 列名
     * @param columnValue 更新的值
     */
    public void updateAColumn(String tableName,String columnName,Object columnValue);
    
    /**
     * 保存一条file记录
     * @param file
     * @return 操作结果，正数成功，0 失败,-1:UNIQUE键的值重复
     */
    public int saveFile(NDFile file);
    
    /**
     * 保存一条file_user记录
     * @param file
     * @return 操作结果，正数成功，0 失败,-1:UNIQUE键的值重复
     */
    public int saveFile_User(NDFile file);
    
    /**
     * 文件阅读量+1
     * @param id
     * @return 操作结果，正数成功，0 失败,-1:UNIQUE键的值重复
     */
    public int updateFileClicks(String id);
    
    /**
     * 获取用户上传的文件列表
     * @param user当前登录的用户
     * @return List<NDFile>
     */
    public List<NDFile> getUserUploadedFileList(User user);
    
    /**
     * 用户收藏
     * @param fId
     * @return 操作结果，正数成功，0 失败,-1:UNIQUE键的值重复
     */ 
    public int userCollection(String fId,User user);
    
    /**
     * 用户取消收藏
     * @param fId
     * @return 操作结果，正数成功，0 失败,-1:UNIQUE键的值重复
     */ 
    public int userDelCollection(String fId,User user);
    
    /**
     * 获取用户收藏列表
     * @param user
     * @return
     */
    public List<NDFile> getUserCollection(User user);
    
    
}
