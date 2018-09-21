package com.zss.product.service.rpc.hystric;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zss.product.entity.AjaxData;
import com.zss.product.service.rpc.UserServiceClient;
import com.zss.product.service.rpc.entity.UserInfo;
import com.zss.product.service.rpc.entity.UserReq;

@Component
public class UserSericeHystric implements UserServiceClient{

	@Override
	public AjaxData<List<UserInfo>> queryByCondition(UserReq req) {
		return AjaxData.fusing("user-server");
	}
}
