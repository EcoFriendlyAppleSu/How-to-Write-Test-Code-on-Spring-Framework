package org.practice.testLearn.domain;

public interface PaymentGateway {

    void execute(int price, String cardNumber);

}
