package com.zzxy.NetDict.Dao;

import java.sql.ResultSet;

import com.zzxy.NetDict.DB.DBHelp;
import com.zzxy.NetDict.Entity.User;

public interface AccountManageDao {
    /**
     * @return 正数：新增成功，0：新增失败，-1：用户名冲突
     */
    public int addUser(User user);
    
    /**
     * @return User
     */
    public ResultSet userLogin(User user);
    
    /**
     * 修改密码
     * @param user
     * @return 正数：新增成功，0：新增失败
     */
    public int rePwd(User user);
    
    /**
     * 查看用户权限
     * @param user
     * @return 用户权限 -1：用户错误
     */
    public int checkPerm(User user);
    
    public void closeDb();//ysx
}
