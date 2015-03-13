<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="playerDetailView" style="width: 80%;" onload="load();">
<c:set var="player" value="${response.context['userInfo']}" />
	<table id="performanceReportTableForUser" style="width: 100%;" class="display">
		<tr>
			<td>Name:</td>
			<td>${player.firstName} ${player.lastName}</td>
			<td>CPF No:</td>
			<td>${player.userName}</td>
			<td>Designation:</td>
			<td>${player.attributes['DESIGNATION']}</td>
		</tr>
		<tr>
			<td>Date Of Birth:</td>
			<td>${player.attributes['DOB']}</td>
			<td>Date of Joining:</td>
			<td>${player.attributes['DOJ']}</td>
			<td>Educational Qualification:</td>
			<td>${player.attributes['EDU_QUAL']}</td>
		</tr>
	</table>
<div style="margin-top: 60px;">
	<table id="tmtDetails" style="width: 100%;">
		<thead>
			<tr>
				<th>Tournament Name</th>
				<th>Tournament Date</th>
				<th>Tournament Emd Date</th>
				<th>Venue</th>
				<th>Rank/Score</th>
				<th>Remarks</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${response.context['playerPerformances']}" var="performance">
				<tr>
					<td>${performance.tmtName}</td>
					<td>${performance.tmtDate}</td>
					<td>${performance.tmtEndDate}</td>
					<td>${performance.venue}</td>
					<td>${performance.rank}/${performance.score}</td>
					<td>${performance.remarks}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<button id="btnCloseTab${player.userName}" style="margin-top: 10px;">Close</button>
</div>