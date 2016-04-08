package com.zzxy.NetDict.API;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxy.NetDict.Service.AccountManage;
import com.zzxy.NetDict.Tools.JsonData;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    super.service(req, resp);
	    
	    AccountManage am = new AccountManage();
	    
	    int rt = am.userRegist(req);
	    
	    if(rt == 0)
	    {
	        JsonData.SendJson(resp, "regist fail");
	    }
	    else if(rt == -1)
	    {
	        JsonData.SendJson(resp, "用户名已存在");
	    }
	    else
	    {
	        JsonData.SendJson(resp, "regist success");
	    }
	    
	    
	    
	}

}
