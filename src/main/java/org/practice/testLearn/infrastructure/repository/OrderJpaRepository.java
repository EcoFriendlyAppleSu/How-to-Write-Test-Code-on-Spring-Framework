package org.practice.testLearn.infrastructure.repository;

import org.practice.testLearn.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {

}
