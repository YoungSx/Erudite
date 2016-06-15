package com.zzxy.NetDict.DaoImpl;

import java.sql.ResultSet;

import com.zzxy.NetDict.DB.DBBase;
import com.zzxy.NetDict.DB.DBHelp;
import com.zzxy.NetDict.Dao.AccountManageDao;
import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Tools.StringUtils;

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
        
        String dateNow = StringUtils.getNowToString();
        
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

	@Override
	public int rePwd(User user) {
		String sql = "UPDATE user_info SET pass = ? WHERE account = ? AND delete_flag = 0";
		
		return db.saveOrUpdate(sql, user.getPass(),user.getAccount());
	}

	@Override
	public int checkPerm(User user) {
		int perm = -1;
		String sql = "SELECT perm FROM user_info WHERE account = ? AND pass = ? AND delete_flag = 0";
		String account = user.getAccount();
		String pass = user.getPass();
		ResultSet rs = db.executeQueryRS(sql, new String[]{account,pass});
		try{
			while(rs.next())
			{
				perm = rs.getInt("perm");
			}
			if(db.conn!=null)
				DBHelp.closeConn(db.conn);//ysx
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return perm;
	}

	@Override
	 public void closeDb(){//ysx
   	 if(db.conn!=null)
			DBHelp.closeConn(db.conn);
    }

    
}
