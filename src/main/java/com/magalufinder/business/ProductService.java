

package com.magalufinder.business;


import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;
import com.magalufinder.models.Product;
import com.magalufinder.models.Store;
import com.magalufinder.repository.ProductRepository;
import com.magalufinder.util.ProductStoreComparator;
import com.magalufinder.util.ProductStoreTO;


@Service
public class ProductService implements Serializable {

	private static final long serialVersionUID = 1519896719833231497L;

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return (List<Product>) repository.findAll();
	}

	public Product findOne(Long id) {
		return repository.findOne(id);
	}

	public List<Product> findByProductByIdStore(Long id) {
		return repository.findByProductByIdStore(id);
	}

	public List<Product> findByCodeByDescription(String product) {
		return repository.findByCodeByDescription(product);
	}

	public List<ProductStoreTO> prepareListStores(List<Product> products,
			String address) throws ApiException, InterruptedException, IOException {
		Set<ProductStoreTO> setProductStoreTO = new HashSet<>();
		for (Product product : products) {
			for (Store store : product.getStores()) {
				ProductStoreTO productStoreTO = new ProductStoreTO();
				productStoreTO.setCode(store.getCode());
				productStoreTO.setDescription(store.getDescription());
				productStoreTO.setCep(store.getCep());
				productStoreTO.setValue(this.formatarValorMonetario(product.getValue()));
				productStoreTO.setCodeProduct(product.getCode());
				this.getDistanceBetweenTwoPoints(address, store.getCep(), productStoreTO);
				setProductStoreTO.add(productStoreTO);
			}
		}
		return mountListOrdered(setProductStoreTO);
	}

	private List<ProductStoreTO> mountListOrdered(Set<ProductStoreTO> setProductStoreTO) {
		List<ProductStoreTO> productStoreTOs = new ArrayList<ProductStoreTO>(setProductStoreTO);
		Collections.sort(productStoreTOs, new ProductStoreComparator());
		return productStoreTOs;
	}

	private void getDistanceBetweenTwoPoints(String address, String code, ProductStoreTO productStoreTO)
			throws ApiException, InterruptedException, IOException {
		GeoApiContext distCalcer = new GeoApiContext.Builder()
				.apiKey("AIzaSyDHQK4QkkI03DtshOCz7w6lZqCLRSX-OXs").build();

		DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer);
		DistanceMatrix result = req.origins(address).destinations(code)
				.mode(TravelMode.DRIVING).avoid(RouteRestriction.TOLLS)
				.language("en-US").await();

		productStoreTO.setDistance(result.rows[0].elements[0].distance.humanReadable);
		productStoreTO.setKm(result.rows[0].elements[0].distance.inMeters);
	}
	
	private String formatarValorMonetario(final BigDecimal valor) {
		if (valor != null) {
			DecimalFormat nf = new DecimalFormat("#,##0.00");
			return nf.format(valor.doubleValue());
		}
		return "";
	}
}
