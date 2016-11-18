<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:insertAttribute name="title"
		defaultValue="Projects" defaultValueType="string" /></title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<nav>
				<ul class="nav nav-pills pull-right">
					<li role="presentation" ><a href="../index.html">Home</a></li>

					<li role="presentation"><security:authorize access="anonymous">
							<a href="<c:url value='/login.html' />">Login</a>
						</security:authorize></li>


					<security:authorize access="authenticated">
						<security:authorize access="hasRole('ADMIN')">

							<li role="presentation"><a href="../admin/listProjects.html">Project
									Management</a></li>
							<li role="presentation"><a href="../admin/userManagement.html">User
									Management</a></li>
						</security:authorize>
						<security:authorize access="hasAnyRole('MANAGER')">

							<li role="presentation"><a href="../manager/listProjects.html">Project
									Management</a></li>


						</security:authorize>
						<security:authorize access="hasRole('MEMBER')">
							<li role="presentation"><a href="../member/listProjects.html">Projects
									For You.</a></li>
						</security:authorize>

						<li role="presentation"><a href="<c:url value='/logout' />">Logout</a></li>
					</security:authorize>
				</ul>
			</nav>
		<security:authorize access="authenticated">
			<h3 class="text-muted">
				Welcome,
				<security:authentication property="principal.username" />
			</h3>
		</security:authorize>
		<div class="content">
			<tiles:insertAttribute name="content" />
		</div>
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</div>



	<%-- <security:authorize access="authenticated">
		<p>
			<a href="<c:url value='/logout' />">Logout</a>
		</p>
	</security:authorize>

	<p>Copyright &copy; 2016, Chengyu Sun. All rights reserved.</p> --%>

</body>
</html>
