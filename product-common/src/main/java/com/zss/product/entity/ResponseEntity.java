package com.zss.product.entity;

import com.zss.product.constants.ProductRespEnum;

/**
 * 服务返回实体公共类
 */
@SuppressWarnings("rawtypes")
public class ResponseEntity<T> extends BaseResEntity{

	/**
	 * 数据体
	 */
	private Object data;

	public ResponseEntity(String code, String message) {
		new BaseResEntity(code,message);
	}

	public ResponseEntity(ProductRespEnum marketRespEnum) {
		new BaseResEntity(marketRespEnum.getCode(),marketRespEnum.getMessage());
	}
	
	public  ResponseEntity(ProductRespEnum marketRespEnum, T data) {
		new BaseResEntity(marketRespEnum.getCode(),marketRespEnum.getMessage());
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ResponseEntity failure(String msg) {
		 return new ResponseEntity(ProductRespEnum.BUSINESS_ERROR.getCode(), msg);
	}
	
	public static ResponseEntity failure() {
		return new ResponseEntity(ProductRespEnum.BUSINESS_ERROR.getCode(), ProductRespEnum.BUSINESS_ERROR.getMessage());
	}
	
	public static ResponseEntity failure(ProductRespEnum e) {
		 return new ResponseEntity(e.getCode(), e.getMessage());
	}
	
	public static ResponseEntity success() {
		 return new ResponseEntity(ProductRespEnum.SUCCESS.getCode(), ProductRespEnum.SUCCESS.getMessage());
	}
	
	public static <T> ResponseEntity<T> success(T data) {
	   return new ResponseEntity<T>(ProductRespEnum.SUCCESS, data);
	}
	
	public static boolean isSuccess(ResponseEntity responseEntity){
        return responseEntity != null && ProductRespEnum.SUCCESS.getCode().equals(responseEntity.getCode()) && responseEntity.getData() != null;
    }
}
