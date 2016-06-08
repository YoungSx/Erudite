package com.zzxy.NetDict.API;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzxy.NetDict.Dao.AccountManageDao;
import com.zzxy.NetDict.DaoImpl.AccountManageDaoImpl;
import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Tools.JsonData;
import com.zzxy.NetDict.Tools.SendJsonData;

/**
 * Servlet implementation class AdminRePwd
 */
public class AdminRePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRePwd() {
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
		
		
		HttpSession session = req.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user == null)
		{
//			提示登录
			return;
		}
		
		AccountManageDao am = new AccountManageDaoImpl();
		int rt = am.checkPerm(user);
		if(rt != 0)
		{
			//没有权限
			return;
		}
		
		Map<String,String> map = FormDataDecode.formDataDecode(req);
		String account = map.get("account");
		String pwd = map.get("pwd");
		User cUser = new User();
		cUser.setAccount(account);
		cUser.setPass(pwd);
		
		
		int ret = am.rePwd(user);
		
		JsonData jd = new JsonData();
		
		if(ret == 0)
		{
			//失败
			jd.setErr(1);
			jd.setSuc(0);
			
		}else
		{
			//成功
			jd.setErr(0);
			jd.setSuc(1);
		}
		
		SendJsonData.SendJson(resp, jd);
		
	}

}
