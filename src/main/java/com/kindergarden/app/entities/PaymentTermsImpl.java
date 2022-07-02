package com.kindergarden.app.entities;

import com.kindergarden.app.prices.PaymentValues;

public class PaymentTermsImpl extends PaymentTerms {

    @Override
    public void setBasicMealPrice(int basicMealPrice) {
        if (getSpecialPack().isPack()) {
            this.basicMealPrice = PaymentValues.PACK;
        } else {
            this.basicMealPrice = PaymentValues.MEAL;
        }
    }

    @Override
    public void setMealCounter(int mealCounter) {
        if (getSpecialPack().isPack()) {
            this.mealCounter = 1;
        } else {
            this.mealCounter = mealCounter;
        }
    }
}
