package com.zzxy.NetDict.API;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzxy.NetDict.Dao.AccountManageDao;
import com.zzxy.NetDict.Dao.FolderManageDao;
import com.zzxy.NetDict.DaoImpl.AccountManageDaoImpl;
import com.zzxy.NetDict.DaoImpl.FolderManageDaoImpl;
import com.zzxy.NetDict.Entity.Folder;
import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Tools.StringUtils;

/**
 * Servlet implementation class CreateFolder
 */
public class CreateFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFolder() {
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
		
		AccountManageDao am = new AccountManageDaoImpl();
		if(am.checkPerm(user)!=0)
		{
			return;
		}
		
		Folder folder = new Folder();
		String fdId = StringUtils.getNowToString();
		String fd_name = req.getParameter("fd_name");
		String userName = user.getAccount();
		String fd_super = req.getParameter("fd_super");
		
		folder.setFd_id(fdId);
		folder.setFd_name(fd_name);
		folder.setFd_owner(userName);
		folder.setFd_super(fd_super);
		folder.setModified(fdId);
		folder.setModifier(userName);
		
		FolderManageDao fm = new FolderManageDaoImpl();
		fm.creatFolder(folder);
	}
	
	
	
}
