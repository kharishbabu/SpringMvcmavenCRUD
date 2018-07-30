

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
      	
 
<script>
 function cancel()
       {
	 window.location.href="home2.html";
       }
 </script>
  <script type="text/javascript">
    function doSearch(value){
    	var f1=$('#ss').searchbox('getValue');

    	if(f1=="")
    		{
    		alert('Please enter value in search box');
    		}
        $('#dg').datagrid({
        	url:"search1.html?value="+value
        });
         }
    </script>
<script>
 function delll()
       {
    
       var row = $('#dg').datagrid('getSelected');
       
       if(row)
       {
    	 
         
      	
      	  $.messager.confirm('My Title', 'Are you sure you want to delete this record?', function(r){
              if (r){
            	  
          window.location.href="del.html?id="+row.id;

            	  
              }
          });
       }
       else
    	   {
           $.messager.alert('Warning','Please select atleast one row!');
    	   }
}
      

 </script>
 <script>
 $('#t_' + $.jgrid.jqID($grid[0].id))
    .append($("<div><label for=\"globalSearchText\">Global search in grid for:&nbsp;" +
        "</label><input id=\"globalSearchText\" type=\"text\"></input>&nbsp;" +
        "<button id=\"globalSearch\" type=\"button\">Search</button></div>"));
 </script>

 
    <script>
    function betweendate()
	{

	var fd=$('#from').datebox('getValue');
	var td=$('#to').datebox('getValue');
	
	if(new Date(fd)>new Date(td))
	{
		alert('From date is Greater than to date');
	}
	else if(new Date(fd)>new Date())
		{
		alert('From date Should not allow future date');

		}
	else if(new Date(fd)<=new Date(td))
	{
		
		$('#dg').datagrid({
	url:'betweendates.html?fd='+fd+'&td='+td
	});
	}
	
	}
    </script>
 <title>Registration</title>
</head>
<body bgcolor="pink">

<div style="padding-top:100px;margin-top:-100px;font-family:timesnewroman">
<h1 align="center"><font color="deeppink">Admin Details</font></h1>

  <center>
  
 <!-- Search Customer:<input class="easyui-searchbox" id="ss" data-options="prompt:'Search customer id',searcher:doSearch" style="width:100px"></input>
<input type="button" value="Refresh" onclick='window.location.href="customerdetails.html"'>
 From Date: <input class="easyui-datebox" id="from" style="width:100px" data-options="onSelect:betweendate,editable:false">&nbsp;&nbsp;
  To Date: <input class="easyui-datebox" id="to" style="width:100px" data-options="onSelect:betweendate,editable:false">&nbsp;&nbsp; -->
    <table id="dg" class="easyui-datagrid" title="Customer Details" style="width:900px;height:300px"  pagination="true"
           data-options="singleSelect:true,onDblClickRow:function(index,row){editbook();},collapsible:true,url:'adminlist',method:'get'">
         
         <thead>  <tr>
<tr>
            <th align="center" data-options="field:'sid',width:80"><font color="blue"><i><b>Customer Id</b></i></font></th>
                
                 <th align="center" data-options="field:'firstname',width:80"><font color="blue"><i><b>Firstname</b></i></font></th>
                  <th align="center" data-options="field:'middlename',width:80"><font color="blue"><i><b>Middlename</b></i></font></th>
                 <th align="center" data-options="field:'lastname',width:80"><font color="blue"><i><b> Lastname</b></i></font></th>
                 <th align="center" data-options="field:'username',width:80"><font color="blue"><i><b> Username</b></i></font></th>
                  <th align="center" data-options="field:'gender',width:60"><font color="blue"><i><b> Gender</b></i></font></th>
                  <th align="center" data-options="field:'DOB',width:80"><font color="blue"><i><b> Date of birth </b></i></font></th>
                <th align="center" data-options="field:'email',width:150"><font color="blue"><i><b> Email</b></i></font></th>
                 <th align="center" data-options="field:'phnum',width:100"><font color="blue"><i><b> Phone number </b></i></font></th>
                 <th align="center" data-options="field:'country',width:80"><font color="blue"><i><b> Country</b></i></font></th>
                 <th align="center" data-options="field:'state',width:60"><font color="blue"><i><b> State</b></i></font></th>
                  <th align="center" data-options="field:'city',width:60"><font color="blue"><i><b> City</b></i></font></th>
                 
                 <th align="center" data-options="field:'address',width:80"><font color="blue"><i><b> Address</b></i></font></th>
                 <th align="center" data-options="field:'zipcode',width:70"><font color="blue"><i><b> Pincode</b></i></font></th>
                 <th align="center" data-options="field:'languages',width:100"><font color="blue"><i><b> Languages</b></i></font></th>
                 
                 
            </tr>
            	
            	
	      
	        </thead> 
    </table></center>
  <div style="margin:20px 0;"  align="center">
   <a href="#" class="easyui-linkbutton" iconCls="icon-update" plain="true" onclick="edit()" value="edit">Edit</a> 
   <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delll()" value="del">Delete</a> 
<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="cancel()" value="cancel">Cancel</a> 


      
      
       </div>
    </div>  
</body>
</html>