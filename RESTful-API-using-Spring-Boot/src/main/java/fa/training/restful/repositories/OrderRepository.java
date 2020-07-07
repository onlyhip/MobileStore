package fa.training.restful.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.restful.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
