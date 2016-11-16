<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

		<div class="jumbotron">
		<div class="row text-center pad-top ">
			<div class="col-md-12">
				<h2 style="color: black;">Registration For SpiderHub</h2>
			</div>
		</div>
		<div class="row  pad-top">
			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel panel-success">
					<div class="panel-heading">
						<strong> Create A SpiderHub Account </strong>
					</div>
					<div class="panel-body">
						<!-- This is a SPRING_MVC Form -->
						<form:form modelAttribute="user" role="form">

							<p style="color: red; text-align: center;">${sessionScope.error}</p>
							<h4 class="text-info">User Name</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<form:input path="userName" type="text"
										placeholder="Enter User Name" class="form-control"
										required="true" />
								</div>
							</div>
							<h4 class="text-info">E-mail</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<form:input path="emailAddress" type="text"
										placeholder="Enter Email Address" class="form-control"
										required="true" />
								</div>
							</div>
							<h4 class="text-info">Password</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<form:input path="password" type="text"
										placeholder="Enter Password" class="form-control"
										required="true" />
								</div>
							</div>
							<h4 class="text-info">Phone Number</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<form:input path="phoneNumber" type="text"
										placeholder="Enter Phone Number" class="form-control"
										required="true" />
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
								value="ADD User.">
							<hr />


						</form:form>
					</div>
				</div>
			</div>
		</div>
		</div>
		
