<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Task</title>
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

	</table>
	<table class="table table-hover">
		<tr>
			<th>File Name</th>
			<th>File Type</th>
			<th>File Upload Date</th>
			<th>File Download</th>
		</tr>
		<c:forEach items="${fileModel}" var="file">
			<tr>

				<%-- <td><input type="radio" name="files" value="${file.id}" /></td> --%>
				<td>${file.fileName}</td>
				<td>${file.fileType}</td>
				<td>${file.uploadDate}</td>
				<td><a
					href="download.html?file=${file.fileName}.${file.fileType}">Download</a></td>


			</tr>
		</c:forEach>
	</table>

	<c:if test="${not empty comments}">
		<c:forEach items="${comments}" var="c">
			<p>${c.userComment.userName}</p>
			<br />
			<p>${c.commentDesc}</p>
		</c:forEach>
	</c:if>
	<form:form modelAttribute="comment" role="form">
		<form:textarea path="commentDesc" rows="2" cols="30"
			class="form-control" required="required" />
		<input type="hidden" name="task" value="${task.id}" />
		<input class="btn btn-primary" type="submit" name="action"
			value="Comment">
	</form:form>
	<a href="assignTask.html?id=${task.id}">Assign</a>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>