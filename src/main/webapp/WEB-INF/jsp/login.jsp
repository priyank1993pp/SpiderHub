<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SpiderHub Login</title>
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
			<form action="login" method="post">
				<fieldset class="step">
					<legend>Login</legend>
					<p>
						<label for="username">Username: </label> <input type="text"
							name="username" id="username" />
					</p>
					<p>
						<label for="password">Password: </label> <input type="password"
							name="password" id="password" />

					</p>
					<p>
						<label for="rememberMe">Remember Me:</label> <input
							type="checkbox" name="rememberMe" id="rememberMe" />
					</p>
					<p class="center">
						<a href='userRegistration.html'>Sign Up</a> -or- <input
							type="submit" name="login" value="Login" />
					</p>

				</fieldset>

			</form>
		</div>
	</div>
</body>
</html>
