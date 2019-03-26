package com.hysz.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hysz.login.mapper.UserRolesMapper;
import com.hysz.login.model.UserRoles;

@Service
public class UserRolesService {
	@Autowired
	private UserRolesMapper userRolesMapper;
	
	public UserRoles getUserRolesByAccount(String account){
		UserRoles userRoles=userRolesMapper.selectByAccount(account);
		return userRoles;
	}
}
