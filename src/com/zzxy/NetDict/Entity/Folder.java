package com.zzxy.NetDict.Entity;

public class Folder {

	private int id;
	private String fd_id;
	private String fd_name;
	private String fd_owner;
	private String fd_super;
	private String modified;
	private String modifier;
	private String deleted;
	private String deleter;
	private String delete_flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFd_id() {
		return fd_id;
	}
	public void setFd_id(String fd_id) {
		this.fd_id = fd_id;
	}
	public String getFd_name() {
		return fd_name;
	}
	public void setFd_name(String fd_name) {
		this.fd_name = fd_name;
	}
	public String getFd_owner() {
		return fd_owner;
	}
	public void setFd_owner(String fd_owner) {
		this.fd_owner = fd_owner;
	}
	public String getFd_super() {
		return fd_super;
	}
	public void setFd_super(String fd_super) {
		this.fd_super = fd_super;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getDeleter() {
		return deleter;
	}
	public void setDeleter(String deleter) {
		this.deleter = deleter;
	}
	public String getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
	
}
