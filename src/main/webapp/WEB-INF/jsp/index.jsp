<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>SpiderHub</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li role="presentation" class="active"><a href="index.html">Home</a></li>

					<li role="presentation"><security:authorize access="anonymous">
							<a href="<c:url value='/login.html' />">Login</a>
						</security:authorize></li>


					<security:authorize access="authenticated">
						<security:authorize access="hasRole('ADMIN')">

							<li role="presentation"><a href="admin/projects/listProjects.html">Project
									Management</a></li>
							<li role="presentation"><a href="admin/userManagement.html">User Management</a></li>
						</security:authorize>
						<security:authorize access="hasAnyRole('MANAGER')">

							<li role="presentation"><a href="manager/projects/listProjects.html">Project
									Management</a></li>
							<li role="presentation"><a href="manager/userRegistration.html">Add
									User</a></li>

						</security:authorize>
						<security:authorize access="hasRole('MEMBER')">
							<li role="presentation"><a href="member/projects/listProjects.html">Projects For You.</a></li>
							<li role="presentation"><a href="member/editProfile.html?id=${user.id}">Edit
									Profile</a></li>
						</security:authorize>
						<h3 class="text-muted">
							Welcome,
							<security:authentication property="principal.username" />
						</h3>
						<li role="presentation"><a href="<c:url value='/logout' />">Logout</a></li>
					</security:authorize>
				</ul>
			</nav>

		</div>

		<div class="jumbotron">
			<h1>SpiderHub</h1>
			<p class="lead">Competition makes us faster, Collaboration makes
				us Better.</p>
			<p>
				<security:authorize access="anonymous">
					<a class="btn btn-lg btn-success" href="userRegistration.html"
						role="button">Sign up today</a>
				</security:authorize>
			</p>
		</div>

		<footer class="footer">
			<p>&copy; SpiderHub Company, Inc.</p>
		</footer>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
