package org.practice.testLearn.infrastructure.repository.order;

import org.practice.testLearn.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {

}
