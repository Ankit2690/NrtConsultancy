<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compose</title>
<link rel="stylesheet" type="text/css" href="css/compose_email.css">
</head>
<body>

		<h2>Compose Email</h2>
		${msg} <br>
		${sms}
		<form action="sendEmail" method="post">
		<pre>
					<input type="hidden" name="id" value="${id}"/>
				   <input type="hidden" name="phone" value="${phone}"/>
			To     <input type="text" name="to" value="${email}"/>
			Subject<input type="text" name="sub"/>
			<textarea name="msg" rows="10" cols="50"></textarea>
			<input type="submit" value="send"/>
		</pre>
		</form>
</body>
</html>