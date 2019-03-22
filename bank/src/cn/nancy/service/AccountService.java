package cn.nancy.service;

import java.io.IOException;

import cn.nancy.pojo.Account;

public interface AccountService {
	
	/**
	 * 账号密码不匹配
	 */
	int ACCOUNT_PASSWORD_NOTMATCH = 1;
	/**
	 *     余额不足
	 */
	int BALANCE_NOT_ENOUGH = 2;
	/**
	 * 账号姓名不匹配
	 */
	int ACCOUNT_NAME_NOTMATCH = 3;
	/**
	 * 转账失败
	 */
	int ERROR = 4;
	/**
	 * 转账成功
	 */
	int SUCCEED = 5;
	/**
	 *   转账业务
	 * @param accin    收款账户
	 * @param accOut   我的账户，转账账户
	 * @return
	 */
  int transfer(Account accin,Account accOut) throws IOException;
}
