

package com.magalufinder.util;


import java.io.Serializable;


public class ProductStoreTO implements Serializable, Comparable<Long> {

	private static final long serialVersionUID = 7063413446774490274L;

	public ProductStoreTO() {
	}

	private Long code;
	private String description;
	private String cep;
	private String value;
	private String codeProduct;
	private String distance;
	private Long km;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Long getKm() {
		return km;
	}

	public void setKm(Long km) {
		this.km = km;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((codeProduct == null) ? 0 : codeProduct.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductStoreTO other = (ProductStoreTO) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (codeProduct == null) {
			if (other.codeProduct != null)
				return false;
		} else if (!codeProduct.equals(other.codeProduct))
			return false;
		return true;
	}

	@Override
	public int compareTo(Long distance) {
		if (this.km < distance) {
			return -1;
		}
		if (this.km > distance) {
			return 1;
		}
		return 0;
	}

}
