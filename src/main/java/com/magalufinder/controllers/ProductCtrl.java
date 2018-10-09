

package com.magalufinder.controllers;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.magalufinder.business.ProductService;
import com.magalufinder.models.Product;
import com.magalufinder.util.ResponseData;


@RestController
@CrossOrigin(origins="*")
public class ProductCtrl implements Serializable {

	private static final long serialVersionUID = -5754209338270066697L;
	
	@Autowired
	private ProductService productService;

	@PostMapping(value = "/api/product/save", 
			consumes = "application/json", produces = "application/json")
	public ResponseData newProduct(@RequestBody Product product)
			throws Exception {
		this.productService.save(product);
		return new ResponseData("Seu produto foi cadastrado com com sucesso!");
	}

	@GetMapping(value = "api/product/getAll", produces = "application/json")
	public ResponseData getAllProducts() {
		return new ResponseData(this.productService.findAll());
	}

	@GetMapping(value = "api/product/getById/{id}", produces = "application/json")
	public ResponseData getProductById(@PathVariable("id") Long id) {
		return new ResponseData(this.productService.findOne(id));
	}
	
	@GetMapping(value = "api/product/getProductByIdStore/{id}", produces = "application/json")
	public ResponseData getProductByIdStore(@PathVariable("id") Long id) {
		return new ResponseData(this.productService.findByProductByIdStore(id));
	}

}
