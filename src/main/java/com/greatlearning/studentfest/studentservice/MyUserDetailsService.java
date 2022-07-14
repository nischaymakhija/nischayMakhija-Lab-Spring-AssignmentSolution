package com.greatlearning.studentfest.studentservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.studentfest.entity.Role;
import com.greatlearning.studentfest.entity.User;
import com.greatlearning.studentfest.repository.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("username from req "+username);
		User user = repo.getUserByUsername(username);
		List<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		org.springframework.security.core.userdetails.User secureUser = 
				new org.springframework.security.core.userdetails.User(
						user.getUsername(),(user.getPassword()), authorities);
		return secureUser;
	}


}
