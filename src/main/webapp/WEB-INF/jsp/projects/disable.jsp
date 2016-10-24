<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Disable Project</title>
</head>
<body>
	<form:form modelAttribute="project">
	Project Name: ${projectd.projectName}
		<br />
	Disable: <form:checkbox path="isDelete" /> (Yes/No)
		<br />
		<input type="submit" name="disable" value="Disable" />
	</form:form>
</body>
</html>