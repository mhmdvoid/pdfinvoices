package com.mhmdvoid.pdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mhmdvoid.pdfinvoices.service.InvoiceService;

public class AppContext {

    public static final UserService userService = new UserService();
    public static final InvoiceService invoiceService = new InvoiceService(userService);
    public static final ObjectMapper objectMapper = new ObjectMapper();


}
