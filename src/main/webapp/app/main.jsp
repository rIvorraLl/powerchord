<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" type="text/css"
	href="/powerchord/css/components/toolbar.css">
<link rel="stylesheet" type="text/css"
	href="/powerchord/css/components/sidebar.css">
<link rel="stylesheet" type="text/css"
	href="/powerchord/css/layouts/default.css">

</head>
<body>
	<jsp:include page="/components/toolbar.jsp" />
	<jsp:include page="/components/sidebar.jsp" />
	<main>
		<%
		String username = (String) session.getAttribute("name");
		%>
		<p>
			Welcome,
			<%=username%>, this is a test so I see if this get printed or not.</p>
	</main>
</body>
</html>