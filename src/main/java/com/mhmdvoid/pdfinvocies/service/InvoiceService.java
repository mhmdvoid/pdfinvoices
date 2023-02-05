package com.mhmdvoid.pdfinvoices.service;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

import com.mhmdvoid.pdfinvoices.model.Invoice;
import com.mhmdvoid.pdfinvoices.service.UserService;
public class InvoiceService {
    List<Invoice> invoices = new CopyOnWriteArrayList<>(); // (1)
    UserService userService;
    public InvoiceService(UserService userService) { // Dependency Injection
        this.userService = userService;
    }
    public List<Invoice> findAll() {
        return invoices;
    }
    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException(); // FIXME:
        }

        // TODO real pdf creation and storing it on network server
        var invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
		invoices.add(invoice);
		return invoice;


    }

}
