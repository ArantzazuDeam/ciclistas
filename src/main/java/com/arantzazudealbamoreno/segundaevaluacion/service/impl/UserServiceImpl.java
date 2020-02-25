package com.arantzazudealbamoreno.segundaevaluacion.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arantzazudealbamoreno.segundaevaluacion.converter.DozerMapper;
import com.arantzazudealbamoreno.segundaevaluacion.entity.UserRole;
import com.arantzazudealbamoreno.segundaevaluacion.model.UserModel;
import com.arantzazudealbamoreno.segundaevaluacion.repository.UserRepository;
import com.arantzazudealbamoreno.segundaevaluacion.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	// DOZER
	@Autowired
	@Qualifier("dozerMapper")
	private DozerMapper dozerMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.arantzazudealbamoreno.segundaevaluacion.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());

		return buildUser(user, authorities);
	}
	
	private User buildUser(com.arantzazudealbamoreno.segundaevaluacion.entity.User user, List<GrantedAuthority> authorities) {

		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		for(UserRole userRole: userRoles) {
			auths.add( new SimpleGrantedAuthority( userRole.getRole() ) );
		}
		
		return new ArrayList<GrantedAuthority>(auths);
	}

	
	// Métodos de UserService
	@Override
	public com.arantzazudealbamoreno.segundaevaluacion.entity.User guardarUser(UserModel userModel) {
		com.arantzazudealbamoreno.segundaevaluacion.entity.User user = dozerMapper.UserModelToUser(userModel); 
		return userRepository.save(user);
	}

	
	
	
	
}
