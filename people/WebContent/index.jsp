<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 从tomcat服务器根目录webapps开始，后边目录为项目名
	<img src="/people/images/timg.jpg"/> -->
	<table>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${list }" var="peo">
			<tr>
				<td>${peo.id }</td>
				<td>${peo.name }</td>
				<td>${peo.age }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>