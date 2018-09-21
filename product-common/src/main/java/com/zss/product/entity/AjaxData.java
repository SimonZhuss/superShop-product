package com.zss.product.entity;

import com.zss.product.constants.ProductRespEnum;

public class AjaxData<T>{

	private String code;
	private String message;
	private T data;

	public AjaxData(Boolean success) {
		super();
	}
	
	public AjaxData() {
		super();
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public  AjaxData(ProductRespEnum productRespEnum, T data) {
		this.code = productRespEnum.getCode();
		this.message = productRespEnum.getMessage();
		this.data = data;
	}
	
	public  AjaxData(String code,String msg) {
		this.code = code;
		this.message = msg;
	}
	
	public static <T> AjaxData<T> success(T data) {
		   return new AjaxData<T>(ProductRespEnum.SUCCESS, data);
	}
	
	public static <T> AjaxData<T> fusing(String serverName) {
		   return new AjaxData<T>("-999",serverName + "服务已停止");
	}
}
