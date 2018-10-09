

package com.magalufinder.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.magalufinder.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	
	@Query("select p from Product p where p.code = :product or p.description LIKE '%' || :product || '%'")
	List<Product> findByCodeByDescription(@Param("product") String product);
	
}
