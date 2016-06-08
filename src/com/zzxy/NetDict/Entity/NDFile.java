package com.zzxy.NetDict.Entity;

public class NDFile extends BaseEntity{
	private int id;
	private String f_id;
	private String owner;
	private String f_name;
	private int f_type;
	private double f_size;
	private String real_path;
	private String txt_path;
	private String html_path;
	private String thumb_path;
	private String descrp;
	private String fd_id;
	private int indexed;
	private double clicks;
	private String queryContent;
	
	
	public double getClicks() {
		return clicks;
	}
	public void setClicks(double clicks) {
		this.clicks = clicks;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getQueryContent() {
		return queryContent;
	}
	public void setQueryContent(String queryContent) {
		this.queryContent = queryContent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public int getF_type() {
		return f_type;
	}
	public void setF_type(int f_type) {
		this.f_type = f_type;
	}
	public double getF_size() {
		return f_size;
	}
	public void setF_size(double f_size) {
		this.f_size = f_size;
	}
	public String getReal_path() {
		return real_path;
	}
	public void setReal_path(String real_path) {
		this.real_path = real_path;
	}
	public String getTxt_path() {
		return txt_path;
	}
	public void setTxt_path(String txt_path) {
		this.txt_path = txt_path;
	}
	public String getHtml_path() {
		return html_path;
	}
	public void setHtml_path(String html_path) {
		this.html_path = html_path;
	}
	public String getThumb_path() {
		return thumb_path;
	}
	public void setThumb_path(String thumb_path) {
		this.thumb_path = thumb_path;
	}
	public String getDescrp() {
		return descrp;
	}
	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}
	public String getFd_id() {
		return fd_id;
	}
	public void setFd_id(String fd_id) {
		this.fd_id = fd_id;
	}
	public int getIndexed() {
		return indexed;
	}
	public void setIndexed(int indexed) {
		this.indexed = indexed;
	}

	
	
}
