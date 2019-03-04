<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new medicine</title>
</head>
<body>
	<form action="Controller" method="get">
		<input type="hidden" name="add" value ="ADD"/>
		<table>
			<tr>
			<td><label>Item Name: </label></td>
			<td><input type="text" name="medicine"></td>
			</tr>
			<tr>
			<td><label>Manufactured on: </label></td>
			<td><input type="text" name="mfg"></td>
			</tr>
			<tr>
			<td><label>Will Expire on: </label></td>
			<td><input type="text" name="exp"></td>
			</tr>
			<td><label>Cost (INR): </label></td>
			<td><input type="text" name="cost"></td>
			<tr>
			<td><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form>
	
	<a href="Controller">Back to database</a>
</body>
</html>