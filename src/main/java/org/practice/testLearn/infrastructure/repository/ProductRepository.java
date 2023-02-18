package org.practice.testLearn.infrastructure.repository;

import java.util.HashMap;
import java.util.Map;
import org.practice.testLearn.domain.Product;

public class ProductRepository {

    private Map<Long, Product> persistence = new HashMap<>();
    private Long sequence = 0L;

    public void save(Product product) {
        product.assignId(++sequence);
        persistence.put(product.getId(), product);
    }
}
