<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>

</head>
<body>

						<!-- This is a SPRING_MVC Form -->
						<form:form modelAttribute="user">
							<h4 class="text-info">User Name</h4>
																<form:input path="userName" 
										placeholder="Enter User Name" class="form-control" />
									<br /> <b><form:errors path="userName"
											style="font-size:13px; color:red;" /></b>
							
							<h4 class="text-info">E-mail</h4>
							
									<form:input path="emailAddress" type="text"
										placeholder="Enter Email Address" class="form-control" />
									<form:errors path="emailAddress" style="font-size:13px; color:red;" />
						
							<h4 class="text-info">Password</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<form:input path="password" type="text"
										placeholder="Enter Password" class="form-control" />
									<form:errors path="password" />
								</div>
							</div>
							<h4 class="text-info">Phone Number</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<form:input path="phoneNumber" type="text"
										placeholder="Enter Phone Number" class="form-control" />
									<form:errors path="phoneNumber" />
								</div>
							</div>
							<h4 class="text-info">Select Role</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<select name="role">
										<c:forEach items="${UserRole}" var="urole">
											<c:if test="${urole.id ne 1000 }">
												<option value="${urole.id}">${urole.userRole}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
							<input class="btn btn-primary" type="submit" name="register"
								value="Register Me">
							<hr />
							Already Registered ? <a href="login.html">Login here</a>

						</form:form>
					
</body>
</html>
