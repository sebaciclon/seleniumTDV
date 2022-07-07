package com.swagger.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swagger.app.model.User;

@Repository
public interface UsertRepository extends JpaRepository<User, Long> {

	
}
