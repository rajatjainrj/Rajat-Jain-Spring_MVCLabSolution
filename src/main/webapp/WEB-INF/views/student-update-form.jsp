<%@page import="com.greatlearning.collegefestdebate.model.Student"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Register/Update Student</title>
</head>

<body>

	<div class="container">

		<h3>Register Student for College Fest Debate</h3>
		<hr>

		<form action="/CollegeFestDebate/student/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${student.id}" />

			<div class="form-inline">
				<input type="text" name="name" value="${student.name}"
					class="form-control mb-4 col-4" placeholder="Name">
			</div>

			<div class="form-inline">

				<input type="text" name="country" value="${student.country}"
					class="form-control mb-4 col-4" placeholder="Country">
			</div>

			<div class="form-inline">

				<input type="text" name="department" value="${student.department}"
					class="form-control mb-4 col-4" placeholder="Department">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/CollegeFestDebate/student/list">Back to Student List</a>

	</div>
</body>

</html>