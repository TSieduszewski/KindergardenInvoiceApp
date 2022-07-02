package com.kindergarden.app.entity.position;

import com.kindergarden.app.entity.Invoice;
import com.kindergarden.app.util.PaymentValues;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorValue("1")
public class Tuition extends Position {

    public Tuition(){}

    public Tuition(Invoice invoice) {
        super.setBasicValue(invoice.getParent().getPaymentTerms().getBasicTuitionPrice());
        super.setAmount(1);
        super.setDescription("Czesne za miesiąc: " + DateTimeFormatter.ofPattern("LLLL").format(invoice.getInvoiceDate().getMonth()) + " " + invoice.getInvoiceDate().getYear());
        super.setTotal(super.getAmount()*super.getBasicValue());

        if(getInvoice()==null){
            super.setInvoice(invoice);
        }
    }


}
