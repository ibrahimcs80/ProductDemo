package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.entity.Product;




@Repository
public interface ProductRepository  extends JpaRepository <Product, BigDecimal>{
	
	
	@Query("SELECT p FROM Product p where  p.title  LIKE CONCAT('%',:title,'%') OR  :title IS null AND p.description LIKE CONCAT('%',:description,'%')  OR :description IS null")
	
	List<Product> search( @Param("title")  String title, @Param("description")  String description);
	

}
