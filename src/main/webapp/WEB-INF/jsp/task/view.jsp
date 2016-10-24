<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Task</title>
<style type="text/css">
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>
	<div id="header">
		<h2>
			<a href="../index.html">SpiderHub</a>
		</h2>
	</div>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${task.id}</td>
		</tr>
		<tr>
			<th>TaskName</th>
			<td>${task.taskName}</td>
		</tr>
		<tr>
			<th>Description</th>
			<td>${task.taskDescription}</td>
		</tr>

	</table>
</body>
</html>