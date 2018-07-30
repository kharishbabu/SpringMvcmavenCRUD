var gid=0;
function view(notes,value)
{
	gid=value;
	$('#inotes').val(notes);
	$('#Delete1').removeAttr('disabled');
	$('#Edit').removeAttr('disabled');
	$('#Cancel').removeAttr('disabled');
	$('#Add').attr('disabled',true);
}

$(document).ready(function(){
	$('#Save').click(function(){
		
		
		setTimeout(l,1000);
		function l()
		{
		var value=$('#inotes').val();
		if(value=="")
		{
		$.messager.alert('Error',"Please enter notes.",'error');
		 return false;
		}
		if(value!="")
		{
		value=value.trim();
		value=value.replace(/\s+/g,' ');
		$('#inotes').val(value);
		var reg=/^[a-zA-Z ]*$/;
		if(!reg.test(value))
		{
			$.messager.alert('Error',"Notes should be alphabets only.",'error');
			return false;
		}
		}
		if(value.length<4 || value.length>100)
		{
			$.messager.alert('Error',"Notes should be minimum length is 4 and maximum length is 100.",'error');
			return false;
		}
		if(document.getElementById("Edit").disabled==true)
		{
		$.ajax({
				type: 'GET',
				url: 'CBPinternalNotesEdit.htm?txt='+value,
				success: function(textStatus) {
					
					$('#inotes').val("");
    				$('#inotes').attr('disabled',true);
    				$('#Save').attr('disabled',true);
    			    $('#Add').attr('disabled',false);
    				$('#Edit').attr('disabled',true);
    				$('#Delete1').attr('disabled',true);
    				$('#Cancel').attr('disabled',true);
    				$('#bookingsintnotes_dg').datagrid('reload');
				},
			error: function(xhr, textStatus, errorThrown) {
			alert('An error occurred! ' + errorThrown);
			}
		});
		}
		else
    	{
			
    		var row=$('#bookingsintnotes_dg').datagrid('getSelected');
    	
    		if(row){
    			
    		$.ajax({
					type: 'GET',
					url: "CBPupdateInternalnotesEdit.htm?txt="+value+"&id="+row.internalnotesid+"&cdate="+row.inotescreateddate+"&cby="+row.inotescreatedby,
					dataType: 'html',
					success: function(html, textStatus) {
						$('#inotes').val("");
    					$('#inotes').attr('disabled',true);
    					$('#Add').attr('disabled',false);
    					$('#Save').attr('disabled',true);
    					$('#Edit').attr('disabled',true);
    					$('#Delete1').attr('disabled',true);
    					$('#Cancel').attr('disabled',true);
    					$('#bookingsintnotes_dg').datagrid('reload');
					},
				error: function(xhr, textStatus, errorThrown) {
				alert('An error occurred! ' + errorThrown);
				}
			});
		}
		}
		setTimeout(n,500);
		function n()
		{
			
		$('#Add').removeAttr('disabled');
		}
		}
	});
	$('#Add').click(function(){
		$('#inotes').removeAttr('disabled');
		$('#Save').removeAttr('disabled');
	    $('#Add').attr('disabled',true);
		$('#Cancel').removeAttr('disabled');
	});
	$('#Delete1').click(function(){
		var row2=$('#bookingsintnotes_dg').datagrid('getSelected');
		if(row2)
		{
		$.ajax({
				type: 'GET',
				url: 'CBPdelInternalNotes.htm?txt='+row2.internalnotesid,
				success: function(textStatus) {
					
					$('#inotes').val("");
    				$('#inotes').attr('disabled',true);
    				$('#Add').attr('disabled',false);
    				$('#Save').attr('disabled',true);
    				$('#Edit').attr('disabled',true);
    				$('#Delete1').attr('disabled',true);
    				$('#Cancel').attr('disabled',true);
    				$('#bookingsintnotes_dg').datagrid('reload');
				},
			error: function(xhr, textStatus, errorThrown) {
			alert('An error occurred! ' + errorThrown);
			}
		});
		}
	});
	$('#Edit').click(function(){
		var value=$('#inotes').val();
    	$('#inotes').removeAttr('disabled');
    	$('#Add').attr('disabled',false);
    	$('#inotes').focus();
    	$('#Save').removeAttr('disabled');
    	$('#Cancel').removeAttr('disabled');
    	//$('#Edit').attr('disabled',true);
    	$('#Add').attr('disabled',true);
    	$('#Delete1').attr('disabled',true);
	});
	$('#Cancel').click(function(){
		$('#Add').removeAttr('disabled');
		$('#Add').attr('disabled',false);
		$('#inotes').val("");
		$('#inotes').attr('disabled',true);
		$('#Delete1').attr('disabled',true);
		$('#Edit').attr('disabled',true);
		$('#Cancel').attr('disabled',true);
		$('#Save').attr('disabled',true);
	});
});