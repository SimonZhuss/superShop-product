package com.zss.product.entity;

import com.zss.product.constants.ProductRespEnum;
import com.zss.product.exception.ProductException;

public class BaseResEntity {
    private String code;
    private String message;

    public BaseResEntity() {
        this.code = ProductRespEnum.SUCCESS.getCode();
        this.message = ProductRespEnum.SUCCESS.getMessage();
    }

    public BaseResEntity(String code, String message) {
        this.code = code;
        this.message = message;
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

    public static BaseResEntity failure() {
        return new BaseResEntity(ProductRespEnum.BUSINESS_ERROR.getCode(), ProductRespEnum.BUSINESS_ERROR.getMessage());
    }
    
    public static BaseResEntity failure(String message) {
        return new BaseResEntity(ProductRespEnum.BUSINESS_ERROR.getCode(), message);
    }
    
    public static BaseResEntity failure(ProductRespEnum message) {
        return new BaseResEntity(message.getCode(), message.getMessage());
    }

    public static BaseResEntity failure(ProductException e) {
        return new BaseResEntity(e.getCode(), e.getMsg());
    }

    public static BaseResEntity success() {
        return new BaseResEntity(ProductRespEnum.SUCCESS.getCode(), ProductRespEnum.SUCCESS.getMessage());
    }

}
