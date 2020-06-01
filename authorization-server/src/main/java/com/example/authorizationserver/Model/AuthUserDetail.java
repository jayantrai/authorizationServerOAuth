package com.example.authorizationserver.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




public class AuthUserDetail extends User implements UserDetails {
	
	
	

	public AuthUserDetail(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}
	
	
	

	public AuthUserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> grantedAuthority = new ArrayList<>();
		
		getRoles().forEach(role -> {
			grantedAuthority.add(new SimpleGrantedAuthority(role.getName()));
			role.getPermissions().forEach(permission -> {
				grantedAuthority.add(new SimpleGrantedAuthority(permission.getName()));
			});
		});
		
		return grantedAuthority;
		}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNonExpired();
		}

	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}

}
