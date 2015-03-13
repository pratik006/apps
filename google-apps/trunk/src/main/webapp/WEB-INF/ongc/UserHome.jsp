<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Performance Report</title>
<style type="text/css" title="currentStyle">
@import "../resources/css/cupertino/jquery-ui-1.10.3.custom.css";
@import "../resources/js/rte/jquery.rte.css";
.dataTables_length {
	float: left;
}
.dataTables_filter {
	float: right;
}
tr:nth-of-type(even) {
    background: #D9DEE2;
}
</style>
<script type="text/javascript" src="../resources/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../resources/js/rte/jquery.rte.js"></script>
<script type="text/javascript" src="../resources/js/rte/jquery.rte.tb.js"></script>
<script type="text/javascript" src="../resources/js/rte/jquery.ocupload-1.1.4.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui-1.10.3.custom.js"></script>
<script src="../resources/js/DataTables-1.10.3/media/js/jquery.dataTables.js" type="text/javascript"></script>
<script src="../resources/js/jquery.dataTables.columnFilter.js" type="text/javascript"></script>
<script src="../resources/js/ongc/ongcScripts.js" type="text/javascript"></script>
<script src="../resources/js/app.js" type="text/javascript"></script>
</head>
<body style="width: 80%; margin-left: auto; margin-right: auto; font-size: 14px;" onload="loadUser(${user.userName})">
	<div style="background-color: #d9dee2;">
		<table style="width: 100%; background-color: #d9dee2;">
			<tr style="background-color: #d9dee2;">
				<td><div style="font-size: 20px;">Welcome ${sessionScope["user"].firstName} ${sessionScope["user"].lastName}</div></td>
				<td style="text-align: right;">
					<p id="logoutTag" style="height: 75%; cursor: pointer; color: blue;">Logout</p>
				</td>
			</tr>
		</table>
	</div>
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">Performance</a></li>
			<c:if test="${user.hasRole('ROLE_MNGR')}"><li><a href="#tabs-2">Performance Report</a></li></c:if>
		</ul>

		<div id="tabs-1">
			<jsp:include page="./PersonalDetail.jsp"></jsp:include>
			<table id="playerPerformance" style="width: 100%;">
				<thead>
					<tr>
						<th>Tournament Name</th>
						<th>Tournament Date</th>
						<th>Venue</th>
						<th>Rank/Score</th>
						<th>Remarks</th>
					</tr>
				</thead>
			</table>
			<button id="addPerformance">Add Performance</button>
			<button id="reload">Reload</button>
			<div id="addPerformanceDialog" title="Add Performance"><jsp:include page="./AddPerformance.jsp"></jsp:include></div>
			<div id="userDetailDialog" title="User Details"><jsp:include page="./UserDetail.jsp"></jsp:include></div>
		</div>
		<c:if test="${user.hasRole('ROLE_MNGR')}">
		<div id="tabs-2">
			<jsp:include page="Participants.jsp"></jsp:include>			
		</div>
		</c:if>
	</div>

</body>
</html>