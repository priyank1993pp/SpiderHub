<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>User Registration</title>
<link rel="stylesheet" type='text/css' href='css/homework1.css' />
<script type='text/javascript' src='js/jquery-1.4.2.js'></script>
<script type='text/javascript' src='js/homework1.js'></script>
</head>

<body>
	<div id="header">
		<h2>
			<a href="index.html">SpiderHub</a>
		</h2>
	</div>
	<div id='wrapper'>
		<div id='steps'>
			<form:form modelAttribute="user">
				<fieldset class='step'>
					<legend>Registration</legend>
					<p class='center'>
						Username :
						<form:input path="userName" placeholder="User Name"
							required="required" />
					</p>

					<p class='center'>
						Email :
						<form:input path="emailAddress" placeholder="Email"
							required="required" />
					</p>
					<p class='center'>
						Password :
						<form:input path="password" placeholder="password"
							required="required" />
					</p>
					<p class='center'>
						PhoneNumber :
						<form:input path="phoneNumber" placeholder="Phonenumber"
							required="required" />
					</p>

					<p class='center'>
						<select name="role">
							<c:forEach items="${UserRole}" var="urole">
								<option value="${urole.id}">${urole.userRole}</option>
							</c:forEach>
						</select>
					</p>
					<p class='center'>

						<input type="submit" name="register" value="Register" />
					</p>
				</fieldset>




			</form:form>
		</div>

	</div>


</body>
</html>
