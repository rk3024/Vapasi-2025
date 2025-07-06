package com.tw.service;

import com.tw.entity.Expense;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitwiseExpenseService {
    private static final Logger LOGGER = Logger.getLogger(SplitwiseExpenseService.class.getName());
    private static final String COMMA_DELIMITER = ",";

    private final List<Expense> expenses;
    private final String inputFilePath;

    public SplitwiseExpenseService(String inputFilePath) {
        this.expenses = new ArrayList<>();
        this.inputFilePath = inputFilePath;
    }

    public List<Expense> loadExpenseDetails() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(this.inputFilePath));
        Pattern pattern = Pattern.compile("^([aA-zZ]+)\\s+spent\\s+(\\d+)\\s+.*for\\s+([aA-zZ]*)\\sfor\\s+(.*)", Pattern.CASE_INSENSITIVE);
        while (scanner.hasNext()) {
            Matcher matcher = pattern.matcher(scanner.nextLine());
            Expense expense = new Expense();
            while (matcher.find()) {
                expense.setPayer(matcher.group(1));
                expense.setAmount(Double.parseDouble(matcher.group(2)));
                expense.setExpenseName(matcher.group(3));
                expense.setPayees(Arrays.stream(matcher.group(4).split(COMMA_DELIMITER)).map(String::trim).toList());
                LOGGER.log(Level.INFO, "Added expense " + expense + " successfully.");
                expenses.add(expense);
            }
        }
        return expenses;
    }
}