package com.zzxy.NetDict.API;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxy.NetDict.Dao.FolderManageDao;
import com.zzxy.NetDict.DaoImpl.FolderManageDaoImpl;
import com.zzxy.NetDict.Tools.JsonData;
import com.zzxy.NetDict.Tools.SendJsonData;

/**
 * Servlet implementation class GetFoldersById
 */
public class GetFoldersById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFoldersById() {
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
		// TODO Auto-generated method stub
		super.service(req, resp);
		
		String fdId = req.getParameter("fdId");
		
		FolderManageDao fm = new FolderManageDaoImpl();
		
		
		JsonData jd = new JsonData();
		
		jd.setData(fm.getChildFoldersBySuperId(fdId));
		jd.setErr(0);
		jd.setSuc(1);
		
		SendJsonData.SendJson(resp, jd);
		
		
	}

}
