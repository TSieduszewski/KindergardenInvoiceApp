//package com.kindergarden.app.entity.position;
//
//import com.kindergarden.app.entity.Invoice;
//import com.kindergarden.app.util.PaymentValues;
//
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//import java.time.format.DateTimeFormatter;
//
//@Entity
//@DiscriminatorValue("2")
//public class MealOrPack extends Position {
//
//    public MealOrPack(){}
//
//    public MealOrPack(Invoice invoice) {
//
//        if (invoice.getParent().getPaymentTerms().getSpecialPack().isPack()) {
//            super.setDescription("Pakiet Zajączek+");
//        } else {
//            super.setDescription("Posiłki za miesiąc: " + DateTimeFormatter.ofPattern("LLLL").format(invoice.getInvoiceDate().getMonth().minus(1)) + " " + invoice.getInvoiceDate().getYear());
//
//        }
//
//        super.setBasicValue(invoice.getParent().getPaymentTerms().getBasicMealPrice());
//        super.setAmount(invoice.getParent().getPaymentTerms().getMealCounter());
//        super.setTotal(super.getAmount() * super.getBasicValue());
//
//
//        if(getInvoice()==null){
//            super.setInvoice(invoice);
//        }
//    }
//
//}
