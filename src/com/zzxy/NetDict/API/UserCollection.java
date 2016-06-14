package com.zzxy.NetDict.API;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.DaoImpl.FileManageDaoImpl;
import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Tools.JsonData;
import com.zzxy.NetDict.Tools.SendJsonData;

/**
 * Servlet implementation class UserCollection
 */
public class UserCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCollection() {
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
	
	
	//request需要提交的表单为：fId:文件Id
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user == null)
		{
			//提示登录
			//指引用户登录
        	resp.getWriter().write("<script>alert('请先登录！');window.location.href='/Erudite/WebPages/person.jsp';</script>");
        	resp.getWriter().flush();
			return ;
		}
		
		Map<String, String>  map = FormDataDecode.formDataDecode(req);
		
		String fid = map.get("fId");
		
		FileManageDao fm = new FileManageDaoImpl();
		
		int rt = fm.userCollection(fid, user);
		
		JsonData jd = new JsonData();
		
		if(rt > 0)
		{
			jd.setSuc(1);
			jd.setErr(0);
		}else
		{
			jd.setSuc(0);
			jd.setErr(1);
		}
		
		SendJsonData.SendJson(resp, jd);
		
	}

}
