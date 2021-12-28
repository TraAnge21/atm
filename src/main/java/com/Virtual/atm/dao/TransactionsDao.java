package com.Virtual.atm.dao;

import com.Virtual.atm.model.Transactions;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionsDao {

    List <Transactions> getAllTransactions (int userId);
    Transactions getTransactionById (int TransactionsId);
    List<Transactions> getAllPendingTransactions (int userId);
    String transactionValidation ( int TransactionsId);
    String transferBetweenAccount ( BigDecimal Amount, int accountFrom, int accountTo );

}
