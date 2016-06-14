package com.zzxy.NetDict.API;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Service.AccountManageService;
import com.zzxy.NetDict.Tools.JsonData;
import com.zzxy.NetDict.Tools.SendJsonData;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	//request需要提交的表单：   account:用户名，pass：密码
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    super.service(req, resp);
	    
	   HttpSession session = req.getSession();
	    
	   AccountManageService am = new AccountManageService();
	   
	   
	   
	   User user = am.userLogin(req);
	    
	   if(user != null)
	   {
	       session.setAttribute("user", user);
	       //TODO 登录成功后的页面跳转
	       //resp.sendRedirect(arg0);
	       JsonData jd = new JsonData();
	       
	       jd.setSuc(1);
	       jd.setErr(0);
	       jd.setData(user);
	       
	       SendJsonData.SendJson(resp, jd);
	   }
	   else
	   {
		   JsonData jd = new JsonData();
	       
	       jd.setSuc(0);
	       jd.setErr(0);
	       
	       SendJsonData.SendJson(resp, "登录失败");
	       
	       
	       //TODO 登录失败后的处理
	     //resp.sendRedirect(arg0);
	   }
	    
	}

}
