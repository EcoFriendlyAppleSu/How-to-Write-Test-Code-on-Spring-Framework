package org.practice.testLearn.infrastructure.repository.product;

import org.practice.testLearn.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

}
