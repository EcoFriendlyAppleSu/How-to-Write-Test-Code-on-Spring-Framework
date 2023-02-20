package org.practice.testLearn.infrastructure.repository.payment;

import org.practice.testLearn.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {

}
