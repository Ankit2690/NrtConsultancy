<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Persons</title>
<link rel="stylesheet" type="text/css" href="css/list_persons.css">
</head>
<body>
 <div class="container">
	<h2>List Of Persons</h2>
    <form method="POST" action="compose">
    <label for="selectedOption">Select an option:</label>
    <select id="selectedOption" name="selectedOption">
    	<option value="">--Select--</option>
        <c:forEach var="option" items="${persons}">
            <option value="${option.name}">${option.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Send</button>
</form>
</div>
</body>
</html>
