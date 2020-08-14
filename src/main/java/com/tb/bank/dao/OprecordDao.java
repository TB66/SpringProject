package com.tb.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tb.bank.Oprecord;

@Repository
public class OprecordDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Integer accountid, Double opmoney) {
		return jdbcTemplate.update("insert into oprecord values(null,?,?,null,now())", accountid, opmoney);
	}

	public List<Oprecord> selectById(Integer accountid) {
		String sql = "select * from oprecord where accountid=?";
		Object[] args = { accountid };
		return jdbcTemplate.query(sql, args, new RowMapper<Oprecord>() {

			@Override
			public Oprecord mapRow(ResultSet rs, int rowNum) throws SQLException {
				Oprecord o = new Oprecord();
				o.setId(rs.getInt("id"));
				o.setAccountid(rs.getInt("accountid"));
				o.setOpmoney(rs.getDouble("opmoney"));
				o.setCharge(rs.getDouble("charge"));
				o.setOptime(rs.getTimestamp("optime"));
				return o;
			}

		});

	}
}
