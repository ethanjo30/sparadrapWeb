package com.sparadrapweb.sapradrapWeb.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sparadrapweb.sapradrapWeb.model.Login;
import com.sparadrapweb.sapradrapWeb.repository.LoginRepo;

@Service
public class CustomService implements UserDetailsService{

    @Autowired
    private LoginRepo LoginRepo;

    @Override
    public UserDetails loadUserByUsername(String nom_Login) throws UsernameNotFoundException {
        Login user = LoginRepo.findByNomlogin(nom_Login);
        
        return new User(user.getNomlogin(), user.getMdplogin(), getGrantedAuthorities(user.getRolelogin()));

    }

    private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
	}
    
}
