package com.seleniumTDV.app.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.seleniumTDV.app.model.DTOProductMoreSelling;
import com.seleniumTDV.app.model.Product;





@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	/*@Query(value =""
			+ "SELECT new com.entregable5.app.model.DTOProductMoreSelling(p, SUM(od.cantidad) AS int) "
			+ "FROM Product p, OrderDetail od "
			+ "WHERE p.id = od.id.productId "
			+ "GROUP BY od.id.productId "
			+ "ORDER BY COUNT(od.cantidad) DESC ")

			
	public List<DTOProductMoreSelling> getAllMoreSelling();*/
}
