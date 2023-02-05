package com.mhmdvoid.pdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mhmdvoid.pdfinvoices.service.InvoiceService;

public class AppContext {

    public static final InvoiceService invoiceService = new InvoiceService();
    public static final ObjectMapper objectMapper = new ObjectMapper();

}
