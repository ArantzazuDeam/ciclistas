package com.arantzazudealbamoreno.segundaevaluacion.converter;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.arantzazudealbamoreno.segundaevaluacion.entity.Equipo;
import com.arantzazudealbamoreno.segundaevaluacion.entity.User;
import com.arantzazudealbamoreno.segundaevaluacion.entity.UserRole;
import com.arantzazudealbamoreno.segundaevaluacion.model.EquipoModel;
import com.arantzazudealbamoreno.segundaevaluacion.model.UserModel;
import com.arantzazudealbamoreno.segundaevaluacion.model.UserRoleModel;

@Configuration
@Component("dozerMapper")
public class DozerMapper {

	// USERS
	// De User a UserModel
	public UserModel UserToUserModel (User user) {
		Mapper mapper = new DozerBeanMapper();
		UserModel userModel  = mapper.map(user, UserModel.class);
		return userModel;
	}
	
	// De UserModel a User
	public User UserModelToUser(UserModel userModel) {
		Mapper mapper = new DozerBeanMapper();
		User user = mapper.map(userModel, User.class);
		return user;
	}
	
	// USER ROLES
	// De UserRole a UserRoleModel
	public UserRoleModel UserRoleToUserRoleModel(UserRole userRole) {
		Mapper mapper = new DozerBeanMapper();
		UserRoleModel userRoleModel  = mapper.map(userRole, UserRoleModel.class);
		return userRoleModel;
	}
	
	// De UserRoleModel a UserRole
	public UserRole userRoleModelToUserRole(UserRoleModel userRoleModel) {
		Mapper mapper = new DozerBeanMapper();
		UserRole userRole = mapper.map(userRoleModel, UserRole.class);
		return userRole;
	}
	
	// EQUIPOS
	// De Equipo a EquipoModel
	public EquipoModel equipoToEquipoModel(Equipo equipo) {
		Mapper mapper = new DozerBeanMapper();
		EquipoModel equipoModel = mapper.map(equipo, EquipoModel.class);
		return equipoModel; 
	}
	
	// De EquipoModel a Equipo
	public Equipo equipoModelToEquipo(EquipoModel equipoModel) {
		Mapper mapper = new DozerBeanMapper();
		Equipo equipo = mapper.map(equipoModel, Equipo.class);
		return equipo;
	}
}
