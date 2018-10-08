

package com.magalufinder.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.magalufinder.models.Store;
import com.magalufinder.util.ProductStoreTO;

public interface StoreRepository extends CrudRepository<Store, Long>{

	
	
	@Query(value = " SELECT * FROM tab_product p\r\n" + 
		 		" INNER JOIN tab_product_stores ps ON ps.id_product = p.id\r\n" + 
		 		" INNER JOIN tab_stores s ON s.id = ps.id_store\r\n" + 
		 		" WHERE ps.id_store = :id", nativeQuery = true)
	List<ProductStoreTO> findSearchProductAddress(@Param("product") String product, @Param("address") String address);

}
