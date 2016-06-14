package com.zzxy.NetDict.API;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzxy.NetDict.Config.ConfigParams;
import com.zzxy.NetDict.Dao.AccountManageDao;
import com.zzxy.NetDict.DaoImpl.AccountManageDaoImpl;
import com.zzxy.NetDict.Entity.User;
import com.zzxy.NetDict.Tools.JsonData;
import com.zzxy.NetDict.Tools.SendJsonData;

/**
 * Servlet implementation class GetConfigs
 */
public class GetConfigs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetConfigs() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doGet(req, resp);
    }
    
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		
		HttpSession session = req.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user == null)
		{
//			提示登录
			resp.getWriter().write("<script>alert('请先登录！');window.location.href='/Erudite/WebPages/person.jsp';</script>");
        	resp.getWriter().flush();
			return;
		}
		
		AccountManageDao am = new AccountManageDaoImpl();
		int rt = am.checkPerm(user);
		if(rt != 0)
		{
			//没有权限
			resp.getWriter().write("<script>alert('您没有权限！');window.location.href='/Erudite/WebPages/index.jsp';</script>");
        	resp.getWriter().flush();
			return;
		}
		
		
		Map<String,Object> configsMap = ConfigParams.getAllConfigParams();
		
		List<String> configParamsList = new ArrayList<>();
		
		Set<String> configsMapSet = configsMap.keySet();
		
		Iterator<String> itr = configsMapSet.iterator();
		
		while(itr.hasNext())
		{
			String key = itr.next();
			String cnKey = ConfigParams.getConfigCNName(key);
			String value = (String)configsMap.get(key);
			String config = cnKey+"("+key+") : "+value;
			configParamsList.add(config);
		}
		
		JsonData jd = new JsonData();
		jd.setData(configParamsList);
		jd.setErr(0);
		jd.setSuc(1);
		SendJsonData.SendJson(resp, jd);
	}

}
