package com.tw.service;

import com.tw.entity.Expense;
import com.tw.exception.SplitwiseServiceException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class SplitwiseSettleUpServiceTest {
    public static SplitwiseSettleUpService splitwiseSettleUpService;

    @BeforeAll
    public static void setUp() {
        splitwiseSettleUpService = new SplitwiseSettleUpService();
    }

    @Test
    void shouldNotDisplaySelf(){
        List<Expense> expenses = new ArrayList<>();
        Expense expense = new Expense();
        expense.setExpenseName("Snacks");
        expense.setAmount(500);
        expense.setPayer("Ravi");
        expense.setPayees(Arrays.asList("Ravi", "Sita", "Geeta", "Suma"));
        expenses.add(expense);

        Map<String, Double> expenseMap = splitwiseSettleUpService.settleExpenses(expenses);
        assertFalse(expenseMap.containsKey("Ravi pays Ravi"));
    }

    @Test
    void shouldDisplayCorrectOwedAmountForSita(){
        List<Expense> expenses = new ArrayList<>();
        Expense expense = new Expense();
        expense.setExpenseName("Snacks");
        expense.setAmount(500);
        expense.setPayer("Ravi");
        expense.setPayees(Arrays.asList("Ravi", "Sita", "Geeta", "Suma"));
        expenses.add(expense);

        Map<String, Double> expenseMap = splitwiseSettleUpService.settleExpenses(expenses);
        assertEquals(0, expenseMap.get("Sita pays Ravi").compareTo(125.00));
    }

    @Test
    void shouldCollatedOwedBalanceForSita(){
        List<Expense> expenses = new ArrayList<>();
        Expense expense = new Expense();
        expense.setExpenseName("Snacks");
        expense.setAmount(500);
        expense.setPayer("Ravi");
        expense.setPayees(Arrays.asList("Ravi", "Sita", "Geeta", "Suma"));
        expenses.add(expense);

        Expense anotherExpense = new Expense();
        anotherExpense.setExpenseName("Taxi");
        anotherExpense.setAmount(200);
        anotherExpense.setPayer("Ravi");
        anotherExpense.setPayees(Arrays.asList("Sita", "Geeta"));

        expenses.add(anotherExpense);

        Map<String, Double> expenseMap = splitwiseSettleUpService.settleExpenses(expenses);
        assertEquals(0, expenseMap.get("Sita pays Ravi").compareTo(225.00));
    }

    @Test
    void shouldThrowSplitwiseServiceExceptionIfNullExpenses(){
        assertThrows(SplitwiseServiceException.class, ()->splitwiseSettleUpService.settleExpenses(null));
    }

    @AfterAll
    public static void tearDown() {
        splitwiseSettleUpService = null;
    }
}