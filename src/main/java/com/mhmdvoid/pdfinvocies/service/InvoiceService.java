package com.mhmdvoid.pdfinvoices.service;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

import com.mhmdvoid.pdfinvoices.model.Invoice;
public class InvoiceService {
    List<Invoice> invoices = new CopyOnWriteArrayList<>(); // (1)

    public List<Invoice> findAll() {
        return invoices;
    }
    public Invoice create(String userId, Integer amount) {
        // TODO real pdf creation and storing it on network server
        var invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
		invoices.add(invoice);
		return invoice;


    }

}
