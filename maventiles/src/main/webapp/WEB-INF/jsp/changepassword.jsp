<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form  action="changss.html" commandName="command" >
<center><h3>Change Password</h3></center>
<table align="center">

<tr><td>Old Password:</td><td><form:password path="oldpassword"/><td style="color:red"><form:errors path="oldpassword"></form:errors></td></tr>

<tr><td>New Password:</td><td><form:password path="password"/><td style="color:red"><form:errors path="password"></form:errors></td></tr>

<tr><td>Confirm Password:</td><td><form:password path="confirmpassword"/><td style="color:red"><form:errors path="confirmpassword"></form:errors></td></tr>

<tr><td></td><td><input type="submit" name="save" value="Submit"/><input type="button" value="Cancel" onclick='window.location.href="home1"'/>

</td></tr>

</table>

</form:form>

</body>
</html>