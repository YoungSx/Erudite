package com.zzxy.NetDict.API;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxy.NetDict.Service.FileManage;
import com.zzxy.NetDict.Tools.JsonData;

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
	    
	    FileManage fileManage = new FileManage();
	    
	    int num = fileManage.fileFeatureCheck(req, resp);
	    
	    Map<String, String> map = new HashMap<>();
	    
	    map.put("num", String.valueOf(num));
	        
	    JsonData.SendJson(resp, map);
	    
	}
	

}
