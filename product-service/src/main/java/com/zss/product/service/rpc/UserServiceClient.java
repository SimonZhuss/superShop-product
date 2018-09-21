package com.zss.product.service.rpc;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zss.product.entity.AjaxData;
import com.zss.product.service.rpc.entity.UserInfo;
import com.zss.product.service.rpc.entity.UserReq;
import com.zss.product.service.rpc.hystric.UserSericeHystric;


/**
 * @Description:产品服务内部调用FeignClient
 * @auther zhushanshan
 * @since 2017年11月15日下午2:54:10
 */
@FeignClient(value="user-server",fallback = UserSericeHystric.class)
public interface UserServiceClient {
	
    @RequestMapping(value = "/user/queryByCondition",method = RequestMethod.POST)
    AjaxData<List<UserInfo>> queryByCondition(@RequestBody UserReq req);
}
