<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Project</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</head>
<body
	style="background: url(<%=request.getContextPath()%>/images/rbg1.jpg) no-repeat center center fixed">
	<div class="container" style="margin-top: 20px;">
		<div class="row text-center pad-top ">
			<div class="col-md-12">
				<h2 style="color: white;">Add Project For SpiderHub</h2>
			</div>
		</div>
		<div class="row  pad-top">
			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel panel-success">
					<div class="panel-heading">
						<strong> Add A Project </strong>
					</div>
					<div class="panel-body">
						<!-- This is a SPRING_MVC Form -->
						<form:form modelAttribute="project" role="form">

							<p style="color: red; text-align: center;">${sessionScope.error}</p>
							<h4 class="text-info">Project Name:</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-envelope"></span>
									</div>
									<form:input path="projectName" type="text"
										placeholder="Enter Project Name" class="form-control"
										required="true" />
								</div>
							</div>
							<h4 class="text-info">Project Description:</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</div>
									<form:textarea path="projectDescription" rows="5" cols="30"
										placeholder="Enter Project Description" class="form-control"
										required="true" />
								</div>
							</div>
							<h4 class="text-info">Select Project Type</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<select name="projecttype">
										<c:forEach items="${projecttype}" var="type">

											<option value="${type.id}">${type.projectType}</option>

										</c:forEach>
									</select>
								</div>
							</div>
							


							<h4 class="text-info">Github Link:</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-user"></span>
									</div>
									<form:input path="projectGitHubLink" type="text"
										placeholder="Enter Github Link" class="form-control"
										required="false" />
								</div>
							</div>




							<input class="btn btn-primary" type="submit" name="add"
								value="Add">
							<input class="btn btn-primary" type="reset" name="reset"
								value="Reset">
							
							<hr />


						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
