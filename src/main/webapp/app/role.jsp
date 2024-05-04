<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.powerchord.models.Role"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Roles</title>
<link rel="stylesheet" type="text/css"
	href="/powerchord/css/components/toolbar.css">
<link rel="stylesheet" type="text/css"
	href="/powerchord/css/components/sidebar.css">
<link rel="stylesheet" type="text/css"
	href="/powerchord/css/components/table.css">
<link rel="stylesheet" type="text/css"
	href="/powerchord/css/layouts/default.css">
<link rel="stylesheet" type="text/css"
	href="/powerchord/css/components/form.css">
<link rel="stylesheet" type="text/css"
	href="/powerchord/css/components/button.css">
</head>
<body>
	<jsp:include page="/components/toolbar.jsp" />
	<jsp:include page="/components/sidebar.jsp" />
	<main>
		<h1>Roles</h1>
		<div class="table-container">
			<%
			List<?> rolesList = (List<?>) request.getAttribute("roles");
			if (rolesList != null) {
				for (Object obj : rolesList) {
					Role role = (Role) obj;
			%>
			<div class="cell"><%=role.getRoleName()%></div>
			<%
			}
			}
			%>
		</div>
	</main>
</body>
</html>