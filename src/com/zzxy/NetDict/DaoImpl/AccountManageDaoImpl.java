package com.zzxy.NetDict.DaoImpl;

import java.sql.ResultSet;

import com.zzxy.NetDict.Dao.AccountManageDao;
import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Tools.DBBase;
import com.zzxy.NetDict.Tools.TimeToString;

public class AccountManageDaoImpl implements AccountManageDao {

    DBBase db = new DBBase();
    
    @Override
    public int addUser(User user) {
        
        String sql = "INSERT INTO user_info(account,pass,perm,nick_name,level,"
                + "grade,e_mail,modified,modifier,delete_flag)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        String account = user.getAccount();
        
        String pass = user.getPass();
        
        String nickName = user.getNick_name();
        
        String email = user.getE_mail();
        
        String dateNow = TimeToString.getNowToString();
        
        int rt = db.saveOrUpdate(sql, account,pass,2,nickName,0,0,email,dateNow,account,0);
        
        return rt;
    }

    @Override
    public ResultSet userLogin(User user) {
        
        String sql = "SELECT account,nick_name,perm,level,grade,e_mail FROM user_info "
                + "WHERE account = ? AND pass = ? AND delete_flag = 0";
        
        String account = user.getAccount();
        
        String pass = user.getPass();
        
        ResultSet rs = db.executeQueryRS(sql, new String[]{account,pass});
        
        return rs;
    }
    
}
