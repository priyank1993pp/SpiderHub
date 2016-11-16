<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="jumbotron">
	<form:form modelAttribute="task" role="form"
		enctype="multipart/form-data">

File Upload: <input type="file" name="file" required=required />
		<input class="btn btn-primary" type="submit" name="action"
			value="Upload">

	</form:form>
	<table class="table table-hover">
		<tr>
			<th>File Name</th>
			<th>File Type</th>
			<th>File Upload Date</th>
		</tr>
		<c:forEach items="${fileModel}" var="file">
			<tr>

				<%-- <td><input type="radio" name="files" value="${file.id}" /></td> --%>
				<td>${file.fileName}</td>
				<td>${file.fileType}</td>
				<td>${file.uploadDate}</td>

			</tr>
		</c:forEach>
	</table>
</div>