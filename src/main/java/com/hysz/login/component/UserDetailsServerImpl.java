package com.hysz.login.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hysz.login.model.UserRoles;
import com.hysz.login.service.UserRolesService;

public class UserDetailsServerImpl implements UserDetailsService {
	@Autowired 
	private UserRolesService userRolesService;
	
	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		UserRoles ud=userRolesService.getUserRolesByAccount(account);
		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		List<String> roleList=ud.getRolenames();
		for (String role : roleList) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		System.out.println(account+"  "+ud.getPassword()+"  "+roleList.get(0));
		UserDetails uds=new User(account, ud.getPassword(), authorities);
		return uds;
	}
}
