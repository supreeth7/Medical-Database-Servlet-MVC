
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medical Database</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="top">
		<div id="header">
			<h2>Medical Database</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<input type="button" value="Add Medicine"
				onclick="window.location.href='add-form.jsp'" ;class="add-button">
			&nbsp;
			<input type="button" value="Delete Medicine"
				onclick="window.location.href='del-form.jsp'" ;class="add-button">
			<table>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>MFG.</th>
					<th>EXP.</th>
					<th>COST</th>
				</tr>

				<c:forEach var="temp" items="${MEDICINES}">
					<tr>
						<td>${temp.id}</td>
						<td>${temp.name}</td>
						<td>${temp.manu}</td>
						<td>${temp.expr}</td>
						<td>${temp.price}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<style>
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: #0775d3;
	color: #FFFFFF;
	text-align: center;
}
</style>

	<div class="footer">
		<p>Developed by Aakash, Deepika, Nirali, Prajwal and Supreeth<br>Jain University - 2019</p>
	</div>
</body>
</html>