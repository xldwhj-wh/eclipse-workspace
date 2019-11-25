package com.learn.service.impl;

import java.util.List;

import com.learn.mapper.FlowerMapper;
import com.learn.pojo.Flower;
import com.learn.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{

	private FlowerMapper folowerMapper;
	@Override
	public List<Flower> show() {
		// TODO Auto-generated method stub
		return folowerMapper.selAll();
	}
	public FlowerMapper getFolowerMapper() {
		return folowerMapper;
	}
	public void setFolowerMapper(FlowerMapper folowerMapper) {
		this.folowerMapper = folowerMapper;
	}
	

}
