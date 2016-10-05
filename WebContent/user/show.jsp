<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/mytags.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户条件查询</title>
</head>
<body>
<a href="${ctx }/user/list.do">后退</a><br/><br/>
id  : ${user.id } <br/>
name: ${user.name}<br/>
birthday: ${user.birthday }<br/>
</body>
</html>