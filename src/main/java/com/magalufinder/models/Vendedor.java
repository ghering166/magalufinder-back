package com.magalufinder.models;

import java.math.BigDecimal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tab_vendedor")
public class Vendedor implements Serializable, Comparable<Vendedor> {
	
	private static final long serialVersionUID = 8415655444442295011L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "valorVendas")
	private BigDecimal valorVendas;
	
	public Vendedor() {
		
	}
	
	public Vendedor(String nome, BigDecimal valor) {
		this.nome = nome;
		this.valorVendas = valor;
	}
	
	@Override
	public int compareTo(Vendedor o) {
		return o.getValorVendas().compareTo(this.getValorVendas());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getValorVendas() {
		return valorVendas;
	}

	public void setValorVendas(BigDecimal valorVendas) {
		this.valorVendas = valorVendas;
	}
	
	public void acrescentaValor(BigDecimal valor) {
		this.valorVendas = this.valorVendas.add(valor);
	}
}
