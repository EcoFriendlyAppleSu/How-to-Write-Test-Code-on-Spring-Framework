package org.practice.testLearn.application.command;

public record PaymentCommand(
    Long orderId,
    String cardNumber
) {
}
