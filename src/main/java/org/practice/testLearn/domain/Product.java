package org.practice.testLearn.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private int price;
    private DiscountPolicy discountPolicy;

    private Product(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public static Product register(String name, int price, DiscountPolicy discountPolicy) {
        return new Product(name, price, discountPolicy);
    }


    /*
    * InMemoryRepository에서 사용
    * */
    public void assignId(Long id) {
        this.id = id;
    }

    /*
     * InMemoryRepository에서 사용
     * */
    public Long getId() {
        return id;
    }

    /*
    * JPA는 EntityManager가 EntityContext Container를 관리합니다.
    * 이 때, 관리 대상은 인스턴스된 각자의 객체입니다.
    * */
    public void update(String name, int price, DiscountPolicy discountPolicy) {
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }
}
