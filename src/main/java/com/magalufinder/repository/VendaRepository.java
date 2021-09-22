package com.magalufinder.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.magalufinder.models.VendaModel;

public interface VendaRepository extends CrudRepository<VendaModel, Integer> {

	/**
	  - Favor reescrever as 2 query abaixo sem utilizar nativeQuery;
	  
	   Feito
	*/
	@Query("select v from VendaModel v order by v.vendedor")
	List<VendaModel> retornaListaOrdenadaVendedor();
	
	@Query("select v from VendaModel v")
	List<VendaModel> retornaListaOrdenadaId();
}
