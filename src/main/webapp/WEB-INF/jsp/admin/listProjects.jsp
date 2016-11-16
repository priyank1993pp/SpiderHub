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
	<h2>Project Management</h2>

	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Desciption</th>
			<th>Created Date</th>
			<th>Created By</th>
			<th>Github Link</th>
			<th>Status</th>
			<th>Project Progress</th>
			<th>Project Type</th>
			<th>Project Report</th>


		</tr>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td>${project.id }</td>
				<td>${project.projectName }</td>
				<td>${project.projectDescription }</td>
				<td>${project.createdDate }</td>
				<td>${project.createdUser.userName }</td>
				<td>${project.projectGitHubLink }</td>
				
				<td><c:if test="${not project.delete }">
						<a href="disable.html?id=${project.id }"><img
							src="<%=request.getContextPath()%>/IMAGE/delete.png" /></a>
					</c:if> <c:if test="${project.delete }">
					Done
					</c:if></td>
					<td><div class="progress">
						<div class="progress-bar" role="progressbar" aria-valuenow="70"
							aria-valuemin="0" aria-valuemax="100" style="width: 70%">
							70%</div></div></td>
				<td>${project.projectType.projectType }</td>
				<td><a href="reportgeneration.html?id=${project.id}">Report</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>
