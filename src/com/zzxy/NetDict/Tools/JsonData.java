package com.zzxy.NetDict.Tools;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JsonData {
	private Object data;//数据
	private Integer suc;//成功标志
	private Integer err;//失败标志
	
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getSuc() {
		return suc;
	}
	public void setSuc(Integer suc) {
		this.suc = suc;
	}
	public Integer getErr() {
		return err;
	}
	public void setErr(Integer err) {
		this.err = err;
	}
	
 

    
}
