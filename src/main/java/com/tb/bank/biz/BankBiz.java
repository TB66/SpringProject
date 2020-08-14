package com.tb.bank.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tb.bank.Oprecord;
import com.tb.bank.dao.AccountDao;
import com.tb.bank.dao.OprecordDao;

@Service
@Transactional(rollbackFor = BizException.class)
public class BankBiz {
	@Resource
	private AccountDao aDao;
	@Resource
	private OprecordDao oDao;
	/**
	 * 新增账号
	 * @param id
	 * @param pwd
	 * @param money
	 */
	public void register(Integer id, String pwd, Double money) {
		aDao.insert(id, pwd, money);
		oDao.insert(id, money);
	}
	/**
	 * 存款
	 * @param id
	 * @param money
	 * @throws BizException 
	 */
	//@Transactional(rollbackFor = BizException.class)
	public void save(Integer id, Double money) throws BizException {
		aDao.update(id, money);
		if(money>999) {
			throw new BizException("金额不能超过999");
		}
		oDao.insert(id, money);
	}
	/**
	 * 转账业务
	 * @param id1
	 * @param id2
	 * @param money
	 * @throws BizException 
	 */
	public void transfer(Integer id1, Integer id2, Double money) throws BizException {
		save(id1, -money);
		save(id2, money);
	}
	/**
	 * 查询流水
	 * @param accountid
	 * @return
	 */
	public List<Oprecord> queryOprecord(Integer accountid) {
		return oDao.selectById(accountid);
	}
}
