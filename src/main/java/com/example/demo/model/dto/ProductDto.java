/**
 * 
 */
package com.example.demo.model.dto;

import java.math.BigDecimal;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mohamed
 *
 */

@Getter
@Setter
public class ProductDto {

	BigDecimal id;

	
	String title;


	String description;

	
	Double price;

	
	String imageURL;


	long numberofViews;
}
