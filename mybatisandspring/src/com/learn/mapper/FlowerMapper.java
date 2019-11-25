package com.learn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.learn.pojo.Flower;

public interface FlowerMapper {
	@Select("select * from flower")
	List<Flower> selAll();
	
}
