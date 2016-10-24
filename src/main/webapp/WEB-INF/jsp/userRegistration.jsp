
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
	<h1>Registration</h1>
	<form:form modelAttribute="user">
Username    : <form:input path="userName" placeholder="User Name"
			required="required" />
		<br />
Email       : <form:input path="emailAddress" placeholder="Email"
			required="required" />
		<br />
Password    : <form:input path="password" placeholder="password"
			required="required" />
		<br />
PhoneNumber : <form:input path="phoneNumber" placeholder="Phonenumber"
			required="required" />
		<br />
		<select name="role">
			<c:forEach items="${UserRole}" var="urole">
				<option value="${urole.id}">${urole.userRole}</option>
			</c:forEach>
		</select>
		<input type="submit" name="register" value="Register" />
	</form:form>
</body>
</html>