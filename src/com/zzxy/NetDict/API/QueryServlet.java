package com.zzxy.NetDict.API;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxy.NetDict.Entity.NDFile;
import com.zzxy.NetDict.Service.CustomSearchService;
import com.zzxy.NetDict.Tools.JsonData;
import com.zzxy.NetDict.Tools.SendJsonData;

/**
 * Servlet implementation class QueryServlet
 */
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
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
	
	
	
	//request需要提交的表单： queryStr:用户查询关键字，qf:查询域（‘1’为name，用户选择搜索文件时用此值；’2‘为content，用户选择搜索文档时使用此值）
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		
		String queryStr = req.getParameter("queryStr");
		int queryField = Integer.parseInt(req.getParameter("qf"));
				
		System.out.println("str = "+queryStr+"   qf = "+queryField);
		List<NDFile> fileList = CustomSearchService.getQuery(queryStr, queryField);
		
		for(NDFile f : fileList)
		{
			System.out.println(f.getF_id());
			System.out.println(f.getQueryContent());
		}
		
		JsonData jd = new JsonData();
		jd.setData(fileList);
		jd.setSuc(1);
		jd.setErr(0);
		
		SendJsonData.SendJson(resp, jd);
	}
	
	
	
	
	

}
