package cn.nancy.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.nancy.pojo.PageInfo;
import cn.nancy.pojo.People;
import cn.nancy.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{

	@Override
	public PageInfo show(int pageSize, int pageNumber) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pageStart", pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		// pi.setList(session.selectList("nancy.People.page"),map);
		long count = session.selectOne("nancy.People.sel");
		pi.setTotal(count);
		return pi;
	}
	

	

}
