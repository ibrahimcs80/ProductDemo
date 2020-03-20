package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	ProductRepository  productRepository;
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	public ResponseEntity<String> createProduct(@Valid ProductDto productDto) {
	
			
		Product product = new Product();	
		product.setDescription(productDto.getDescription());
		product.setImageURL(productDto.getImageURL());
		product.setNumberofViews(productDto.getNumberofViews());
		product.setPrice(productDto.getPrice());
		product.setTitle(productDto.getTitle());
		productRepository.save(product);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	    }//case 

	public ResponseEntity<String> updateProduct(@Valid ProductDto productDto)  throws RecordNotFoundException{
		
       Optional <Product> products = productRepository.findById(productDto.getId());	

		if(products.isPresent())
		{
		Product product = products.get();
		 
		productRepository.findById(productDto.getId());
		product.setDescription(productDto.getDescription());
		product.setImageURL(productDto.getImageURL());
		product.setNumberofViews(productDto.getNumberofViews());
		product.setPrice(productDto.getPrice());
		product.setTitle(productDto.getTitle());
		productRepository.save(product);
	
	    }else
	    {
	    	 throw new RecordNotFoundException("No Product Found");
	    }
	    	
		return new ResponseEntity<String>(HttpStatus.OK);

      }

	public ResponseEntity<String> deleteProduct(long id) throws RecordNotFoundException {
		
		 Optional <Product> products = productRepository.findById(new BigDecimal(id));
			if(products.isPresent())
			{
			Product product = products.get();
			productRepository.deleteById(new BigDecimal(id));
			 }else
			 {
				 throw new RecordNotFoundException("No Product Found");
			 }
			return new ResponseEntity<String>(HttpStatus.OK);
		      

         }
	
	
	public List<ProductDto> searchProducts(String title, String description)
	{
		List<Product> lstofProducts = 	 productRepository.search(title,description);
		
		
		List<ProductDto> lstofDto = new ArrayList();
		for(Product product:lstofProducts)
		{
			ProductDto dto = new ProductDto();
			
			dto.setDescription(product.getDescription());
			dto.setId(new BigDecimal(product.getId()));
			dto.setImageURL(product.getImageURL());
			dto.setNumberofViews(product.getNumberofViews());
			dto.setPrice(product.getPrice());
			dto.setTitle(product.getTitle());
			
			lstofDto.add(dto);
		}
		return lstofDto;
	}
	
}
	