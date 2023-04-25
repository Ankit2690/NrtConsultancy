<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Of The Person</title>
<link rel="stylesheet" type="text/css" href="css/person.css">
</head>
<body>
			<h2>Enter Details Of The Person </h2>
			<form action="savePerson" method="post">
			<pre>
			  Name<input type="text" name="name"/>
			 Email<input type="text" name="email"/>
			 Phone<input type="text" name="phone"/>
			      <input type="submit" value="save"/>
			</pre>
			</form>
</body>
</html>