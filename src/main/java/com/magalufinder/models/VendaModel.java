package com.magalufinder.models;

//import java.io.Serializable;
import java.math.BigDecimal;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "tab_vendas")
public class VendaModel implements Serializable{
	
	private static final long serialVersionUID = 8415655390642295011L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "vendedor")
	private String vendedor;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@Column(name = "mes")
	private String mes;
	
	@Column(name = "uf")
	private String uf;
	
	public VendaModel() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public String getMes() {
		return this.mes;
	}
	
	
}