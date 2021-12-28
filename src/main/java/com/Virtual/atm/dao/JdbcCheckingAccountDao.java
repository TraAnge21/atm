package com.Virtual.atm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcCheckingAccountDao implements Checking_AccountDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BigDecimal getBalance() {

        String sql = " SELECT * FROM CHECKING_ACCOUNT WHERE checking_account_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        return null;
    }

    @Override
    public void deposit(BigDecimal Amount) {

    }

    @Override
    public void withdraw(BigDecimal Amount) {

    }
}
