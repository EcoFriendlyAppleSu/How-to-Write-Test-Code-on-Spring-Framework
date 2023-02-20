package org.practice.testLearn.domain;

public interface PaymentGateway {

    void execute(Payment payment);

}
