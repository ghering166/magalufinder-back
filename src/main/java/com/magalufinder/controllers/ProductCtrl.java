

package com.magalufinder.controllers;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.magalufinder.business.ProductService;
import com.magalufinder.models.Product;
import com.magalufinder.models.Store;
import com.magalufinder.util.ResponseData;


@RestController
public class ProductCtrl implements Serializable {

	private static final long serialVersionUID = -5754209338270066697L;
	
	@Autowired
	private ProductService bo;

	@PostMapping(value = "/api/product/newProduct", 
			consumes = "application/json", produces = "application/json")
	public ResponseData newProduct(@RequestBody Product product)
			throws Exception {
		return new ResponseData(new Store(), "Sua loja foi cadastrada com com sucesso!");
	}

	@GetMapping(value = "api/product/getAll", produces = "application/json")
	public ResponseData getAllProducts() {
		return new ResponseData(this.bo.findAll());
	}

	@GetMapping(value = "api/product/getById/{id}", produces = "application/json")
	public ResponseData getProductById(@PathVariable("id") Long id) {
		return new ResponseData(this.bo.findOne(id));
	}
	
	@GetMapping(value = "api/product/getProductByIdStore/{id}", produces = "application/json")
	public ResponseData getProductByIdStore(@PathVariable("id") Long id) {
		return new ResponseData(this.bo.findByProductByIdStore(id));
	}

}
