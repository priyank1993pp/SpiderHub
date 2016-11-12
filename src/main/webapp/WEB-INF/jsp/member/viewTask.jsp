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
	<div class="header clearfix">
		<nav>
		<ul class="nav nav-pills pull-right">
			<li role="presentation" class="active"><a href="../index.html">Home</a></li>

		</ul>
		</nav>

	</div>
	<table class="table table-hover">
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
		<table class="table table-hover">
			<tr>
				<th>File Name</th>
				<th>File Type</th>
				<th>File Path</th>
				<th>File Upload Date</th>
				<th>File Download</th>
			</tr>
			<c:forEach items="${fileModel}" var="file">
				<tr>

					<%-- <td><input type="radio" name="files" value="${file.id}" /></td> --%>
					<td>${file.fileName}</td>
					<td>${file.fileType}</td>
					<td>${file.filePath}</td>
					<td>${file.uploadDate}</td>
					<td><a href="download.html?file=${file.fileName}.${file.fileType}">File Download</a></td>


				</tr>
			</c:forEach>
		</table>
	</table>
</body>
</html>