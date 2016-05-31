package com.zzxy.NetDict.Entity;

import java.util.List;

public class TransaTion {

	private String sql; //要执行的sql语句
	private List<Object> params; //sql语句对应的参数
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public List<Object> getParams() {
		return params;
	}
	public void setParams(List<Object> params) {
		this.params = params;
	}
	
	
	
	
	
}
