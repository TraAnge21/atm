package com.Virtual.atm.dao;

import com.Virtual.atm.model.Account;

public interface AccountDao {

    Account getAccountByUserId (int userId);
    int getCheckingAccountId ( int userId);
    int getSavingAccountId ( int userId);

}
