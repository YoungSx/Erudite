package com.zzxy.NetDict.Entity;

import com.zzxy.NetDict.Base.BaseEntity;

public class User extends BaseEntity{

	
	public String account;//账号，nn
	
	private String pass;//密码，nn
	
	public int perm;//权限，1:管理员，2：普通，NN
	
	public String nick_name;//昵称
	
	public int level;//功勋等级，NN，df-0
	
	public int grade;//积分，NN，df-0
	
	public String e_mail;//用户邮箱,NN
	

    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the perm
     */
    public int getPerm() {
        return perm;
    }

    /**
     * @param perm the perm to set
     */
    public void setPerm(int perm) {
        this.perm = perm;
    }

    /**
     * @return the nick_name
     */
    public String getNick_name() {
        return nick_name;
    }

    /**
     * @param nick_name the nick_name to set
     */
    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * @return the e_mail
     */
    public String getE_mail() {
        return e_mail;
    }

    /**
     * @param e_mail the e_mail to set
     */
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    /**
	 * 构造函数(有参)
	 */
	public User(String account,String pass,String nickName,String email)
	{
	    this.account = account;
	    
	    this.pass = pass;
	    
	    this.nick_name = nickName;
	    
	    this.e_mail = email;
	    
	}
	
	/**
	 * 构造函数（无参）
	 */
	public User()
	{
	    
	}
	
}
