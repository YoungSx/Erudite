package com.zzxy.NetDict.DaoImpl;

import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzxy.NetDict.DB.DBBase;
import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.Entity.File;

public class FileManageDaoImpl implements FileManageDao {

	DBBase db = new DBBase();
    
    @Override
    public int fileFeatureCheck(String featureStr) {
        
        String sql = "SELECT f_id FROM files WHERE deleteFlag = 0";
        
        return (int) db.getCount(sql, null);
        
    }

	@Override
	public List getFileListById(String id) {
		
		String searchSQL = "SELECT files.f_id,files.mime_type,files.descrp,"
				+ " files.size,files.transition_path,files.thumb_path"
				+ " FROM files "
				+ " LEFT JOIN file_folder AS ff "
				+ " ON files.f_id = ff.f_id "
				+ " WHERE ff.fd_id = ? "
				+ " AND files.delete_flag = 0 "
				+ " AND ff.delete_flag = 0";
		
		ResultSet rs = db.executeQueryRS(searchSQL, new String[]{id});
		List fileList = new ArrayList<>();
		try {
			while(rs.next())
			{
				File file = new File();
				
//				String f_id = rs.getString("f_id");
//				int type = rs.getInt("mime_type");
//				double size = rs.getDouble("size");
//				String transitionPath = rs.getString("transition_path");
//				String thumbPath = rs.getString("thumb_path");
				
				file.setId(rs.getString("f_id"));
				file.setType(rs.getInt("mime_type"));
				file.setDescrp(rs.getString("descrp"));
				file.setSize(rs.getDouble("size"));
				file.setTransitionPath(rs.getString("transition_path"));
				file.setThumbpath(rs.getString("thumb_path"));
				
				fileList.add(file);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fileList;
	}
	

	
    
}
