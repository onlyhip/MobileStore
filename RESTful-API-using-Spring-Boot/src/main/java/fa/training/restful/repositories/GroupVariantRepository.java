package fa.training.restful.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.restful.entities.GroupVariant;

@Repository
public interface GroupVariantRepository extends JpaRepository<GroupVariant, Long> {

}
