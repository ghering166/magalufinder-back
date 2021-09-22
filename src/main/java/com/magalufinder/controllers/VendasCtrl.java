package com.magalufinder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import br.com.dev.jr.business.VendasBusiness;
//import br.com.dev.jr.dto.UnidadeFederal;
//import br.com.dev.jr.dto.VendaConjunto;
//import br.com.dev.jr.dto.VendaDTO;
//import br.com.dev.jr.dto.Vendedor;

import com.magalufinder.business.VendasBusiness;
import com.magalufinder.models.VendaModel;

@RestController
@CrossOrigin(origins="*")
public class VendasCtrl {

	@Autowired
	private VendasBusiness vendasBusiness;
	
	/*
	 * 
	 * - Implementar Crud de vendas com banco de dados;
		- Criar com base nas classes anteriores (vendas);
		- Criar métodos para listar todos, listar por id;
		- Criar método de salvar e excluir;
	    - Listar pelo nome do vendedor;("Esse método não foi implementado?")
	 */
	
	@PostMapping("/adicionarVenda")
	public void adicionarEndereco(@RequestBody VendaModel venda) throws Exception {
		this.vendasBusiness.adicionarVenda(venda);
	}

	/**
		- Uma outra forma que pode retornar o status -> https://www.amitph.com/spring-return-specific-http-status/
	*/
	@DeleteMapping("/removerVenda/{id}")
	public ResponseEntity<Void> removeVenda(@PathVariable(name = "id") int id) throws Exception {
		Integer val = Integer.valueOf(id);
		this.vendasBusiness.removerVenda(val);
		return new ResponseEntity<> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/listaVendas/id")
	public ResponseEntity<List<VendaModel>> listarVendaPorId() throws Exception{
		return ResponseEntity.ok(this.vendasBusiness.listarVendasPorId());
	}
	
	/*
	 * 
	 * - Como irá filtrar as vendas do vendedor, parece que ficou faltando o parametro vendedor?
	 */
	@GetMapping("/listaVendas/vendedor")
	public ResponseEntity<List<VendaModel>> listarVendaPorVendedor() throws Exception{
		return ResponseEntity.ok(this.vendasBusiness.listarVendasPorVendedor());
	}
	
}
