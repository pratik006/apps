<script>
$(function() {	   
   $("#tmtDate").datepicker({
   	dateFormat: 'dd-M-yy',
   });
   $("#tmtEndDate").datepicker({
	   	dateFormat: 'dd-M-yy',
	   });
 });
 
</script>

<form id="addPerformanceForm" method="post">
		<table id="addPerfromanceTable">
			<%-- <tr>
				<td>First Name:</td>
				<td><input id="name" type="text" name="name" value="${user.firstName}" readonly="readonly"/></td>
				<td></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input id="name" type="text" name="name" value="${user.lastName}" readonly="readonly"/></td>
				<td></td>
			</tr>
			<tr>
				<td>CPF No:</td>
				<td><input id="cpfNo" type="text" name="cpfNo" value="${user.userId}" readonly="readonly"/></td>
				<td></td>
			</tr> --%>
			<tr>
				<td>Tournament Name:</td>
				<td><input type="text" id="tmtName" name="tmtName" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Tournament Start Date:</td>
				<td><input type="text" id="tmtDate" name="tmtDate" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Tournament End Date:</td>
				<td><input type="text" id="tmtEndDate" name="tmtEndDate" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Venue:</td>
				<td><input type="text" id="venue" name="venue" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Rank:</td>
				<td><input type="text" id="rank" name="rank" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Score:</td>
				<td><input type="text" id="score" name="score" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Remarks:</td>
				<td><textarea id="remarks" name="remarks" ></textarea></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button id="update" onclick="submitForm('addPerformanceForm')">Update</button>
					<input type="reset" value="Reset" onclick="this.form.reset();" />
				</td>
				<td></td>
			</tr>
		</table>
	</form>