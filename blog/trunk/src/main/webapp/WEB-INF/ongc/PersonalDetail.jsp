<div id="personalDetailEdit" style="width: 90%;">
	<table style="width: 80%;">
		<tr>
			<td>Name:</td>
			<td>${user.firstName} ${user.lastName}</td>
			<td>CPF No:</td>
			<td>${user.userName}</td>
			<td>Designation:</td>
			<td>${user.attributes['DESIGNATION']}</td>
		</tr>
		<tr>
			<td>Date Of Birth:</td>
			<td>${user.attributes['DOB']}</td>
			<td>Date of Joining:</td>
			<td>${user.attributes['DOJ']}</td>
			<td>Educational Qualification:</td>
			<td>${user.attributes['EDU_QUAL']}</td>
		</tr>
	</table>
</div>