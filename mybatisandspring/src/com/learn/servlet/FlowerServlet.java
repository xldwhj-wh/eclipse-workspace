package com.learn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.learn.pojo.Flower;
import com.learn.service.FlowerService;
import com.learn.service.impl.FlowerServiceImpl;

/**
 * Servlet implementation class FlowerServlet
 */
@WebServlet("/showFlower")
public class FlowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlowerService flowerService;
	@Override
	public void init() throws ServletException {
			//对service实例化
//			ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		//spring和web整合后所有的信息都存放在webApplicationContext中，tomcat加载时利用web.xml中spring的配置文件内容启动spring
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		flowerService = ac.getBean("flowerService",FlowerServiceImpl.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		List<Flower> flowers = flowerService.show();
		System.out.println(flowers);
	}
}
