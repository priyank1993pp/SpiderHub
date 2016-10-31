<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Task Management</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
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
	<h2>Task Management</h2>

	<table class = "table table-hover">
		<tr>
			<th>ID</th>
			<th>TaskName</th>
			<th>Description</th>
			<th>createDate</th>
			<th>startDate</th>
			<th>endDate</th>
			<th>Operations</th>
			<c:forEach items="${tasks}" var="task">
				<tr>
					<td>${task.id}</td>
					<td>${task.taskName}</td>
					<td>${task.taskDescription}</td>
					<td>${task.createDate}</td>
					<td>${task.startDate}</td>
					<td>${task.endDate}</td>
					<td><a href="viewTask.html?id=${task.id}">View</a></td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<p>
		<a href="addTask.html">Add new Task</a>
	</p>
</body>
</html>
