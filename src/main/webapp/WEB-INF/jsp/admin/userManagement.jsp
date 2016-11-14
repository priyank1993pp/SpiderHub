<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Projects</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header clearfix">
		<nav>
			<ul class="nav nav-pills pull-right">
				<li role="presentation" class="active"><a href="../index.html">Home</a></li>

			</ul>
		</nav>

	</div>
	<h2>User Management</h2>

	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Name</th>

			<th>Phone Number</th>
			<th>Email Address</th>
			<th>Status</th>
			<th>Opertations</th>
		</tr>
		<c:forEach items="${users}" var="user">
			
			<tr>
			
				<td>${user.id }</td>
				<td>${user.userName }</td>

				<td>${user.phoneNumber }</td>
				<td>${user.emailAddress }</td>
				<td><c:if test="${not user.delete }">
						<a href="disableuser.html?id=${user.id }"><img
							src="<%=request.getContextPath()%>/IMAGE/delete.png" /></a>
					</c:if> <c:if test="${user.delete }">
					Done
					</c:if></td>
				<td><a href="editUser.html?id=${user.id }">Edit User</a> | <a
					href="validate.html?id=${user.id }">Validate</a></td>
				<td><c:if test="${not user.delete }">
						<a href="editUser.html?id=${user.id }">Edit User</a>
					</c:if>
					<c:if test="${user.delete }">
					Done
					</c:if></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="userRegistration.html">Add new user.</a>
	</p>
</body>
</html>
