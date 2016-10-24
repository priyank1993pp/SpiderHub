<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Project</title>
</head>
<body>
	<form:form modelAttribute="project">
	Project Name: <form:input path="projectName" />
		<br />
	Project Description: <form:input path="projectDescription" />
		<br />
	Github Link: <form:input path="projectGitHubLink" />
		<br />
	
		<input type="submit" name="add" value="Add" />
	</form:form>
</body>
</html>