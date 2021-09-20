package com.magalufinder.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import br.com.dev.jr.dao.VendaDAO;
//import br.com.dev.jr.dto.UnidadeFederal;
//import br.com.dev.jr.dto.VendaConjunto;
//import br.com.dev.jr.dto.VendaDTO;
//import br.com.dev.jr.dto.Vendedor;

import com.magalufinder.repository.VendaRepository;
import com.magalufinder.models.Venda;


/*
 * 
 * - Implementar Crud de vendas com banco de dados;
	- Criar com base nas classes anteriores (vendas);
	- Criar métodos para listar todos, listar por id;
	- Criar método de salvar e excluir;
    - Listar pelo nome do vendedor;
 */

@Service
public class VendasBusiness {
	
	@Autowired
	private VendaRepository repository;
	
	private void validarCamposObrigatorios(Venda venda) throws Exception {
		if(venda.getVendedor() == null) {
			throw new Exception("Vendedor não pode ser nulo.");
		}
		if(venda.getValor() == null) {
			throw new Exception("Valor não pode ser nulo.");
		}
		if(venda.getUf() == null) {
			throw new Exception("UF não pode ser nulo.");
		}
		if(venda.getMes() == null) {
			throw new Exception("Mes não pode ser nulo.");
		}
	}
	
	private void validarId(Integer id) throws Exception {
		if(id == null) {
			throw new Exception("ID não pode ser nulo");
		}
	}
	
	public void adicionarVenda(Venda venda) throws Exception {
		this.validarCamposObrigatorios(venda);
		this.repository.save(venda);
	}
	
	public void removerVenda(Integer id) throws Exception {
		this.validarId(id);
		this.repository.deleteById(id);
	}
	
	public List<Venda> listarVendasPorId(){
		return repository.retornaListaOrdenadaId();
	}
	
	public List<Venda> listarVendasPorVendedor(){
		return repository.retornaListaOrdenadaVendedor();
	}
}
