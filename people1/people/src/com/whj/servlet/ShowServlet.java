package com.whj.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whj.pojo.People;
import com.whj.service.PeopleService;
import com.whj.service.impl.PeopleServiceImpl;

@WebServlet("/show")// ��ʱ��������·����WebContent/show
public class ShowServlet extends HttpServlet{
	private PeopleService ps = new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<People> list = ps.show();
		req.setAttribute("list", list);
		//�������ת����/ ���������Ŀ��WebContentĿ¼
		//�������ת������/,��ô������Ƕ��ڱ����������·��,�ӵ�ǰ��Դ�ҵ�������Դ�Ĺ���
		//������ض��򣬾�̬��Դ���ã�<img src=""/>,<a href="" />,<script src=""/>,
		//css����ʱ���е�/����ʾʱtomcat��webapps�ļ��и�Ŀ¼����������Ŀ¼���������һ��Ŀ¼����Ŀ���ļ���
		//��Ŀ����ʱ�ὫWebContentĿ¼�޸�Ϊ��Ŀ��
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
