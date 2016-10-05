<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mytags.jsp" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
	<!--  
	id:<form:input path="id"/><form:errors path="id"></form:errors><br/>
	-->
	<form:hidden path="id"/>
	name:<form:input path="name"/><form:errors path="name"></form:errors><br/>
	birthday:<form:input path="birthday"/><form:errors path="birthday"></form:errors><br/>
	<input type="submit" value="submit"/><br/><br/><br/>
	<form:errors path="*"></form:errors>
</form:form>
</body>
</html>