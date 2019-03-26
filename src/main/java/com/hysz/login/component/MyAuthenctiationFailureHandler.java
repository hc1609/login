package com.hysz.login.component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;

public class MyAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	private Logger log=LoggerFactory.getLogger(MyAuthenctiationFailureHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		log.info("登录失败");
		JSONObject res = new JSONObject();
		res.put("success", false);
		res.put("msg", "登录失败,请检查账号密码是否正确");
		response.setStatus(500);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().append(res.toString());
	}
}
