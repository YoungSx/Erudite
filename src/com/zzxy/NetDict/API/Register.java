package com.zzxy.NetDict.API;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zzxy.NetDict.Service.AccountManageService;
import com.zzxy.NetDict.Tools.JsonData;
import com.zzxy.NetDict.Tools.SendJsonData;

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
	    
    	
	    
	    Map<String,String> params = FormDataDecode.formDataDecode(req);

	    AccountManageService am = new AccountManageService();
	    
	    int rt = am.userRegist(params);
	    
	    JsonData jd = new JsonData();
	
	    
	    if(rt == 0)
	    {
	    	jd.setData("注册失败！");
	    	jd.setSuc(0);
	    	jd.setErr(0);
	        SendJsonData.SendJson(resp, jd);
	    }
	    else if(rt == -1)
	    {
	    	jd.setData("用户名已存在！！");
	    	jd.setSuc(0);
	    	jd.setErr(-1);
	        SendJsonData.SendJson(resp, jd);
	    }
	    else
	    {
	    	jd.setData("注册成功！");
	    	jd.setSuc(1);
	    	jd.setErr(0);
	        SendJsonData.SendJson(resp, jd);
	    }
	    
	    
	    
	}

}
