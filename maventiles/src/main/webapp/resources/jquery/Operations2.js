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
		if(document.getElementById("Edit").disabled==true)
		{
		$.ajax({
				type: 'GET',
				url: 'routesinternalNotes.htm?txt='+value,
				success: function(textStatus) {
					
					$('#inotes').val("");
    				$('#inotes').attr('disabled',true);
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
		else
    	{
    		var row=$('#bookingsintnotes_dg').datagrid('getSelected');
    		if(row){
    		$.ajax({
					type: 'GET',
					url: "./routesupdateInternalnotes.htm?txt="+value+"&id="+row.internalnotesid+"&cdate="+row.inotescreateddate+"&cby="+row.inotescreatedby,
					dataType: 'html',
					success: function(html, textStatus) {
						$('#inotes').val("");
    					$('#inotes').attr('disabled',true);
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
		$('#Cancel').removeAttr('disabled');
	});
	$('#Delete1').click(function(){
		var row2=$('#bookingsintnotes_dg').datagrid('getSelected');
		if(row2)
		{
		$.ajax({
				type: 'GET',
				url: 'routesdelInternalNotes.htm?txt='+row2.internalnotesid,
				success: function(textStatus) {
					
					$('#inotes').val("");
    				$('#inotes').attr('disabled',true);
    					$("#Add").attr("disabled",false);
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
    	$('#inotes').focus();
    	$('#Save').removeAttr('disabled');
    	$('#Cancel').removeAttr('disabled');
    	$('#Add').attr('disabled',true);
    	$('#Delete1').attr('disabled',true);
	});
	$('#Cancel').click(function(){
		$('#Add').removeAttr('disabled');
		$('#inotes').val("");
		$('#inotes').attr('disabled',true);
		$('#Delete1').attr('disabled',true);
		$('#Edit').attr('disabled',true);
		$('#Cancel').attr('disabled',true);
		$('#Save').attr('disabled',true);
	});
});