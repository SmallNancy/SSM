package cn.nancy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import cn.nancy.pojo.People;

public class Test {
  public static void main(String[] args) throws IOException {
  	InputStream is = Resources.getResourceAsStream("mybatis.xml");
  	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
  	SqlSession session = factory.openSession();
//  	People p = session.selectOne("cn.nancy.pojo.People.getId");
//  	System.out.println(p);
  	List<People> list =  session.selectList("cn.nancy.pojo.People.selectAll");
  	session.close();
	}
}
