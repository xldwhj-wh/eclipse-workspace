package com.h3c.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.h3c.pojo.Flower;

public class Test {
	public static void main(String[] args) throws Exception{
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//ʹ�ù������ģʽ
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//����SqlSession
		SqlSession session=factory.openSession();
		List<Flower> list = session.selectList("a.b.selAll");
		for (Flower flower : list) {
			System.out.println(flower.toString());
		}
		
		session.close();
	}
}
