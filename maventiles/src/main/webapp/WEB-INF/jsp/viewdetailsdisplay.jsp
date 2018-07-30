<%-- 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="index.jsp"> 
<jsp:param name="parametername" value="parametervalue" /> 
</jsp:include> 

<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Details</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
<head>
   
    </head>
     <script>
    function call()
    {
    	var e=0;
        var e1=0;

        var a= document.getElementsByName("cbox");
        
        alert(a);
        var length=a.length;
        
        for(var i=0;i<a.length;i++)
        {
         if(a[i].checked == true )
         {
        	 e++;
        	 e1=a[i].value;
          }
        }
        //alert("eeeeeeeee  :"+e);
         if(e == '1')
         {
         window.location.href ="del";
         }
         else
        alert("Please Select One Check Box.");  
         return false;
        }
    </script>
        <body>
       <h1 align="center">Admin Details</h1>
		<form action="displayedit">
        <display:table id="dis" name="sessionScope.adminlist" pagesize="5">
        <display:setProperty name="paging.banner.onepage" value=""></display:setProperty>
          <display:column  title="Choose" ><input type="checkbox" id="cbox" name="cbox" value="${dis.username}"/></display:column>
            <display:column  title="Choose" ><input type="text" id="status" name="status" value="${dis.status}" /></display:column>
           <display:column property="firstname" title="Firstname" sortable="true"/>
            <display:column property="middlename" title="Middlename" sortable="true"/>
            <display:column property="lastname" title="Lastname" sortable="true"/>
            <display:column property="username" title="Username" sortable="true"/>
            <display:column property="password" title="Password" sortable="true"/>
            <display:column property="confirmpassword" title="Confirm Password" sortable="true"/>
            <display:column property="email" title="Email id" sortable="true"/>
            <display:column property="phnum" title="Phonenumber" sortable="true"/>
           
              <display:column property="DOB" title="Date Of Birth" sortable="true"/>
                 <display:column property="gender" title="Gender" sortable="true"/>
           <display:column property="address" title="Address" sortable="true"/>
           <display:column property="zipcode" title="Pincode" sortable="true"/>
           <display:column property="country" title="Country" sortable="true"/>
           <display:column property="state" title="State" sortable="true"/>
           <display:column property="languages" title="Languages Known" sortable="true"/>
        </display:table>

       <input type="Submit" value="Edit" name="method" >
              <input type="button" value="Delete"  onclick="call()">
       </form> </body>
        </html> --%>
        
        
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>

<form:form action="viewevent.html" commandName="command"> 
<center>
<form:hidden path="status"/>
<form:hidden path="type"/>
<br><br><br><br><br><br><br><br>
<h1><u><font color="#FF1493">User Details</font></u></h1>
<table border="1" style="width:1000px">
<tr>
<th><font color="blue">Firstname</font></th>
<th><font color="blue">Middlename</font></th>
<th><font color="blue">Lastname</font></th>
<th><font color="blue">Username</font></th>
<th><font color="blue">Password</font></th>
<th><font color="blue">Confirm Password</font></th>
<th><font color="blue">Email Id</font></th>
<th><font color="blue">Phone Number</font></th>
<th><font color="blue">Gender</font></th>
<th><font color="blue">Date Of Birth</font></th>
<th><font color="blue">Country</font></th>
<th><font color="blue">State</font></th>
<th><font color="blue">Languages</font></th>
</tr>
<c:forEach var="dis" items="${adminlist}">
<tr style="text-align:center">
<td >${dis.firstname}</td>
<td>${dis.middlename}</td>
<td>${dis.lastname}</td>
<td>${dis.username}</td>
<td>${dis.password}</td>
<td>${dis.confirmpassword}</td>
<td>${dis.email}</td>
<td>${dis.phnum}</td>
<td>${dis.gender}</td>
<td>${dis.DOB}</td>
<td>${dis.country}</td>
<td>${dis.state}</td>
<td>${dis.languages}</td>
<td><a href="displayedit?cbox=${dis.username}">Edit</a>
<td><a href="del?cbox=${dis.username}">Delete</a>
</tr>
</c:forEach>
</table>
</center></form:form>
</body></html>







