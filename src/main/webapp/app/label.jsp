<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.powerchord.models.Label"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Genres</title>
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
<script src="/powerchord/js/utils/formUtils.js"></script>

<body>
	<jsp:include page="/components/toolbar.jsp" />
	<jsp:include page="/components/sidebar.jsp" />
	<main>
		<button class="generic-button"
			onclick="toggleFormVisibility('labelFormContainer')">Add new
			label</button>
		<div id="labelFormContainer" class="form-submit-container"
			style="display: none;">
			<form name="labelForm" method="post" action="CreateLabelServlet">
				Label Name: <input type="text" name="labelName" class="form-input" />
				<br />
				<div class="form-submit-container">
					<input class="form-submit" type="submit" value="Add Label" />
				</div>
			</form>
		</div>

		<h1>Labels</h1>
		<div class="table-container">
			<%
			List<?> labelsList = (List<?>) request.getAttribute("labels");
			if (labelsList != null) {
				for (Object obj : labelsList) {
					Label label = (Label) obj;
			%>
			<div class="cell"><%=label.getLabelName()%></div>
			<%
			}
			}
			%>
		</div>
	</main>
</body>
</html>