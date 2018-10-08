

package com.magalufinder.controllers;


import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.magalufinder.business.StoreService;
import com.magalufinder.models.Store;
import com.magalufinder.util.ResponseData;


@RestController
@CrossOrigin(origins="*")
public class StoreCtrl implements Serializable{
	
	private static final long serialVersionUID = -8870699623137598742L;
	
	@Autowired
	private StoreService bo;
	

	@PostMapping(value = "/api/store/newStore", 
			consumes = "application/json", produces = "application/json")
	public ResponseData newStore(@RequestBody Store store)
			throws Exception {
		return new ResponseData(new Store(), "Sua loja foi cadastrada com com sucesso!");
	}

	@GetMapping(value = "api/store/getAll", produces = "application/json")
	public ResponseData getAllStores() {
		return new ResponseData(this.bo.findAll());
	}

	@GetMapping(value = "store/getById/{id}", produces = "application/json")
	public ResponseData getStoreById(@PathVariable("id") Long id) {
		return new ResponseData(this.bo.findOne(id));
	}
	
	@GetMapping(value = "store/search/{product}/{address}", produces = "application/json")
	public ResponseData getStoreSearchProductAddress(@PathVariable("product") String product, @PathVariable("address") String address) {
		return new ResponseData(this.bo.findSearchProductAddress(product,address));
	}

}
