<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Maven Tiles</title>
</head>
<body>
<table border="1" cellpadding="2px" cellspacing="2px" height="100px">

<tr><td height="50px" width="1700px" colspan="2" bgcolor="white">
<tiles:insertAttribute name="header"></tiles:insertAttribute>
</td></tr>

<tr><td height="50px" width="1700px" colspan="2">
<tiles:insertAttribute name="menu"></tiles:insertAttribute>
</td></tr>




<tr><td height="700px" width="400px" colspan="2" bgcolor="skyblue">
<tiles:insertAttribute name="body"></tiles:insertAttribute>
</td></tr>

<tr><td height="70px" width="1700px" colspan="2" bgcolor="A20DC1">
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</td></tr>

</table>
</body>
</html>