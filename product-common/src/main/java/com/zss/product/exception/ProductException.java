package com.zss.product.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.alibaba.fastjson.JSONObject;
import com.zss.product.constants.ProductRespEnum;
import com.zss.product.entity.ResponseEntity;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductException extends RuntimeException{

	private static final long serialVersionUID = 5584943755890277011L;

	protected String code;
	protected String msg;
    
    public ProductException(ResponseEntity baseResEntity){
        if(baseResEntity == null){
            this.code = ProductRespEnum.SYSTEM_ERROR.getCode();
            this.msg = ProductRespEnum.SYSTEM_ERROR.getMessage();
        }else{
            this.code = baseResEntity.getCode();
            this.msg = baseResEntity.getMessage();
        }
    }

    public ProductException(ProductRespEnum marketRespEnum){
        if(marketRespEnum == null){
            this.code = ProductRespEnum.SYSTEM_ERROR.getCode();
            this.msg = ProductRespEnum.SYSTEM_ERROR.getMessage();
        }else{
            this.code = marketRespEnum.getCode();
            this.msg = marketRespEnum.getMessage();
        }
    }

    public ProductException(ProductRespEnum marketRespEnum, String msg){
        if(marketRespEnum == null){
            this.code = ProductRespEnum.SYSTEM_ERROR.getCode();
            this.msg = ProductRespEnum.SYSTEM_ERROR.getMessage();
        }else{
            this.code = marketRespEnum.getCode();
            this.msg = marketRespEnum.getMessage() + msg;
        }
    }

    public ProductException(String msg){
        this.code = ProductRespEnum.BUSINESS_ERROR.getCode();
        this.msg = msg;
    }
    
    public ProductException(JSONObject jsonObj){
        if(jsonObj == null){
            this.code = ProductRespEnum.SYSTEM_ERROR.getCode();
            this.msg = ProductRespEnum.SYSTEM_ERROR.getMessage();
        }
    }

}
