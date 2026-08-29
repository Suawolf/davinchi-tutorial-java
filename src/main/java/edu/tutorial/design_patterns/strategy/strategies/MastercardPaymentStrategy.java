package edu.tutorial.design_patterns.strategy.strategies;

import edu.tutorial.design_patterns.strategy.PaymentInterface;
import edu.tutorial.design_patterns.strategy.PaymentType;

public class MastercardPaymentStrategy implements PaymentInterface {

    @Override
    public void paid() {
        System.out.println("Paid with MASTERCARD");
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.MASTERCARD;
    }
}
