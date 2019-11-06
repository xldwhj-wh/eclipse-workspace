package com.h3c.service;

import java.io.IOException;
import java.util.List;

import com.h3c.pojo.People;

public interface PeopleService {
	// ÏÔÊ¾È«²¿
	List<People> show() throws IOException;
}
