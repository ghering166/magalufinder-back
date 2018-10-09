

package com.magalufinder.util;

import java.util.Comparator;

/**
 * Ordena as lojas em ordem crescente
 * 
 * @author Henrique Santiago 
 * @version 1.0
 * @since 9 de out de 2018
 */
public class ProductStoreComparator implements Comparator<ProductStoreTO> {

	@Override
	public int compare(ProductStoreTO prod1, ProductStoreTO prod2) {
		return prod1.getKm().compareTo(prod2.getKm());
	}

}
