<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new medicine</title>
</head>
<body>
	<form action="Controller" method="GET">
		<input type="hidden" name="del" value ="DEL"/>
		<table>
			<tr>
			<td><label>Item ID: </label></td>
			<td><input type="text" name="id"></td>
			</tr>
			<tr>
			<td><input type="submit" name="Remove"></td>
			</tr>
		</table>
	</form>
	
	<a href="Controller">Back to database</a>
</body>
</html>