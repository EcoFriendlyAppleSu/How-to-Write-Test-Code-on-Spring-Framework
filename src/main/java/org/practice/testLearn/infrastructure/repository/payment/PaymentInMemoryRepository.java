package org.practice.testLearn.infrastructure.repository.payment;

import java.util.HashMap;
import java.util.Map;
import org.practice.testLearn.domain.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class PaymentInMemoryRepository{

    private Map<Long, Payment> persistence = new HashMap<>();
    private Long sequence = 0L;

    public void save(Payment payment) {
        payment.assignId(++sequence);
        persistence.put(payment.getId(), payment);
    }

}
