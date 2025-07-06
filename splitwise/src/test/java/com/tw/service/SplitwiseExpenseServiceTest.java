package com.tw.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SplitwiseExpenseServiceTest {

    public static final String FILEPATHVALID = "./src/test/resources/input.txt";
    public static SplitwiseExpenseService splitwiseExpenseService;

    @BeforeAll
    public static void setUp() {
        splitwiseExpenseService = new SplitwiseExpenseService(FILEPATHVALID);
    }

    @Test
    void shouldReturnExpenseListOfSizeFour() throws FileNotFoundException {
        assertEquals(4, splitwiseExpenseService.loadExpenseDetails().size());
    }

    @Test
    void shouldThrowFileNotFoundException(){
        assertThrows(FileNotFoundException.class, ()-> (new SplitwiseExpenseService("Invalid Path.csv")).loadExpenseDetails());
    }


    @AfterAll
    public static void tearDown(){
        splitwiseExpenseService = null;
    }
}