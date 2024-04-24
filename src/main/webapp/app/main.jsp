<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/components/toolbar.css">
</head>
<body>
	<jsp:include page="/components/toolbar.jsp" />
	<%
	String username = (String) session.getAttribute("name");
	%>
	<p>
		Welcome, 
		<%=username%></p>
</body>
</html>