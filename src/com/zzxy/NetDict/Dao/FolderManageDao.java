package com.zzxy.NetDict.Dao;

import java.util.List;
import java.util.Map;

import com.zzxy.NetDict.Entity.Folder;

public interface FolderManageDao {

	/**
	 * 获取所有子文件夹
	 * @return
	 */
	public List<Folder> getChildFoldersBySuperId(String superFolderId);
	
	/**
	 * 获取所有初始化文件夹
	 */
	public List<Folder> getBaseFolders();
	
	/**
	 * 在文件夹下创建文件夹
	 * @param baseFolderId
	 * @return 正数成功，0失败，-1 unique键冲突
	 */
	public int creatFolder(Folder folder);
	
	/**
	 * 删除文件夹
	 * @param folder
	 * @return 正数成功，0失败，-1 unique键冲突
	 */
	public int deleteFolder(Folder folder);
	
	/**
	 * 修改文件夹名称
	 * @param folder
	 * @return 正数成功，0失败，-1 unique键冲突
	 */
	public int renameFolder(Folder folder);
	
}
