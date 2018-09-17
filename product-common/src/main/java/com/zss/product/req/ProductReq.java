package com.zss.product.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ProductReq {
	
	@ApiModelProperty(value = "产品ID")
	private Long productId;

	@ApiModelProperty(value = "产品名称")
	private String productName;
}
