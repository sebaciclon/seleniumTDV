package com.seleniumTDV.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.seleniumTDV.app.model.DTOProductMoreSelling;
import com.seleniumTDV.app.model.Product;
import com.seleniumTDV.app.repository.ProductRepository;

@Service
public class ProductServiceImpl {

	@Autowired
	private ProductRepository pr;

	
	@Transactional(readOnly = true)		// en una transaccion de solo lectura, no va a cambiar nada en la db
	public List<Product> findAll() {
		return pr.findAll();
	}

	
	@Transactional(readOnly = true)
	public Optional<Product> findById(Long id) {
		return pr.findById(id);
	}

	
	@Transactional		// guarda la entidad en la db, por ende va a cambiar la db
	public Product save(Product p) {
		return pr.save(p);
	}

	
	@Transactional
	public void deleteById(Long id) {
		pr.deleteById(id);
		
	}

	
	/*public List<DTOProductMoreSelling> getAllMoreSelling() {
		return pr.getAllMoreSelling();
	}

	public DTOProductMoreSelling getMoreSelling() {
		return this.getAllMoreSelling().get(0);
	}*/
}
