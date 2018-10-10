

package com.magalufinder.controllers;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.maps.errors.ApiException;
import com.magalufinder.business.ProductService;
import com.magalufinder.business.StoreService;
import com.magalufinder.models.Product;
import com.magalufinder.models.Store;
import com.magalufinder.util.ProductStoreTO;
import com.magalufinder.util.ResponseData;

/**
 * @author Henrique Santiago 
 * @version 1.0 
 * @since 9 de out de 2018
 */
@RestController
@CrossOrigin(origins="*")
public class StoreCtrl implements Serializable{
	
	private static final long serialVersionUID = -8870699623137598742L;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ProductService productService;
	

	/**
	 * 
	 * Cria uma nova loja
	 * 
	 */
	@PostMapping(value = "/api/store/save", 
			consumes = "application/json", produces = "application/json")
	public ResponseData save(@RequestBody Store store)
			throws Exception {
		this.storeService.save(store);
		return new ResponseData("Sua loja foi cadastrada com com sucesso!");
	}

	/**
	 * 
	 * Recupera todas as lojas
	 *  
	 */
	@GetMapping(value = "/api/stores", produces = "application/json")
	public ResponseData getAllStores() {
		return new ResponseData(this.storeService.findAll());
	}

	/**
	 * 
	 * Recupera uma loja por ID
	 * 
	 */
	@GetMapping(value = "/api/store/{id}", produces = "application/json")
	public ResponseData getStoreById(@PathVariable("id") Long id) {
		return new ResponseData(this.storeService.findOne(id));
	}
	
	/**
	 * 
	 * Recupera as lojas por produto e endereço
	 * 
	 */
	@GetMapping(value = "/api/store/search/{product}/{address}", produces = "application/json")
	public ResponseData getStoreSearchProductAddress(@PathVariable("product") String product, @PathVariable("address") String address) throws ApiException, InterruptedException, IOException {
		List<Product> products = this.productService.findByCodeByDescription(product);
		List<ProductStoreTO> productStores = this.productService.prepareListStores(products, address);
		return new ResponseData(productStores);
	}

}
