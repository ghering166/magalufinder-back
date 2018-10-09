

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


@RestController
@CrossOrigin(origins="*")
public class StoreCtrl implements Serializable{
	
	private static final long serialVersionUID = -8870699623137598742L;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ProductService productService;
	

	@PostMapping(value = "/api/store/save", 
			consumes = "application/json", produces = "application/json")
	public ResponseData newStore(@RequestBody Store store)
			throws Exception {
		this.storeService.save(store);
		return new ResponseData("Sua loja foi cadastrada com com sucesso!");
	}

	@GetMapping(value = "api/store/getAll", produces = "application/json")
	public ResponseData getAllStores() {
		return new ResponseData(this.storeService.findAll());
	}

	@GetMapping(value = "api/store/getById/{id}", produces = "application/json")
	public ResponseData getStoreById(@PathVariable("id") Long id) {
		return new ResponseData(this.storeService.findOne(id));
	}
	
	@GetMapping(value = "api/store/search/{product}/{address}", produces = "application/json")
	public ResponseData getStoreSearchProductAddress(@PathVariable("product") String product, @PathVariable("address") String address) throws ApiException, InterruptedException, IOException {
		List<Product> products = this.productService.findByCodeByDescription(product);
		List<ProductStoreTO> productStores = this.productService.prepareListStores(products, address);
		return new ResponseData(productStores);
	}

}
