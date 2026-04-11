<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>delete operation</h3>
	<form action="DeleteServlet" method="post">
		<table>
			<tr>
				<td>Book ID*</td>
				<td><input type="text" name="T1" /> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Delete" /></td>
			</tr>
		</table>
	</form>
</body>
</html>