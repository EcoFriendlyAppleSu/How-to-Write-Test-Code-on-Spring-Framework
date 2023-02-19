package org.practice.testLearn.application.command;

public record OrderProductCommand(
    Long productId, int quantity) {

}
