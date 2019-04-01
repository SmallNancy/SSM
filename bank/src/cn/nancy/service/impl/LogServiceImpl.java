package cn.nancy.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.nancy.pojo.Log;
import cn.nancy.pojo.PageInfo;
import cn.nancy.service.LogService;

public class LogServiceImpl implements LogService{

	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		InputStream is =  Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageStart", pageSize+pageNumber -1);
		map.put("pageSize", pageSize);
		List<Log>list = session.selectList("cn.nancy.mapper.LogMapper.selByPage",map);
		Long count = session.selectOne("cn.nancy.mapper.LogMapper.selCount");
		PageInfo pi = new PageInfo();
		pi.setList(list);
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}

}
