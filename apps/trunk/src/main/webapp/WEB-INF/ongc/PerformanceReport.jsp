<c:if test="${user.hasRole('ROLE_MNGR')}">
	<div id="performanceReportDiv">
		<table id="performanceReportTable" style="width: 100%;">
			<thead>
				<tr>
					<th>CPF No</th>
					<th>Player Name</th>
					<th>Tournament Name</th>
					<th>Tournament Date</th>
					<th>Venue</th>
					<th>Rank/Score</th>
					<th>Remarks</th>
				</tr>
			</thead>
		</table>
	</div>
</c:if>