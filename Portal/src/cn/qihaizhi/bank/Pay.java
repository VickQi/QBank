package cn.qihaizhi.bank;

import com.opensymphony.xwork2.ActionSupport;

public class Pay extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6078710064513066002L;
	private String orderStatus;

	public String execute(){
		orderStatus="1";
		return SUCCESS;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	
	
}
