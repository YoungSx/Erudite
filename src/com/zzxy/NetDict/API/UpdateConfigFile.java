package com.zzxy.NetDict.API;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzxy.NetDict.Config.ConfigParams;
import com.zzxy.NetDict.Dao.AccountManageDao;
import com.zzxy.NetDict.DaoImpl.AccountManageDaoImpl;
import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Tools.JsonData;
import com.zzxy.NetDict.Tools.SendJsonData;

/**
 * Servlet implementation class UpdateConfigFile
 */
public class UpdateConfigFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConfigFile() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    //request需要提交的表单为:cfgName:需要修改的值的名称，cfgValue：对应的值
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	super.service(req, resp);
    	
    	//检查权限
    	HttpSession session = req.getSession();
    	
    	User user = (User)session.getAttribute("user");
    	if(user == null)
    	{
    		//指引用户登录
        	resp.getWriter().write("<script>alert('请先登录！');window.location.href='/Erudite/WebPages/person.jsp';</script>");
        	resp.getWriter().flush();
        	return;
	    	
    	}
    	
    	
    	JsonData jd = new JsonData();
    	
    	AccountManageDao am = new AccountManageDaoImpl();
    	int rt = am.checkPerm(user);
    	if(rt != 0)
    	{
    		jd.setData("您不是管理员！");
    		jd.setErr(1);
    		jd.setSuc(0);
    	}
    	
    	String name = req.getParameter("cfgName");
    	String value = req.getParameter("cfgValue");
    	ConfigParams.setConfigParamByKey(name, value);
    	jd.setData("修改成功!");
    	jd.setErr(0);
    	jd.setSuc(1);
    	
    	SendJsonData.SendJson(resp, jd);
    }

}
