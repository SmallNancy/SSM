package cn.nancy.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// 配置文件加载，对象立即创建
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person p = ac.getBean("pe",Person.class);
		System.out.println(p);
		String[] s = ac.getBeanDefinitionNames();  // 获取容器中管理的所有的对象
		for(String temp:s) {
			System.out.println(temp);
		}
	}

}
