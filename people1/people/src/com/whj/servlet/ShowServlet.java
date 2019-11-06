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

@WebServlet("/show")// 此时控制器的路径是WebContent/show
public class ShowServlet extends HttpServlet{
	private PeopleService ps = new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<People> list = ps.show();
		req.setAttribute("list", list);
		//如果请求转发，/ 代表的是项目中WebContent目录
		//如果请求转发不带/,那么代表的是对于本控制器相对路径,从当前资源找到其他资源的过程
		//如果是重定向，静态资源引用，<img src=""/>,<a href="" />,<script src=""/>,
		//css引用时其中的/都表示时tomcat的webapps文件夹根目录（服务器根目录），下面第一个目录是项目名文件夹
		//项目发布时会将WebContent目录修改为项目名
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
