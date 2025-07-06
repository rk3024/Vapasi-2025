package com.tw;

import com.tw.exception.SplitwiseServiceException;
import com.tw.service.SplitwiseExpenseService;
import com.tw.service.SplitwiseInvoicePrintingService;
import com.tw.service.SplitwiseSettleUpService;

import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SplitwiseMain {
    private static final Logger LOGGER = Logger.getLogger(SplitwiseMain.class.getName());
    public static void main(String[] args) {

        try {
            LOGGER.log(Level.INFO, "Splitwise application initiated.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the expenses file path: ");
            String filePath = scanner.nextLine();

            SplitwiseExpenseService splitwiseExpenseService = new SplitwiseExpenseService(filePath);

            SplitwiseSettleUpService splitwiseSettleUpService = new SplitwiseSettleUpService();
            Map<String, Double> settlementMap = splitwiseSettleUpService.settleExpenses(splitwiseExpenseService.loadExpenseDetails());

            SplitwiseInvoicePrintingService splitwiseInvoicePrintingService = new SplitwiseInvoicePrintingService();
            splitwiseInvoicePrintingService.print(settlementMap);

        }  catch (SplitwiseServiceException e) {
            throw new RuntimeException(e);
        }catch(InvalidPathException ipex){
            LOGGER.log(Level.SEVERE, "Invalid File Path" + ipex.getMessage());
        }
        catch (FileNotFoundException fnfe) {
            LOGGER.log(Level.SEVERE, fnfe.getMessage());
            throw new RuntimeException(fnfe);
        } catch (Exception ex) {
           LOGGER.log(Level.SEVERE, "Error encountered" + ex.getCause());
        }
    }
}
