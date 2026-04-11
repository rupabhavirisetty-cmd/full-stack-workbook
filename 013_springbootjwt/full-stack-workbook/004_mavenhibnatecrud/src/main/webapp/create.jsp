<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Insert operation</h3>
<form action = "CreateServlet" method="post">
	<table>
		<tr>
			<td>Book ID</td>
			<td><input type="text" name="T1"/></td>
		</tr>
		<tr>
			<td>Book Title</td>
			<td><input type="text" name="T2"/></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><input type="text" name="T3"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="save"/></td>
		</tr>
	</table>
</form>
</body>
</html>