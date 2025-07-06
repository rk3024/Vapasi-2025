package com.tw.service;

import com.tw.entity.Expense;
import com.tw.entity.Settlement;
import com.tw.exception.SplitwiseServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SplitwiseSettleUpService {

    public SplitwiseSettleUpService() {
    }

    public Map<String, Double>  settleExpenses(List<Expense> expenses) throws SplitwiseServiceException{
        if(expenses != null && !expenses.isEmpty()){
            return expenses.stream().map(expense -> {
                        ArrayList<Settlement> settlementList = new ArrayList<>();
                        double splitAmount = expense.getAmount() / expense.getPayees().size();
                        expense.getPayees().forEach(payee -> settlementList.add(new Settlement(payee, expense.getPayer(), splitAmount)));
                        return settlementList;
                    }).reduce(new ArrayList<>(), (settlementListOne, settlementListTwo) -> {
                        settlementListOne.addAll(settlementListTwo);
                        return settlementListOne;
                    }).stream().filter(settlement -> !settlement.isSelfSettlement())
                    .collect(Collectors.toMap(Settlement::getUniqueId, Settlement::getAmount, Double::sum ));
        }
        throw new SplitwiseServiceException("Error encountered in SplitwiseSettleService.");
    }
}
