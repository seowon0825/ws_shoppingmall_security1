package com.example.shoppingMall.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.shoppingMall.dao.IMemberDao;
import com.example.shoppingMall.dto.Member;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IMemberDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = dao.getUsername(username);
		
		if(member != null) {
			return new CustomUserDetails(member);
		}
		
		return null;
	}
}
