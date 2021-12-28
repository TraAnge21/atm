package com.Virtual.atm.dao;

import java.math.BigDecimal;

public interface Checking_AccountDao {
    BigDecimal getBalance ();
    void deposit ( BigDecimal Amount);
    void withdraw ( BigDecimal Amount);

}
