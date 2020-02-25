package com.arantzazudealbamoreno.segundaevaluacion.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arantzazudealbamoreno.segundaevaluacion.entity.UserRole;

@Repository("userRoleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Serializable>{
	
}
