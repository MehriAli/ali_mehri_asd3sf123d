
package AnywrTest.security.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import AnywrTest.security.domain.User;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public class MyUserDetails implements UserDetails {


	private static final long serialVersionUID = -2550185165626007488L;

	private User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return authorities;
	}

	@Override
	public String getPassword() { // TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() { // TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override public boolean isAccountNonExpired() { // TODO Auto-generatedmethod stub
		return true;
		}


	@Override public boolean isAccountNonLocked() { // TODO Auto-generated method stub
		return true; }

	@Override public boolean isCredentialsNonExpired() { // TODO Auto-generated method stub
		return true; }

	@Override
	public boolean isEnabled() {
		return true;
	}


}
