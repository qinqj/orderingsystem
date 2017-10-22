package com.qinqj.orderingsys.vo;

import java.sql.Timestamp;

public class User {
	private String username;
	private String pwd;
	private String status;
	private String qq;
	private Timestamp registtime;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * @return the registtime
	 */
	public Timestamp getRegisttime() {
		return registtime;
	}
	/**
	 * @param registtime the registtime to set
	 */
	public void setRegisttime(Timestamp registtime) {
		this.registtime = registtime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", pwd=" + pwd + ", status="
				+ status + ", qq=" + qq + ", registtime=" + registtime + "]";
	}
	public User(String username, String pwd, String status, String qq,
			Timestamp registtime) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.status = status;
		this.qq = qq;
		this.registtime = registtime;
	}
}
