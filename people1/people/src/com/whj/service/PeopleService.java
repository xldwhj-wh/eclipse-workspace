package com.whj.service;

import java.io.IOException;
import java.util.List;

import com.whj.pojo.People;

public interface PeopleService {
	// ��ʾȫ��
	List<People> show() throws IOException;
}
