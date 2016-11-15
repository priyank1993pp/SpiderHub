<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="jumbotron">
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

	<h1>Task Details</h1>
	<table class="table table-hover">
		<tr>
			<th>Task</th>
			<th>Task Status</th>
			<th>Operation</th>
			<th>Assign Files</th>
		</tr>

		<c:forEach items="${tasks}" var="task">

			<tr>
				<td>${task.taskName}</td>
				<c:choose>
					<c:when test="${empty task.statusTasks.statusName}">
						<td>Incomplete</td>
					</c:when>
					<c:otherwise>
						<td>${task.statusTasks.statusName }</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${empty task.userTasks}">
						<td><a
							href="assignTask.html?tid=${task.id}&pid=${project.id}">Assign</a></td>
					</c:when>
					<c:otherwise>
						<td>Already Assigned</td>
						<td><a
							href="uploadFileToAssigned.html?tid=${task.id}&pid=${project.id}">Upload</a></td>
					</c:otherwise>
				</c:choose>
			</tr>

		</c:forEach>
	</table>
	<a href="addUserInProject.html?id=${project.id}">Add User In
		Project</a> <br /> <a href="addTask.html?id=${project.id}">Add Task
		In Project</a>
</div>
