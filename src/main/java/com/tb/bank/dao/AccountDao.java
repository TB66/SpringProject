package com.tb.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.tb.bank.Account;

@Repository
public class AccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Integer id, String pwd, Double balance) {
		return jdbcTemplate.update("insert into account values(?,?,?)", id, pwd, balance);
	}

	public int update(Integer id, Double balance) {
		return jdbcTemplate.update("update account set balance = balance + ? where accountid=?", balance, id);
	}

	public Account selectById(Integer id) {
		String sql = "select * from account where id=?";
		Object[] args = { id };
		return jdbcTemplate.query(sql, args, new ResultSetExtractor<Account>() {

			@Override
			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				Account acc = new Account();
				acc.setAccountid(rs.getInt("accountid"));
				acc.setPassword(rs.getString("password"));
				acc.setBalance(rs.getDouble("balance"));
				return acc;
			}

		});

	}
}
