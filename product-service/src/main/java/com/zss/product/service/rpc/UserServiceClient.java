package com.zss.product.service.rpc;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zss.product.entity.AjaxData;
import com.zss.product.service.rpc.entity.UserInfo;
import com.zss.product.service.rpc.entity.UserReq;


/**
 * @Description:产品服务内部调用FeignClient
 * @auther zhushanshan
 * @since 2017年11月15日下午2:54:10
 */
@FeignClient(value="user-server")
@RequestMapping(value="user", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public interface UserServiceClient {
	
    @RequestMapping(value = "/queryByCondition",method = RequestMethod.POST)
    AjaxData<List<UserInfo>> queryByCondition(@RequestBody UserReq req);
}
