package com.zzxy.NetDict.Dao;

import java.sql.ResultSet;

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
    
}
