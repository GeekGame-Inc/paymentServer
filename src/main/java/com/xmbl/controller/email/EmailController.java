package com.xmbl.controller.email;

import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xmbl.base.BaseController;
import com.xmbl.dto.ResponseResult;
import com.xmbl.enumeration.EnumInfrastructureResCode;
import com.xmbl.util.email.EmailUtils;
import com.xmbl.web.api.bean.Route;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Copyright © 2018 noseparte © BeiJing BoLuo Network Technology Co. Ltd.
 * @Author Noseparte
 * @Compile 2018年8月2日 -- 下午4:50:11
 * @Version 1.0
 * @Description
 */
@Slf4j
@Controller
@RequestMapping(value = Route.PATH + Route.Email.PATH)
public class EmailController extends BaseController{

	
	/**
	 * 发送邮件	
	 * 
	 * @param jsonData
	 * @return ResponseResult
	 */
	@ResponseBody
	@RequestMapping(value = Route.Email.SEND,method = RequestMethod.POST)
	public ResponseResult send(@RequestParam(value="jsonData") String jsonData) {
		try {
			log.info("发送邮件controller 开始");
			JSONObject jsonObj = (JSONObject) JSONObject.parse(jsonData);
			Assert.isTrue(jsonObj != null, EnumInfrastructureResCode.PARAMETER_FORMAT_ERROR.code());
			boolean isSucc = EmailUtils.sendMailForSystem(jsonObj);;
			Assert.isTrue(isSucc, EnumInfrastructureResCode.EMAIL_SEND_FAILURE.code());
			log.info("发送邮件controller 结束");
			return successJson(isSucc);
		} catch (Exception e) {
			log.error("发送邮件controller报错了，错误信息为:",e.getMessage());
			return errorJson(e.getMessage());
		}
	}
	
	
	
	
	
}
