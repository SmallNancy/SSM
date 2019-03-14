package cn.nancy.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.nancy.pojo.People;
import cn.nancy.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{

	
	@Override
	public List<People> show() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	  SqlSession session =	factory.openSession();
	  List<People> list = session.selectList("cn.nancy.mapper.PeopleMapper.selectAll");
	  session.close();
		return list;
	}

}
