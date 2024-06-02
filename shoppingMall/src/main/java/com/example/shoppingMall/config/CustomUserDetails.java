package com.example.shoppingMall.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.shoppingMall.dto.Member;

public class CustomUserDetails implements UserDetails {
	
	private Member member;
	
	public CustomUserDetails(Member member) {
		this.member = member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return "ROLE_" + member.getRole();
			}
		});
		
		return collection;
	}

	@Override
	public String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getUsername();
	}
	
	public String getRole() {
		return member.getRole();
	}
	
	public int getMem_no() {
		return member.getMem_no();
	}
	
	public String getMem_name() {
		return member.getMem_name();
	}
	
	public String getMem_tel() {
		return member.getMem_tel();
	}
	
	public String getMem_addr() {
		return member.getMem_addr();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	

}
