package com.zzxy.NetDict.DaoImpl;

import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.Tools.DBBase;

public class FileManageDaoImpl implements FileManageDao {

    
    @Override
    public int fileFeatureCheck(String featureStr) {
        
        String sql = "SELECT f_id FROM files WHERE deleteFlag = 0";
        
        DBBase db = new DBBase();
        
        return (int) db.getCount(sql, null);
        
    }
    
}
