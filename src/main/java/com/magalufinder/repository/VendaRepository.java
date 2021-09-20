package com.magalufinder.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.magalufinder.models.Venda;

public interface VendaRepository extends CrudRepository<Venda, Integer> {

	@Query(value = "select * from tab_vendas order by vendedor", nativeQuery = true)
	List<Venda> retornaListaOrdenadaVendedor();
	
	@Query(value = "select * from tab_vendas", nativeQuery = true)
	List<Venda> retornaListaOrdenadaId();
}
