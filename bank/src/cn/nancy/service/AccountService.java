package cn.nancy.service;

import java.io.IOException;

import cn.nancy.pojo.Account;

public interface AccountService {
	
	/**
	 * �˺����벻ƥ��
	 */
	int ACCOUNT_PASSWORD_NOTMATCH = 1;
	/**
	 *     ����
	 */
	int BALANCE_NOT_ENOUGH = 2;
	/**
	 * �˺�������ƥ��
	 */
	int ACCOUNT_NAME_NOTMATCH = 3;
	/**
	 * ת��ʧ��
	 */
	int ERROR = 4;
	/**
	 * ת�˳ɹ�
	 */
	int SUCCEED = 5;
	/**
	 *   ת��ҵ��
	 * @param accin    �տ��˻�
	 * @param accOut   �ҵ��˻���ת���˻�
	 * @return
	 */
  int transfer(Account accin,Account accOut) throws IOException;
}
