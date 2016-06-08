package com.zzxy.NetDict.API;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxy.NetDict.Service.FileManageService;
import com.zzxy.NetDict.Tools.JsonData;
import com.zzxy.NetDict.Tools.SendJsonData;

/**
 * Servlet implementation class FileFeatureCheck
 */
public class FileFeatureCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileFeatureCheck() {
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
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    super.service(req, resp);
	    
	    FileManageService fileManage = new FileManageService();
	    
	    int num = fileManage.fileFeatureCheck(req, resp);
	    
	    JsonData jd = new JsonData();	    
	    jd.setData(num);
	    jd.setSuc(1);
	    jd.setErr(0);
	    
	        
	    SendJsonData.SendJson(resp, jd);
	    
	}
	

}
