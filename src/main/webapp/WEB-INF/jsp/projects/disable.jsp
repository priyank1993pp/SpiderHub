<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Disable Project</title>
</head>
<body>
	<div id="header">
		<h2>
			<a href="../index.html">SpiderHub</a>
		</h2>
	</div>
	<form:form modelAttribute="project">
	Project Name: ${project.projectName}
		<br />
	Disable: <form:radiobutton path="isDelete" value="true" />
		<form:radiobutton path="isDelete" value="false" />
		<br />
		<input type="submit" name="disable" value="Disable" />
	</form:form>
</body>
</html>