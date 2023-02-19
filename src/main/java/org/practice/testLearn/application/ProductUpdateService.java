package org.practice.testLearn.application;

import lombok.RequiredArgsConstructor;
import org.practice.testLearn.application.command.ProductUpdateCommand;
import org.practice.testLearn.application.result.UpdateProductResult;
import org.practice.testLearn.domain.Product;
import org.practice.testLearn.domain.ProductPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductUpdateService {

    private final ProductPort productPort;

    /*
     * 변경 감지를 통한 update 처리, 영속성 상태
     * */
    @Transactional
    public UpdateProductResult update(ProductUpdateCommand command, Long productId) {
        var product = productPort.getProduct(productId);
        product.update(command.name(), command.price(), command.discountPolicy());
        productPort.save(product);

        return new UpdateProductResult(product.getId(), product.getName(),
            product.getPrice(), product.getDiscountPolicy());

    }
}
