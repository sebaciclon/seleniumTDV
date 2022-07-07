package com.swagger.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swagger.app.model.User;
import com.swagger.app.repository.UsertRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UsertRepository pr;

	
	@Transactional(readOnly = true)		// en una transaccion de solo lectura, no va a cambiar nada en la db
	public List<User> findAll() {
		return pr.findAll();
	}

	
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return pr.findById(id);
	}

	
	@Transactional		// guarda la entidad en la db, por ende va a cambiar la db
	public User save(User p) {
		return pr.save(p);
	}

	
	@Transactional
	public void deleteById(Long id) {
		pr.deleteById(id);
		
	}


}
