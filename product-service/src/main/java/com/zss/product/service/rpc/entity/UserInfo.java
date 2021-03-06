package com.zss.product.service.rpc.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserInfo {
	
	private Long id;
    
	@ApiModelProperty(value = "姓名")
	private String name;
	
	@ApiModelProperty(value = "密码")
	private String pwd;
}