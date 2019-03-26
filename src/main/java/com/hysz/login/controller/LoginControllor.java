package com.hysz.login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.miaodiyun.httpApiDemo.common.IndustrySMS;
import com.miaodiyun.httpApiDemo.common.RequestCode;


@Controller
public class LoginControllor {
	private Logger log=LoggerFactory.getLogger(LoginControllor.class);
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@RequestMapping("/loginPage")
	public String loginPage(){
		log.info("==========================>loginPage");
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(){
		log.info("==========================>logout");
		return "ok";
	}
	/**
	 * 发送短信验证
	 * @param phone
	 * @param session
	 * @return
	 */
	@RequestMapping("/sendIDCode")
	@ResponseBody
	public String sendIDCode(@RequestParam("phone") String phone,HttpSession session){
		BoundHashOperations<String,String,String> ops=redisTemplate.boundHashOps("login");
		String number=Integer.toString((int)(Math.random()*1000000));
		//发送消息
		String result=IndustrySMS.execute(phone, number);
		RequestCode oj=JSON.parseObject(result,new TypeReference<RequestCode>(){});
		System.out.println(oj.getCode());//000000
		String sessionID=session.getId();
		ops.put(sessionID, number);
		log.info("sessionID={},number={}",sessionID,number);
		return "ok";
	}
	
	/**
	 * 发送短信验证
	 * @param phone
	 * @param session
	 * @return
	 */
	@RequestMapping("/checkIDCode")
	@ResponseBody
	public String checkIDCode(@RequestParam("id") String id,HttpSession session){
		BoundHashOperations<String,String,String> ops=redisTemplate.boundHashOps("login");
		String sessionID=session.getId();
		String number=ops.get(sessionID);
		if(id!=null&&id.equals(number)){
			log.info("验证码正确：sessionID={}，number={}",sessionID,number);
			return "ok";
		}else{
			log.info("验证码不正确：sessionID={}，number={}",sessionID,number);
			return "fail";
		}
	}
}
