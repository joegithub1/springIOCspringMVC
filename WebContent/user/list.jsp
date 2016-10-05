<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/mytags.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
<h1>用户列表</h1>
<div>
<a href="${ctx }/user/add.do">新增</a>

</div>
<div>
<c:forEach items="${users }" var="u">
	<c:out value="${u.id}" />
	<c:out value="${u.name}" /> 
	<c:out value="${u.birthday}" />
	<a href="${ctx }/user/delete/${u.id}.do">删除</a> 
	<a href="${ctx }/user/update/${u.id}.do">修改</a>   
	<a href="${ctx }/user/show/${u.id}.do">查看</a>
	<br/>
</c:forEach>
</div>
<script type="text/javascript" src="${ctx }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>