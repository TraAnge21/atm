package com.Virtual.atm.dao;

import com.Virtual.atm.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLException;


@Component
public class JdbcAccountDao implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Account getAccountByUserId(int userId) {
        Account account = null ;
        try {
            String sql = " SELECT * FROM ACCOUNT WHERE user_id = ? " ;
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql,userId);
            if ( result.next()){
                account =rowMap(result);
            }
        } catch ( DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
       return account;
    }


    @Override
    public int getCheckingAccountId(int userId) {

        Account account = getAccountByUserId(userId);
        return account.getChecking_account_id();

    }

    @Override
    public int getSavingAccountId(int userId) {
        Account account = getAccountByUserId(userId);
        return account.getSaving_account_id();
    }


    private Account rowMap(SqlRowSet result) {
        Account account = new Account();
        account.setAccount_id(result.getInt("account_id"));
        account.setChecking_account_id((result.getInt("checking_account_id")));
        account.setSaving_account_id(result.getInt("saving_account_id"));
        account.setUser_id(result.getInt("user_id"));
        return account;
    }

}
