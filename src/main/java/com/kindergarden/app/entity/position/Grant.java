//package com.kindergarden.app.entity.position;
//
//import com.kindergarden.app.entity.Invoice;
//
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//import java.time.format.DateTimeFormatter;
//
//@Entity
//@DiscriminatorValue("3")
//public class Grant extends Position {
//
//    public Grant(){}
//
//    public Grant(Invoice invoice){
//        if (invoice.getParent().getPaymentTerms().getGrantFromLublinPack().isGrantFromLublin()) {
//            super.setDescription("Dotacja z Urzędu Miasta Lublin za miesiąc: " + DateTimeFormatter.ofPattern("LLLL").format(invoice.getInvoiceDate().getMonth()) + " " + invoice.getInvoiceDate().getYear());
//            super.setBasicValue(invoice.getParent().getPaymentTerms().getGrantFromLublinPack().getGrantPrice());
//            super.setAmount(1);
//            super.setTotal(super.getAmount() * super.getBasicValue());
//
//            if(getInvoice()==null){
//                super.setInvoice(invoice);
//            }
//        }
//
//    }
//}
