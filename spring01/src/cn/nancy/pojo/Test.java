package cn.nancy.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// �����ļ����أ�������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person p = ac.getBean("pe",Person.class);
		System.out.println(p);
		String[] s = ac.getBeanDefinitionNames();  // ��ȡ�����й�������еĶ���
		for(String temp:s) {
			System.out.println(temp);
		}
	}

}
