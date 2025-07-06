package com.tw.service;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SplitwiseInvoicePrintingService {
    private static final Logger LOGGER = Logger.getLogger(SplitwiseInvoicePrintingService.class.getName());
    public SplitwiseInvoicePrintingService() {
    }

    public void print(Map<String, Double> settlementMap) {
        LOGGER.log(Level.INFO, "Printing Service Initiated.");
        System.out.println("List of transactions -");
        settlementMap.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
