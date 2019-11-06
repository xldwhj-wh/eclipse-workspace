package com.whj.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.whj.pojo.People;
import com.whj.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{
	@Override
	public List<People> show() throws IOException{
		// TODO Auto-generated method stub
		InputStream iStream = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("com.whj.mapper.peopleMapper.selAll");
		session.close();
		return list;
	}
}
