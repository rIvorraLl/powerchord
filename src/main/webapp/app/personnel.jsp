<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.powerchord.models.Personnel"%>
<%@ page import="com.powerchord.models.Country"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personnel</title>
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
<link rel="stylesheet" type="text/css"
	href="/powerchord/css/components/personnel.css">
<script src="/powerchord/js/utils/formUtils.js"></script>
</head>

<body>
	<jsp:include page="/components/toolbar.jsp" />
	<jsp:include page="/components/sidebar.jsp" />
	<main>
		<button class="generic-button"
			onclick="toggleFormVisibility('personnelFormContainer')">Add
			new personnel</button>
		<div id="personnelFormContainer" class="form-submit-container"
			style="display: none;">
			<form name="personnelForm" method="post"
				action="CreatePersonnelServlet">
				Name: <input type="text" name="name" class="form-input" />
				Biography: <input type="text" name="biography" class="form-input" />

				<br />
				<div class="form-submit-container">
					<input class="form-submit" type="submit" value="Add Personnel" />
				</div>
			</form>
		</div>

		<h1>Personnel</h1>
		<div class="table-container">
			<%
			List<?> personnelList = (List<?>) request.getAttribute("personnel");
			if (personnelList != null) {
				for (Object obj : personnelList) {
					Personnel personnel = (Personnel) obj;
			%>
			<div class="personnel-container">
				<span class="title-inline">Name: </span><span> <%=personnel.getName()%></span>
				<br> <span class="title-inline">Biography: </span><span><%=personnel.getBiography()%></span>
				<br> <span class="title-inline">Country: </span><span><%=personnel.getCountry().getCountryName() %></span>
			</div>
			<%
			}
			}
			%>
		</div>
	</main>
</body>
</html>