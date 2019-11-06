package com.whj.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.whj.pojo.People;



public class Test {
	public static void main(String[] args) throws IOException{
		InputStream iStream = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
		SqlSession session = factory.openSession();
		
		// 可以向mapper.xml文件中传值
		People pid = session.selectOne("com.whj.mapper.peopleMapper.selById",2);
		System.out.println(pid);
		
		// 如果希望传递多个参数，可以使用对象或map，因为只能传入一个参数
		Map<String, Object> map = new HashMap<>();
		map.put("id", 1);
		map.put("name", "张三");
		People pmap = session.selectOne("com.whj.mapper.peopleMapper.selByIdMap",map);
		System.out.println(pmap);
		session.close();
	}
}
