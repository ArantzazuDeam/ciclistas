package com.arantzazudealbamoreno.segundaevaluacion.service;

import com.arantzazudealbamoreno.segundaevaluacion.entity.User;
import com.arantzazudealbamoreno.segundaevaluacion.model.UserModel;

public interface UserService{
	
	public abstract User guardarUser(UserModel user);
}
