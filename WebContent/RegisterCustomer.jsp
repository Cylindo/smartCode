<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Customer</title>
</head>
<body>
<h2 align = "center">Customer Details...</h2>

<form  action="http://localhost:8080/RESTfulKnockout/api/RESTCustomer/register" method="POST">
<table>

<tr>
<td>Name</td> <td><input type="text" name="name" /></td>
</tr>

<tr>
<td>Surname</td>  <td><input type="text"  name="surname"/></td>
</tr>
<tr>
<td>Gender</td>  <td><input type="text"  name="gender"/></td>
</tr>
<tr>
<td>Address</td>  <td><input type="text"  name="adress"/></td>
</tr>
<tr>
<td>Password</td>  <td><input type="password"  name="password"/></td>
</tr>
<tr>
<td>Telephone Number</td>  <td><input type="text"  name="telephone"/></td>
</tr>


<tr><td><input type="submit" value="Register" /></td> <td><input type="submit" value="Register"/></td></tr>
</table>
</form>
</body>
</html>