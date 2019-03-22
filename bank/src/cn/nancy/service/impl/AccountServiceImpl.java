package cn.nancy.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import cn.nancy.pojo.Account;
import cn.nancy.pojo.Log;
import cn.nancy.service.AccountService;

public class AccountServiceImpl implements AccountService{

	@Override
	public int transfer(Account accin, Account accOut) throws IOException {
		// 1.��ȡȫ�������ļ�
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
	  // ������������ִ�е�sql����������
		Account accOutSelect = session.selectOne("cn.nancy.mapper.AccountMapper.getAccPass",accOut); 
		if(accOutSelect != null) {
			if(accOutSelect.getBalance() >= accOut.getBalance()) {
				Account accInSelect = session.selectOne("cn.nancy.mapper.AccountMapper.getAccName",accin);
				if(accInSelect != null) {
					accin.setBalance(accOut.getBalance());
					accOut.setBalance(-accOut.getBalance());
					int index = session.update("cn.nancy.mapper.AccountMapper.updateBalance",accin);
					index += session.update("cn.nancy.mapper.AccountMapper.updateBalance",accOut);
					if(index == 2) {
						
						// ��־�ļ���¼
						Log log = new Log();
						log.setAccIn(accin.getAccnumber());
						log.setAccOut(accOut.getAccnumber());
						log.setMoney(accin.getBalance());
						session.insert("cn.nancy.mapper.LogMapper.selectlog",log);
						Logger logger = Logger.getLogger(AccountServiceImpl.class);
						logger.info(log.getAccOut() + "ת�˸�" + log.getAccIn()+ log.getMoney() + "Ǯ��\n" + new Date().toLocaleString());
						session.commit();
						session.close();
						return SUCCEED;
					}else {
						session.rollback();
						session.close();
						return ERROR;
					}
				}else {
					return ACCOUNT_NAME_NOTMATCH;
				}
			}else {
				return BALANCE_NOT_ENOUGH;
			}
		}else {
			return ACCOUNT_PASSWORD_NOTMATCH;
		}
	}

}
