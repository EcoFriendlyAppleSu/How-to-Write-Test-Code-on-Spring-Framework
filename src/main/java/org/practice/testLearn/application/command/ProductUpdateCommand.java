package org.practice.testLearn.application.command;

import org.practice.testLearn.domain.DiscountPolicy;

public record ProductUpdateCommand(String name, int price, DiscountPolicy discountPolicy) {
}
