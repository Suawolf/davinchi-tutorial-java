package edu.tutorial.design_patterns.strategy.strategies;

import edu.tutorial.design_patterns.strategy.PaymentInterface;
import edu.tutorial.design_patterns.strategy.PaymentType;

public class AmexPaymentStrategy implements PaymentInterface {

    @Override
    public void paid() {
        System.out.println("Paid with AMERICAN EXPRESS");
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.AMEX;
    }
}
