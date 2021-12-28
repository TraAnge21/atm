package com.Virtual.atm.dao;

import java.math.BigDecimal;

public interface Saving_AccountDao {
    BigDecimal getBalance ();
    void deposit ( BigDecimal Amount);
    void withdraw ( BigDecimal Amount);
}
