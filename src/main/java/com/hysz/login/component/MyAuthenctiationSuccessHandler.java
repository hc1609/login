package com.hysz.login.component;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
 
public class MyAuthenctiationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private Logger log=LoggerFactory.getLogger(MyAuthenctiationSuccessHandler.class);
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        log.info("登录成功");
        JSONObject res = new JSONObject();
        res.put("success",true);
        res.put("msg","登录成功");
        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(res.toString());
    }
}
 
