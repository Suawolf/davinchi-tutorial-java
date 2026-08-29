package edu.tutorial.design_patterns.strategy.strategies;

import edu.tutorial.design_patterns.strategy.PaymentInterface;
import edu.tutorial.design_patterns.strategy.PaymentType;

public class VisaPaymentStrategy implements PaymentInterface {

    @Override
    public void paid() {
        System.out.println("Paid with VISA");
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.VISA;
    }
}
