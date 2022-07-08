package com.swagger.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.swagger.app.model.User;
import com.swagger.app.repository.UserRepository;

@Service
public class UserServiceImpl implements BaseService<User> {

	@Autowired
	private UserRepository pr;

	@Override
	@Transactional(readOnly = true)		// en una transaccion de solo lectura, no va a cambiar nada en la db
	public List<User> findAll() {
		return pr.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return pr.findById(id);
	}

	@Override
	@Transactional		// guarda la entidad en la db, por ende va a cambiar la db
	public User save(User p) {
		return pr.save(p);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		pr.deleteById((long) id);
		
	}


}
