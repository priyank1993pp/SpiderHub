<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
		<div class="jumbotron">
		<div class="row text-center pad-top ">
			<div class="col-md-12">
				<h2 style="color: black;">Add Task</h2>
			</div>
		</div>
		<div class="row  pad-top">
			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel panel-success">
					<div class="panel-heading">
						<strong> Add Task </strong>
					</div>
					<div class="panel-body">
						<!-- This is a SPRING_MVC Form -->
						<form:form modelAttribute="task" role="form">

							<p style="color: red; text-align: center;">${sessionScope.error}</p>
							<h4 class="text-info">Task-name</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<form:input path="taskName" type="text" placeholder="Task Name"
										class="form-control" required="true" />
								</div>
							</div>
							<h4 class="text-info">Description</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<form:textarea path="taskDescription" rows="5" cols="30"
										placeholder="Description" class="form-control" required="true" />
								</div>
							</div>
							<%-- <h4 class="text-info">Start Date</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<form:input type="datetime" min="2012-01-01" max="2020-01-01" path="startDate" rows="5" cols="30"
										placeholder="Start Date" class="form-control" required="true" />
								</div>
							</div>
							<h4 class="text-info">End Date</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"></div>
									<form:input type="datetime" path="endDate" rows="5" cols="30"
										placeholder="End Date" class="form-control" required="true" />
								</div>
							</div> --%>
							<input class="btn btn-primary" type="submit" name="register"
								value="Add Task">
							<hr />
						</form:form>
					</div>
				</div>
			</div>
		</div>
		</div>