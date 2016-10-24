<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="task">
		Task-name  <form:input path="taskName" />
		<br />
		Description:<form:input path="taskDescription" />
		<br /> 
		Create-Date<form:input path="createDate" />
		<br /> 
		Start-Date<form:input path="startDate" />
		<br /> 
				End-Date<form:input path="endDate" />
		<br />

		<input type="submit" name="add" value="Add" />
	</form:form>
</body>
</html>