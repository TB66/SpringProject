package com.tb.spring;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tb.bank.Oprecord;
import com.tb.bank.biz.BankBiz;
import com.tb.bank.biz.BizException;

@RunWith(SpringRunner.class)
@ContextConfiguration("/jdbc.xml")
public class JdbcTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BankBiz bb;

	@Test
	public void test() {
		jdbcTemplate.update("insert into account values(1,'a',1000)");
	}

	@Test
	public void test1() {
		bb.register(3, "a", 1000d);
	}

	@Test
	public void test2() throws BizException {
		bb.save(3, 700d);
	}

	@Test
	public void test3() throws BizException {
		bb.transfer(1, 3, 200d);
	}
	@Test
	public void test4() {
		List<Oprecord> list=bb.queryOprecord(3);
		for(Oprecord o:list) {
			System.out.println(o);
		}
	}
}
