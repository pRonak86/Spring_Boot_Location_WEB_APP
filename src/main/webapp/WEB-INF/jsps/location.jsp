<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Locations</title>
</head>
<body>
	<h1>Registration Form</h1>
	<form action="saveLoc" method="post">
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Code</td>
				<td><input type="text" name="code"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Type</td>
				<td>Urban <input type="radio" name="type" value="Urban"> Rural <input
					type="radio" name="type" value="Rural">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
	${msg }
	
	<a href="displayLocations">View All</a>
</body>
</html>