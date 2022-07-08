package com.swagger.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.swagger.app.model.Direction;
import com.swagger.app.repository.DirectionRepository;


@Service
public class DirectionServiceImpl implements BaseService<Direction>{

	@Autowired
	private DirectionRepository dr;

	@Override
	@Transactional(readOnly = true)		// en una transaccion de solo lectura, no va a cambiar nada en la db
	public List<Direction> findAll() {
		return dr.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Direction> findById(Long id) {
		return dr.findById(id);
	}

	@Override
	@Transactional		// guarda la entidad en la db, por ende va a cambiar la db
	public Direction save(Direction d) {
		return dr.save(d);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dr.deleteById(id);
		
	}
}
