package com.magalufinder.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import br.com.dev.jr.dao.VendaDAO;
//import br.com.dev.jr.dto.UnidadeFederal;
//import br.com.dev.jr.dto.VendaConjunto;
//import br.com.dev.jr.dto.VendaDTO;
//import br.com.dev.jr.dto.Vendedor;

import com.magalufinder.repository.VendaRepository;
import com.magalufinder.models.VendaModel;


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
	
	/**
		- A validação ficou correta, daria pra criar um método generico pra centralizar todas essas validações, haja visto todas
		estarem testando o == null. 
		- Depois da uma olhada nesse artigo pra conhecer um pouco mais do Spring Validation 
		-> https://www.zup.com.br/blog/spring-validation-o-que-e
	*/
	private void validarCamposObrigatorios(VendaModel venda) throws Exception {
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
	
	/**
		- Chegou a testar se realmente ta inserindo banco?
	*/
	public void adicionarVenda(VendaModel venda) throws Exception {
		this.validarCamposObrigatorios(venda);
		this.repository.save(venda);
	}
	
	public void atualizarVenda(VendaModel venda) throws Exception {
		
		this.validarId(venda.getId());
//		this.validarCamposObrigatorios(venda);
		Optional<VendaModel> temp = this.repository.findById(venda.getId());
		if(temp.isEmpty()) {
			System.out.println("vazio");
		}
		else {
			this.repository.save(venda);
		}
		
	}
	
	public void removerVenda(Integer id) throws Exception {
		this.validarId(id);
		this.repository.deleteById(id);
	}
	
	public List<VendaModel> listarVendasPorId(){
		return repository.retornaListaOrdenadaId();
	}
	
	public List<VendaModel> listarVendasPorVendedor(){
		return repository.retornaListaOrdenadaVendedor();
	}
}
