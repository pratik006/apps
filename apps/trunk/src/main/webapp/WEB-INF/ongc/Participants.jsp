<c:if test="${user.hasRole('ROLE_MNGR')}">
	<div id="participantsDiv">
		<table id="participantsTable" style="width: 100%;">
			<thead>
				<tr>
					<th>CPF No</th>
					<th>Player Name</th>
				</tr>
			</thead>
		</table>
	</div>
</c:if>