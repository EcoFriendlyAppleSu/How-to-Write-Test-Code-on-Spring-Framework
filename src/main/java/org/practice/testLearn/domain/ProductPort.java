package org.practice.testLearn.domain;

public interface ProductPort {

    void save(Product product);

    Product getProduct(Long productId);
}
