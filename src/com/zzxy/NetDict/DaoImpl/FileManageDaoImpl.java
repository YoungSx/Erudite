package com.zzxy.NetDict.DaoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zzxy.NetDict.DB.DBBase;
import com.zzxy.NetDict.DB.DBHelp;
import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.Entity.NDFile;
import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Tools.StringUtils;

public class FileManageDaoImpl implements FileManageDao {

	DBBase db = new DBBase();
    
	
    @Override
    public int fileFeatureCheck(String featureStr) {
        
        String sql = "SELECT f_id FROM files WHERE f_id = ? AND delete_flag = 0";
        
        return (int) db.getCount(sql, featureStr);
        
    }

	@Override
	public List<NDFile> getFileListById(String folderId) {
		List<NDFile> list = new ArrayList<>();
		String searchSql = "SELECT f_id,f_name,f_type,f_size,real_path,html_path,thumb_path,descrp,clicks "
				+ " FROM files WHERE fd_id = ? AND delete_flag = 0";
		
		ResultSet rs = db.executeQueryRS(searchSql, new String[]{folderId});
		try{
			while(rs.next())
			{
				NDFile file = new NDFile();
				file.setF_id(rs.getString("f_id"));
				file.setF_name(rs.getString("f_name"));
				file.setF_type(rs.getInt("f_type"));
				file.setF_size(rs.getDouble("f_size"));
				file.setReal_path(rs.getString("real_path"));
				file.setHtml_path(rs.getString("html_path"));
				file.setThumb_path(rs.getString("thumb_path"));
				file.setDescrp(rs.getString("descrp"));
				file.setClicks(rs.getDouble("clicks"));
				list.add(file);
			}
			if(db.conn!=null)
				DBHelp.closeConn(db.conn);//ysx
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public NDFile getFileById(String fileId) {
		NDFile file = new NDFile();
		String searchSql = "SELECT f_id,f_name,f_type,f_size,real_path,html_path,thumb_path,descrp,clicks "
				+ " FROM files WHERE f_id = ? AND delete_flag = 0";
		ResultSet rs = db.executeQueryRS(searchSql, new String[]{fileId});
		try{
			while(rs.next())
			{
				file.setF_id(rs.getString("f_id"));
				file.setF_name(rs.getString("f_name"));
				file.setF_type(rs.getInt("f_type"));
				file.setF_size(rs.getDouble("f_size"));
				file.setReal_path(rs.getString("real_path"));
				file.setHtml_path(rs.getString("html_path"));
				file.setThumb_path(rs.getString("thumb_path"));
				file.setDescrp(rs.getString("descrp"));
				file.setClicks(rs.getDouble("clicks"));
			}
			if(db.conn!=null)
				DBHelp.closeConn(db.conn);//ysx
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return file;
	}

	@Override
	public List<NDFile> getNotIndexedFiles() {
		List<NDFile> list = new ArrayList<>();
		String sql = "SELECT f_id,real_path,txt_path,html_path,thumb_path FROM files WHERE indexed = 0 AND delete_flag = 0";
		ResultSet rs = db.executeQueryRS(sql, null);
		try {
			while(rs.next())
			{
				NDFile file = new NDFile();
				file.setF_id(rs.getString("f_id"));
				file.setReal_path(rs.getString("real_path"));
				file.setTxt_path(rs.getString("txt_path"));
				file.setHtml_path(rs.getString("html_path"));
				file.setThumb_path(rs.getString("thumb_path"));
				
				list.add(file);
			}
			if(db.conn!=null)
				DBHelp.closeConn(db.conn);//ysx
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void updateAColumn(String tableName, String columnName, Object columnValue) {
		String sql = "UPDATE "+ tableName +" SET "+columnName+" = ? WHERE delete_flag = 0";
		db.saveOrUpdate(sql, columnValue);
	}

	@Override
	public int saveFile(NDFile file) {
		String sql = "INSERT INTO files(f_id,owner,f_name,f_type,f_size,real_path,descrp,fd_id,modified,modifier) "
				+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
		String fid = file.getF_id();
		String owner = file.getOwner();
		String fname = file.getF_name();
		int ftype = file.getF_type();
		double fsize = file.getF_size();
		String path = file.getReal_path();
		String descrp = file.getDescrp();
		String fdid = file.getFd_id();
		String modified = file.getModified();
		String modifier = file.getModifier();
		
		int rt = db.saveOrUpdate(sql, fid,owner,fname,ftype,fsize,path,descrp,fdid,modified,modifier);
		
		return rt;
	}

	@Override
	public int saveFile_User(NDFile file) {
		String sql = "INSERT INTO file_user(f_id,f_name,user,modified,modifier) VALUES(?,?,?,?,?)";
		String fid = file.getF_id();
		String fname = file.getF_name();
		String user = file.getOwner();
		String modified = file.getModified();
		String modifier = file.getModifier();
		int rt = db.saveOrUpdate(sql, fid,fname,user,modified,modifier);
		return rt;
	}

	@Override
	public int updateFileClicks(String id) {
		String sql = "UPDATE files SET clicks = clicks+1 WHERE f_id = ? AND delete_flag = 0";
		int rt = db.saveOrUpdate(sql, id);
		return rt;
	}

	@Override
	public List<NDFile> getUserUploadedFileList(com.zzxy.NetDict.Entity.User user) {
		
		List<NDFile> list = new ArrayList<>();

		String sql = "SELECT f_id,f_name,f_type,f_size,real_path,html_path,thumb_path,descrp,fd_id,clicks FROM files "
				+ " WHERE owner = ? AND delete_flag = 0";
		
		String account = user.getAccount();
		
		ResultSet rs = db.executeQueryRS(sql, new String[]{account});
		
		try{

			while(rs.next())
			{
				NDFile file = new NDFile();
				file.setF_id(rs.getString("f_id"));
				file.setF_name(rs.getString("f_name"));
				file.setF_type(rs.getInt("f_type"));
				file.setF_size(rs.getDouble("f_size"));
				file.setReal_path(rs.getString("real_path"));
				file.setHtml_path(rs.getString("html_path"));
				file.setThumb_path(rs.getString("thumb_path"));
				file.setDescrp(rs.getString("descrp"));
				file.setFd_id(rs.getString("fd_id"));
				file.setClicks(rs.getDouble("clicks"));
				list.add(file);
			}
			if(db.conn!=null)
				DBHelp.closeConn(db.conn);//ysx
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return list;
	}

	@Override
	public int userCollection(String fId, User user) {

		String sql = "INSERT INTO user_collection(f_id,user,modified,modifier) VALUES(?,?,?,?)";
		String account = user.getAccount();
		String modified = StringUtils.getNowToString();
		
		int rt = db.saveOrUpdate(sql, fId,account,modified,account);
		
		return rt;
	}

	@Override
	public int userDelCollection(String fId, User user) {
		
		String sql = "UPDATE user_collection SET delete_flag = 1 WHERE user = ? AND f_id = ?";
		
		String account = user.getAccount();
		
		int rt = db.saveOrUpdate(sql, account,fId);
		
		return rt;
	}

	@Override
	public List<NDFile> getUserCollection(User user) {
		
		List<NDFile> list = new ArrayList<>();
		
		String account = user.getAccount();
		
		String sql = "SELECT f_id FROM user_collection WHERE user = ? AND delete_flag = 0";
		
		ResultSet rs = db.executeQueryRS(sql, new String[]{account});
		
		try{
			while(rs.next())
			{
				NDFile file = new NDFile();
				file = getFileById(rs.getString("f_id"));
				list.add(file);
			}
			if(db.conn!=null)
				DBHelp.closeConn(db.conn);//ysx
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}




    
}
