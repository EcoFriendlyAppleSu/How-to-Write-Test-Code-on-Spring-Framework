package org.practice.testLearn.infrastructure.repository.product;

import java.util.HashMap;
import java.util.Map;
import org.practice.testLearn.domain.Product;

// @Repository
public class ProductInMemoryRepository {

    private Map<Long, Product> persistence = new HashMap<>();
    private Long sequence = 0L;

    public void save(Product product) {
        product.assignId(++sequence);
        persistence.put(product.getId(), product);
    }
}
