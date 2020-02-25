package com.arantzazudealbamoreno.segundaevaluacion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arantzazudealbamoreno.segundaevaluacion.converter.DozerMapper;
import com.arantzazudealbamoreno.segundaevaluacion.entity.UserRole;
import com.arantzazudealbamoreno.segundaevaluacion.model.UserRoleModel;
import com.arantzazudealbamoreno.segundaevaluacion.repository.UserRoleRepository;
import com.arantzazudealbamoreno.segundaevaluacion.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	@Qualifier("userRoleRepository")
	private UserRoleRepository userRoleRepository;
	
	// DOZER
	@Autowired
	@Qualifier("dozerMapper")
	private DozerMapper dozerMapper;
	
	@Override
	public UserRole guardarUserRole(UserRoleModel userRoleModel) {
		UserRole userRole = dozerMapper.userRoleModelToUserRole(userRoleModel);
		return userRoleRepository.save(userRole);
	}

	
}
