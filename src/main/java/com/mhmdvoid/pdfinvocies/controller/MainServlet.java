package com.mhmdvoid.pdfinvoices.controller;


import java.util.List;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mhmdvoid.pdfinvoices.service.InvoiceService;
import com.mhmdvoid.pdfinvoices.model.Invoice;
import com.mhmdvoid.pdfinvoices.context.AppContext;

public class MainServlet extends HttpServlet {

    // Now once the client calls up /invoices we return json to fron end point
    // So You have built the endpoint here.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<body>\n" +
                            "<h1>Hello World</h1>\n" +
                            "<p>This is my very first, embedded Tomcat, HTML Page!</p>\n" +
                            "</body>\n" +
                            "</html>");
        } else if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
            response.setContentType("application/json; charset=UTF-8");
            List<Invoice> invoices = AppContext.invoiceService.findAll();  // (2)
            response.getWriter().print(AppContext.objectMapper.writeValueAsString(invoices));  // (3)
        }
    }

    // This is simply a simulation to be used in API clients like [Postman, IDEA client, ...]
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
            String userId = request.getParameter("user_id");
            Integer amount = Integer.valueOf(request.getParameter("amount"));

            Invoice invoice = AppContext.invoiceService.create(userId, amount);

            response.setContentType("application/json; charset=UTF-8");
            String json = AppContext.objectMapper.writeValueAsString(invoice);
            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
