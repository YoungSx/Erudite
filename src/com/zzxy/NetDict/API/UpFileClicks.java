package com.zzxy.NetDict.API;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzxy.NetDict.Dao.FileManageDao;
import com.zzxy.NetDict.DaoImpl.FileManageDaoImpl;

/**
 * Servlet implementation class UpFileClicks
 */
public class UpFileClicks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpFileClicks() {
        super();
        // TODO Auto-generated constructor stub
    }


    
    //request需要提交的表单内容：fId:文件id
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.service(req, resp);
    	
    	String fId = req.getParameter("fId");
    	
    	FileManageDao fm = new FileManageDaoImpl();
    	
    	fm.updateFileClicks(fId);
    	
    }
}
