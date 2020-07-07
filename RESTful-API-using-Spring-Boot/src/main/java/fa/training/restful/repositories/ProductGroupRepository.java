package fa.training.restful.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.restful.entities.ProductGroup;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {
	
}

