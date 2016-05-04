package com.zzxy.NetDict.Tools;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class SendJsonData {
	  /**
	   * @param httpresponse,要打包的数据
	   * @return 
	 * @throws IOException 
	   */
	    public static void SendJson(HttpServletResponse resp,Object obj) throws IOException
	    {
	        resp.setContentType("text/javascript");//设置响应数据类型为json
	        resp.setCharacterEncoding("utf-8");//转码
	        
	        String json = new Gson().toJson(obj);
	        
	        System.out.println("json = "+json);
	        
	        PrintWriter pw = resp.getWriter();
	        pw.print(json);
	        pw.flush();
	        pw.close();
	    }
}
