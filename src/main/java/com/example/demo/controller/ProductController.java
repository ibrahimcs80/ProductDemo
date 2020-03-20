package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(value ="/products" ,produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductController {

	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	

	
	
	@PostMapping("/create")
	public ResponseEntity<String> createProduct(@RequestBody @Valid ProductDto productDto)
{
	return productService.createProduct(productDto);
}
	
	
	@PostMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody @Valid ProductDto productDto) throws RecordNotFoundException
{
	return productService.updateProduct(productDto);
}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteProduct(long id) throws RecordNotFoundException
	{
		return productService.deleteProduct(id);
	}
	
	@GetMapping("/search")
	public List<ProductDto> searchProducts(String title , String description)
	{
		return productService.searchProducts(title,description);
	}
	
}
