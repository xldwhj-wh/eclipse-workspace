package com.h3c.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



@WebServlet("/pool")
public class DemoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Context ctx = new InitialContext();
		    // 获取数据库连接池对象,java:comp/env/固定字符串，test为context.xml文件中的name
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/test");
			// 获取连接对象
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement("select *from flower");
			ResultSet rs = ps.executeQuery();
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			while(rs.next()) {
				out.print(rs.getInt(1) + "&npsp,&nbsp,&npsp,&nbsp" + rs.getString(2) + "</br>");
			}
			out.print("success");
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
