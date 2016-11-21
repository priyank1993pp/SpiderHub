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

		<tr>
			<th>Project Progress</th>
			<td><div class="progress">
					<div class="progress-bar" role="progressbar" aria-valuenow="70"
						aria-valuemin="0" aria-valuemax="100" style="width: ${progress}%">
						${progress}%</div>
				</div></td>
		</tr>

	</table>

	<h2>
		<p>all project related activity</p>
	</h2>
	<table class="table table-hover">
		<tr>
			<th>Activity id</th>
			<th>Activity complete</th>
			<th>Activity start Time</th>
			<th>activity endtime</th>
			<th>Task Id</th>
			<th>userName</th>
		</tr>
		<c:forEach items="${activityModel}" var="activity">
			<tr>
				<td>${activity.id}</td>
				<td>${activity.complete}</td>
				<td>${activity.startTime}</td>
				<td>${activity.endTime}</td>
				<td>${activity.activityOfTask.id}</td>
				<td>${activity.activityOfTaskByUser.userName}</td>
			</tr>
		</c:forEach>
	</table>

	<h2>
		<p>all weekly project related activity</p>
	</h2>
	<table class="table table-hover">
		<tr>
			<th>Activity id</th>
			<th>Activity complete</th>
			<th>Activity start Time</th>
			<th>activity endtime</th>
			<th>Task Id</th>
			<th>userName</th>
			<th>hours</th>
		</tr>
		<c:forEach items="${activityModelWeekly}" var="activity" varStatus="s">
			<tr>
				<td>${activity.id}</td>
				<td>${activity.complete}</td>
				<td>${activity.startTime}</td>
				<td>${activity.endTime}</td>
				<td>${activity.activityOfTask.id}</td>
				<td>${activity.activityOfTaskByUser.userName}</td>
				<td>${hours[s.index]}</td>
			</tr>
		</c:forEach>
	</table>
	<p>${totalHour}</p>

	<h1>Task Details</h1>
	<table class="table table-hover">
		<tr>
			<th>Task</th>
			<th>Task Status</th>
			<th>Assign</th>
			<th>Upload Files</th>
			<th>Hours spent</th>
		</tr>

		<c:forEach items="${tasks}" var="task" varStatus="status">

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
						<td>${task.userTasks.userName}</td>
						<td><a
							href="uploadFileToAssigned.html?tid=${task.id}&pid=${project.id}">Upload</a></td>
					</c:otherwise>
				</c:choose>
				<td><a href="viewTask.html?tid=${task.id}">View</a></td>

				<td>${totalHourArray[status.index]}</td>
			</tr>

		</c:forEach>
	</table>



	<h1>User Detail</h1>
	<table class="table table-hover">
		<tr>
			<th>User Name</th>
			<th>Operation</th>

		</tr>

		<c:forEach items="${user}" var="projectUser">

			<tr>
				<td>${projectUser.userName}</td>
				<td><a
					href="remove.html?id=${projectUser.id}&pid=${project.id}"><img
						src="<%=request.getContextPath()%>/IMAGE/delete.png" /></a>
			</tr>

		</c:forEach>
	</table>
	<a href="addUserInProject.html?id=${project.id}">Add User In
		Project</a> <br /> <a href="addTask.html?id=${project.id}">Add Task
		In Project</a>
</div>
