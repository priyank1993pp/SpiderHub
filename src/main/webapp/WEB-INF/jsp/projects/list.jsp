<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Projects</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<h2>Project Management</h2>
	<div id="header">
		<h2>
			<a href="../index.html">SpiderHub</a>
		</h2>
	</div>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Desciption</th>
			<th>Created Date</th>
			<th>Created By</th>
			<th>Github Link</th>
			<th>Status</th>
			<th>Project Type</th>
			<th>Opertations</th>
		</tr>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td>${project.id }</td>
				<td>${project.projectName }</td>
				<td>${project.projectDescription }</td>
				<td>${project.createdDate }</td>
				<td>${project.createdUser }</td>
				<td>${project.projectGitHubLink }</td>
				<td><c:if test="${not project.delete }">
						<a href="disable.html?id=${project.id }"><img
							src="<%=request.getContextPath()%>/IMAGE/delete.png" /></a>
					</c:if> <c:if test="${project.delete }">
					${project.delete }
					</c:if></td>
				<td>${project.projectType }</td>
				<td><a href="view.html?id=${project.id}">View</a> | <a
					href="view/${project.id}.html">View2</a> | <a
					href="edit.html?id=${project.id }">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="add.html">Add new project.</a>
	</p>
</body>
</html>
