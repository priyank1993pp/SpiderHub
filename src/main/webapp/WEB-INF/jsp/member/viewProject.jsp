<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Project</title>
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
	<h1>Project Details</h1>
	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<td>${project.id}</td>
		</tr>
		<tr>
			<th>TaskName</th>
			<td>${project.projectName}</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>${project.projectDescription}</td>
		</tr>

	</table>
	<h1>Assigned Tasks</h1>
	<table class="table table-hover">
		<tr>
			<th>Task</th>
			<th>Operation</th>
		</tr>

		<c:forEach items="${task}" var="task">

			<tr>
				<td>${task.taskName}</td>
				<td><c:if test="${task.statusTasks.id==1 }">
						<a href="doneTask.html?tid=${task.id}"><img
							src="<%=request.getContextPath()%>/IMAGE/delete.png" /></a>
					</c:if> <c:if test="${task.statusTasks.id==2 }">
					Done
					</c:if></td>
					<td><td><a
							href="viewTask.html?tid=${task.id}&pid=${project.id}">View</a></td></td>
			</tr>

		</c:forEach>
	</table>

</body>
</html>