<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.powerchord.models.Genre"%>
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
		<button class="generic-button" onclick="toggleFormVisibility('genreFormContainer')">Add
			new genre</button>
		<div id="genreFormContainer" class="form-submit-container"
			style="display: none;">
			<form name="genreForm" method="post" action="CreateGenreServlet">
				Genre Name: <input type="text" name="genreName" class="form-input" />
				<br />
				<div class="form-submit-container">
					<input class="form-submit" type="submit" value="Add Genre" />
				</div>
			</form>
		</div>

		<h1>Genres</h1>
		<div class="table-container">
			<%
			List<?> genresList = (List<?>) request.getAttribute("genres");
			if (genresList != null) {
				for (Object obj : genresList) {
					Genre genre = (Genre) obj;
			%>
			<div class="cell"><%=genre.getGenreName()%></div>
			<%
			}
			}
			%>
		</div>
	</main>
</body>
</html>