package com.bean;

import java.io.Serializable;

public class ServerMsg implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8600311552366027773L;
	private String code;
	private String msg;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "ServerMsg [code=" + code + ", msg=" + msg + "]";
	}
	
}
