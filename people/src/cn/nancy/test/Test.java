package cn.nancy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.nancy.pojo.People;

public class Test {
  public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = fac.openSession();
		List<People> list = session.selectList("cn.nancy.mapper.PeopleMapper.selectAll");
		for(People p: list) {
			System.out.println(p.toString());
		}
	  session.close();
	}
}
