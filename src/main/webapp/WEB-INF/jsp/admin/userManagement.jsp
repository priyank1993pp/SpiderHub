<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

		<div class="jumbotron">
		<h2>User Management</h2>

		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Name</th>

				<th>Phone Number</th>
				<th>Email Address</th>
				<th>Status</th>
				<th>Opertations</th>
			</tr>
			<c:forEach items="${users}" var="user">

				<tr>

					<td>${user.id }</td>
					<td>${user.userName }</td>

					<td>${user.phoneNumber }</td>
					<td>${user.emailAddress }</td>
					<td><c:if test="${not user.delete }">
							<a href="disableuser.html?id=${user.id }"><img
								src="<%=request.getContextPath()%>/IMAGE/delete.png" /></a>
						</c:if> <c:if test="${user.delete }">
					Done
					</c:if></td>
					<td><c:if test="${not user.delete }">
							<a href="editUser.html?id=${user.id }">Edit User</a>
						</c:if> <c:if test="${user.delete }">
					Done
					</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<a href="userRegistration.html">Add new user.</a>
		</p>
		</div>
		