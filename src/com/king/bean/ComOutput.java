package com.king.bean;
/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: 新意科技</p>
 * @author :Jacky-Q
 * @version 1.0
 * @see	created on 2012-9-5 for td
 */
public class ComOutput {
	private int retCode;
	private String retDesc;
	private String retValue;
	private Object retObj;
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	public String getRetDesc() {
		return retDesc;
	}
	public void setRetDesc(String retDesc) {
		this.retDesc = retDesc;
	}
	public String getRetValue() {
		return retValue;
	}
	public void setRetValue(String retValue) {
		this.retValue = retValue;
	}
	public Object getRetObj() {
		return retObj;
	}
	public void setRetObj(Object retObj) {
		this.retObj = retObj;
	}
}

