

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


/**
 * 
 * @author Henrique Santiago 
 * @version 1.0 
 * @since 9 de out de 2018
 */
@RestController
@CrossOrigin(origins="*")
public class ProductCtrl implements Serializable {

	private static final long serialVersionUID = -5754209338270066697L;
	
	@Autowired
	private ProductService productService;

	/**
	 * 
	 * Cria um novo produto
	 * 
	 */
	@PostMapping(value = "/api/product/save", consumes = "application/json", produces = "application/json")
	public ResponseData save(@RequestBody Product product)
			throws Exception {
		this.productService.save(product);
		return new ResponseData(null, "Seu produto foi cadastrado com sucesso!");
	}

	/**
	 * 
	 * Recupera todos os produtos 
	 * 
	 */
	@GetMapping(value = "/api/products", produces = "application/json")
	public ResponseData getAllProducts() {
		return new ResponseData(this.productService.findAll());
	}

	/**
	 * 
	 * Recupera um produto por ID
	 * 
	 */
	@GetMapping(value = "/api/product/{id}", produces = "application/json")
	public ResponseData getProductById(@PathVariable("id") Long id) {
		return new ResponseData(this.productService.findOne(id));
	}
	
}
