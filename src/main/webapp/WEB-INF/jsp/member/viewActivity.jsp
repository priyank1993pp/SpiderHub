<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

	<form:form modeAttribute="taskActivity">

		<table class="table table-hover">
			<tr>
				<th>Activity id</th>
				<th>Activity complete</th>
				<th>Activity start Time</th>
				<th>activity endtime</th>
				<th>activity of taskId</th>
				<th>activity by userId</th>
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
		</table>
		<input class="btn btn-primary" type="submit" name="action"
			value="start">
					<input type = "hidden"  name = "activityId" value="${activityId}"></input>
			
		<input class="btn btn-primary" type="submit" name="action"
			value="stop">
	</form:form>
</body>
</html>