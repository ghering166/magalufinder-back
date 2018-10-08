

package com.magalufinder.business;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magalufinder.models.Store;
import com.magalufinder.repository.StoreRepository;

@Service
public class StoreService implements Serializable  {

	private static final long serialVersionUID = 7554174993791450746L;
	
	@Autowired
	private StoreRepository repository;
	
	public List<Store> findAll(){
		return (List<Store>) repository.findAll();
	}
	
	public Store findOne(Long id) {
		return repository.findOne(id);
	}

	
}
