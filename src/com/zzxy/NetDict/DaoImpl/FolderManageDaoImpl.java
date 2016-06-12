package com.zzxy.NetDict.DaoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zzxy.NetDict.DB.DBBase;
import com.zzxy.NetDict.Dao.FolderManageDao;
import com.zzxy.NetDict.Entity.Folder;

public class FolderManageDaoImpl implements FolderManageDao {

	DBBase db = new DBBase();
	
	@Override
	public List<Folder> getChildFoldersBySuperId(String superFolderId) {
		List<Folder> list = new ArrayList<>();
		String searchSql = "SELECT fd_id,fd_name FROM folder WHERE fd_super = ? AND delete_flag = 0";
		ResultSet rs =db.executeQueryRS(searchSql, new String[]{superFolderId});
		try{
			while(rs.next())		
			{
				Folder folder = new Folder();
				String fd_id = rs.getString("fd_id");
				String fd_name = rs.getString("fd_name");
				folder.setFd_id(fd_id);
				folder.setFd_name(fd_name);
				list.add(folder);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Folder> getBaseFolders() {
		
		List<Folder> list = new ArrayList<>();
		String searchSql = "SELECT fd_id,fd_name FROM folders WHERE fd_super = 'base' AND delete_flag = 0";
		ResultSet rs =db.executeQueryRS(searchSql, new String[]{});
		try{
			while(rs.next())		
			{
				Folder folder = new Folder();
				String fd_id = rs.getString("fd_id");
				String fd_name = rs.getString("fd_name");
				folder.setFd_id(fd_id);
				folder.setFd_name(fd_name);
				list.add(folder);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
		}

	
	
	@Override
	public int creatFolder(Folder folder) {
		String sql = "INSERT INTO folders(fd_id,fd_name,fd_owner,fd_super,modified,modifier,delete_flag) "
				+ " VALUES(?,?,?,?,?,?,?)";
		
		return db.saveOrUpdate(sql, folder.getFd_id(),folder.getFd_name(),folder.getFd_owner(),folder.getFd_super(),folder.getModified(),folder.getModifier(),0);
	}

	@Override
	public int deleteFolder(Folder folder) {
		String SQL = "UPDATE folders SET delete_flag = 1 WHERE fd_id = ?";
		
		return db.saveOrUpdate(SQL, folder.getFd_id());
	}

	@Override
	public int renameFolder(Folder folder) {
		String sql = "UPDATE folders SET fd_name = ? WHERE fd_id = ?";
		
		return db.saveOrUpdate(sql, folder.getFd_name(),folder.getFd_id());
	}
	
	

}
