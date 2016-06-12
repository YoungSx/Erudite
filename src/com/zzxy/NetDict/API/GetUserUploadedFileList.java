package com.zzxy.NetDict.API;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.DaoImpl.FileManageDaoImpl;
import com.zzxy.NetDict.Entity.NDFile;
import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Tools.JsonData;

/**
 * Servlet implementation class GetUserUploadedFileList
 */
public class GetUserUploadedFileList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserUploadedFileList() {
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
		
		HttpSession session = req.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user == null)
		{
			//提示登录
			return ;
		}
		
		
		FileManageDao fm = new FileManageDaoImpl();
		
		List<NDFile> fileList = fm.getUserUploadedFileList(user);
		
		JsonData jd = new JsonData();
		
		jd.setData(fileList);
		jd.setSuc(1);
		jd.setErr(0);
		
		
		
	}
	
	
	

}
