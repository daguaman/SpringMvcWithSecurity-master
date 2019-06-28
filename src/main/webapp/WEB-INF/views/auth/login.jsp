<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/styles.css" />
<title>Login</title>
</head>


<body>
	<div id="horizon">
		<div id="content">
			<div id="loginBox">
				<form id="loginForm" action="j_spring_security_check" method="post">
					<fieldset id="body">
						<fieldset>
							<label for="email">Email Address</label> <input type="text"
								 id="email" name="j_username">
						</fieldset>
						<fieldset>
							<label for="password">Password</label> <input type="password"
								 id="password" name="j_password">
						</fieldset>
						<input type="submit" id="login" name="Login" value="Sign in">
						<label for="checkbox"> <input type="checkbox"
							id="checkbox" name="_spring_security_remember_me">Remember
							me
						</label>
					</fieldset>
					<span><p class="message">${message}</p></span>
				</form>
			</div>
		</div>
	</div>
</body>

<%-- 	<form action="j_spring_security_check" method="post"> --%>
<!-- 		<label>Email:</label> -->
<!-- 		<input type="text" name="j_username" /> -->
<!-- 		<label>Password:</label> -->
<!-- 		<input type="password" name="j_password" /> -->
<!-- 		<input type="submit" value="Submit" name="Login" class="login" /> -->
<%-- 	</form>	 --%>
<%-- 	<p class="message">${message}</p> --%>
</html>