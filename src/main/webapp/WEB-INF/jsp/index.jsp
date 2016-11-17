<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<!-- <script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script> -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
		var x = ${complete};
		var y = ${remaining};
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Counts'],
          ['Completed Task', x],
          ['Ongoing Task',  y]]);

        var options = {
          title: 'Workload'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>



<title>SpiderHub</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<div class="container">
		
		<jsp:include page="/WEB-INF/jsp/menu.jsp" />
		<div class="jumbotron">
			<h1>SpiderHub</h1>
			<p class="lead">Competition makes us faster, Collaboration makes
				us Better.</p>
			<p>
			
				<security:authorize access="anonymous">
					<a class="btn btn-lg btn-success" href="userRegistration.html"
						role="button">Sign up today</a>
				</security:authorize>
			</p>
		</div>
		<security:authorize access="hasRole('MEMBER')">
			<div id="piechart" style="width: 500px; height: 300px"></div>
			
		</security:authorize>
		

		<!-- <footer class="footer">
			<p>&copy; SpiderHub Company, Inc.</p>
		</footer> -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
