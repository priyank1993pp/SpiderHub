<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

		<div class="jumbotron">
		<h2>Projects you are working on</h2>

		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Desciption</th>

				<th>Created By</th>


				<th>Project Type</th>
				<th>Operation</th>
			</tr>
			<c:forEach items="${projects}" var="project">
				<tr>
					<td>${project.id }</td>
					<td>${project.projectName }</td>
					<td>${project.projectDescription }</td>

					<td>${project.createdUser.userName }</td>


					<td>${project.projectType.projectType }</td>
					<td><a href="viewProject.html?id=${project.id}">View</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		

