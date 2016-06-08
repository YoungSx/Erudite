package com.zzxy.NetDict.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zzxy.NetDict.API.FormDataDecode;
import com.zzxy.NetDict.Dao.AccountManageDao;
import com.zzxy.NetDict.DaoImpl.AccountManageDaoImpl;
import com.zzxy.NetDict.Entity.User;

public class AccountManageService {
    
    /**
     * 用户注册
     * @return 正数：注册成功，0：注册失败，-1：用户名冲突
     */
    public int userRegist(Map<String,String> params)
    {
    	
        String account = params.get("account");
        
        String pass = params.get("pass");
        
        String email = params.get("email");
        
        String nickName = params.get("nickName");
        
        User user = new User(account, pass, nickName, email);
        
        AccountManageDao amd = new AccountManageDaoImpl();
        
        return amd.addUser(user);
    }
    
    /**
     * 用户登录
     * @return Object,如果存在用户，返回user，不存在返回NUll
     */
     public User userLogin(HttpServletRequest req)
     {
         AccountManageDao amd = new AccountManageDaoImpl();
         
         Map<String,String> ma = FormDataDecode.formDataDecode(req);
         
         String account = ma.get("account");
         
         String pass =  ma.get("pass");
         
         User user = new User();
         
         user.setAccount(account);
         user.setPass(pass);
         
         ResultSet rs = amd.userLogin(user);
      
         try {
            while(rs.next())
             {
                user = new User();
                
                String userAccount = rs.getString("account");
                 
                String nickName = rs.getString("nick_name");
                 
                int perm = Integer.parseInt(rs.getString("perm"));
                 
                int level = Integer.parseInt(rs.getString("level"));
                 
                int grade = Integer.parseInt(rs.getString("grade"));
                 
                String email = rs.getString("e_mail");
                 
                user.setAccount(userAccount);
                user.setNick_name(nickName);
                user.setPerm(perm);
                user.setLevel(level);
                user.setGrade(grade);
                user.setE_mail(email);
                 
                 return user;
             }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return null;
     }

}
