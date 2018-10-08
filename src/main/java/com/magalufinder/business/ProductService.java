

package com.magalufinder.business;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magalufinder.models.Product;
import com.magalufinder.repository.ProductRepository;

@Service
public class ProductService implements Serializable  {

	private static final long serialVersionUID = 1519896719833231497L;
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return (List<Product>) repository.findAll();
	}
	
	public Product findOne(Long id) {
		return repository.findOne(id);
	}
	
	public List<Product> findByProductByIdStore(Long id){
		return repository.findByProductByIdStore(id);
	}

	public List<Product> findByCodeByDescription(String product) {
		return repository.findByCodeByDescription(product);
	}
}
