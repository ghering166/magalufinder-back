

package com.magalufinder.util;

import java.util.Comparator;


public class ProductStoreComparator implements Comparator<ProductStoreTO> {

	@Override
	public int compare(ProductStoreTO prod1, ProductStoreTO prod2) {
		return prod1.getKm().compareTo(prod2.getKm());
	}

}
