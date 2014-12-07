var DEF_PACKET_WIDTH = 400;
$(function() {
	$("#tabs").tabs({/*collapsible: true*/});
	
	$(":button, :input[type=submit], :input[type=reset]").button().click(function(event) {
		event.preventDefault();
	});
	initDataTables();

	$("#addPerformanceDialog").dialog({
		width : DEF_PACKET_WIDTH,
		autoOpen : false,
		show : {
			effect : "blind",
			duration : 1000
		},
		hide : {
			effect : "explode",
			duration : 1000
		},
	});

	$("#userDetailDialog").dialog({
		width : 300,
		autoOpen : false,
		show : {
			effect : "blind",
			duration : 1000
		},
		hide : {
			effect : "explode",
			duration : 1000
		}
	});
	$("#removePacket").click(function() {
		$("#issuePacketDialog").dialog("open");
	});
	$("#addPerformance").click(function() {
		$("#addPerformanceDialog").dialog("open");
	});
	$("#showPersonalDetail").click(function() {
		$("#userDetailDialog").dialog("open");
	});
	$('#logoutTag').on('click', function() {
		location.href = '../j_spring_security_logout';
	});
	$("#reload").click(function() {
		$("#playerPerformance").dataTable().fnReloadAjax();
	});
});

function addNewTab(userId) {
	var targetUser = getUserInfo(userId);
	console.log(targetUser);
	var num_tabs = $("div#tabs ul li").length + 1;
	$("div#tabs ul").append("<li><a href='#tabs-" + num_tabs + "'>" + targetUser.firstName+' '+targetUser.lastName + "</a></li>");
	$("div#tabs").append("<div id='tabs-" + num_tabs + "'>" +"</div>");
	
	$("#tabs-"+num_tabs).load('./playerDetail?action=getUser&userName='+targetUser.userName, "#tabs-"+num_tabs, function(){
			console.log('here');			
			console.log(targetUser.userName);
			$('#btnCloseTab'+targetUser.userName).button();
			$('#btnCloseTab'+targetUser.userName).click(function() {
					$( "#tabs" ).find('.ui-tabs-nav li:eq('+(num_tabs-1)+')' ).remove();
					$("#tabs").tabs("refresh");
				});
			$('#tmtDetails').DataTable({"bJQueryUI" : true});
				
			}
	);	
	$("div#tabs").tabs("refresh");	
	$( "#tabs" ).tabs( "option", "active", num_tabs-1 );
}

function autoReload() {
	refreshTable('#playerPerformance', "../json/ongc/performance?action=getPerformances");
	setTimeout(function() {
		autoReload();
	}, 30000);
}

function initDataTables() {
	$('#playerPerformance').dataTable({
		"bJQueryUI" : true,
		"bProcessing" : true,
		"bServerSide" : false,
		"bAutoWidth" : false,
		"sScrollX" : "50%",
		"sScrollXInner" : "100%",
		"width" : "10px",
		"sAjaxSource" : "../json/ongc/performance?action=getPerformances",
		"aoColumns" : [ /*
						 * { "mData" : "cpfNo", "sWidth" : "10%", },
						 */
		/*
		 * { "mData" : "cpfNo", "mRender": function ( data, type, full ) {
		 * return '<a id="showPersonalDetail"'+data+' style="color: blue;
		 * text-decoration: underline;cursor: pointer;"
		 * onclick="showPersonalInfo('+data+')">'+data+'</a>'; },"sWidth":
		 * "5%", }, { "mData" : "playerName", "sWidth" : "20%", },
		 */{
			"mData" : "tmtName",
			"sWidth" : "30%",
		}, {
			"mData" : "tmtDate",
			"mRender": function(data){
				return strToDate(data);
				//return data.format('dd-mm-yy');
			},
			"sWidth" : "20%",
		}, {
			"mData" : "venue",
			"sWidth" : "30%",
		}, {
			"mData" : "rank",
			"sWidth" : "10%",
		}, {
			"mData" : "remarks",
			"sWidth" : "30%",
		}, /*
			 * { "mData" : "rank", "mRender": function ( data, type, full ) {
			 * return '<button class="issuePacket" style="width: 90%;"
			 * onclick="issuePacket(\''+data+'\', this)">issue</button>'; },
			 * "sWidth": "20%", }
			 */],
	}).columnFilter();

	$('#performanceReportTable')
		.dataTable(
			{
			"bJQueryUI" : true,
			"bProcessing" : true,
			"bServerSide" : false,
			"bAutoWidth" : true,
			"sAjaxSource" : "../json/ongc/performance?action=getPerformances",
			"aoColumns" : [ /*
							 * { "mData" : "cpfNo", "sWidth" :
							 * "10%", },
							 */
				{
					"mData" : "cpfNo",
					"mRender" : function(data, type, full) {
						return '<a id="showPersonalDetail"'
								+ data
								//+ ' style="color: blue; text-decoration: underline;cursor: pointer;" onclick="showPersonalInfo('
								+ ' style="color: blue; text-decoration: underline;cursor: pointer;" onclick="addNewTab('
								+ data + ')">' + data + '</a>';
					},
					"sWidth" : "5%",
				}, {
					"mData" : "playerName",
				}, {
					"mData" : "tmtName",
				}, {
					"mData" : "tmtDate",
				}, {
					"mData" : "venue",
				}, {
					"mData" : "rank",
				}, {
					"mData" : "remarks",
				}, ],
			});
	
	$('#participantsTable').dataTable({
		"bJQueryUI" : true,
		"bProcessing" : true,
		"bServerSide" : false,
		"sAjaxSource" : "../json/ongc/performance?action=getParticipants",
		"aoColumns" : [ 
		    {
			"mData" : "userName",
			"mRender" : function(data, type, full) {
				return '<a id="showPersonalDetail"'+ data+ ' style="color: blue; text-decoration: underline;cursor: pointer;" onclick="addNewTab('
						+ data + ')">' + data + '</a>';
			},
			"sWidth" : "5%",
		},{
			"mData" : "firstName",
			"mRender" : function ( data, type, full ) { 
		        return data+' '+full['lastName'];
		      },
			"sWidth" : "50%",
		}],
	})

	$.ajax({
		url : "../json/ongc/getUserInfo",
		type : 'GET',
		dataType : 'json',
		contentType : "application/json",
		async : true,
		success : function(state) {
			user = state;
			console.log(user);
		}
	});
}

function showPersonalInfo(data) {
	$("#userDetailDialog").dialog("open");
	var user = getUserInfo(data);
	$("#userDetailDialog").find("#firstNameLbl").text(user.firstName);
	$("#userDetailDialog").find("#lastNameLbl").text(user.lastName);
	$("#userDetailDialog").find("#designationLbl").text(user.userAttributes[0].attributeValue);
	$("#userDetailDialog").find("#dateOfBirthLbl").text(user.userAttributes[1].attributeValue);
	$("#userDetailDialog").find("#dateOfJoiningLbl").text(user.userAttributes[2].attributeValue);
	$("#userDetailDialog").find("#eduQualificationLbl").text(user.userAttributes[3].attributeValue);
}

function submitForm(formId) {
	var performance = new Object();
	delete user.attributes;
	performance.user = new Object();
	performance.user.userName = user.userName;
	performance.user.userId = user.userId;
	//performance.cpfNo = user.userName;
	performance.tmtName = $("#addPerformanceForm").find("#tmtName").val();
	var st = $("#addPerformanceForm").find("#tmtDate").val();
	var pattern = /(\d{2})\-(\d{3})\-(\d{2})/;
	var dt = new Date(st.replace(pattern, '$3-$2-$1'));
	performance.tmtDate = dt;
	
	st = $("#addPerformanceForm").find("#tmtEndDate").val();
	pattern = /(\d{2})\-(\d{3	})\-(\d{2})/;
	var dt = new Date(st.replace(pattern, '$3-$2-$1'));
	performance.tmtEndDate = dt;
	
	performance.venue = $("#addPerformanceForm").find("#venue").val();
	performance.rank = $("#addPerformanceForm").find("#rank").val();
	performance.score = $("#addPerformanceForm").find("#score").val();
	performance.remarks = $("#addPerformanceForm").find("#remarks").val();
	var data = JSON.stringify(performance);
	console.log('before: ' + data);
	$.ajax({
		url : "../json/ongc/performance?action=addPerformance",
		type : 'POST',
		data : data,
		dataType : 'json',
		contentType : "application/json",
		async : true,
		success : function(state) {
			console.log(state);
			$('#playerPerformance').dataTable().fnReloadAjax();
			$('#addPerformanceDialog').dialog("close");
			$("#addPerformanceForm").trigger('reset');
		}
	});
}

function getUserInfo(userName) {
	var user;
	$.ajax({
		url : "../json/ongc/performance?action=getUserInfo",
		type : 'POST',
		data : JSON.stringify(userName),
		dataType : 'json',
		contentType : "application/json",
		async : false,
		success : function(response) {
			user = response;
		}
	});
	return user;
}

function loadUser(userName) {
	user = getUserInfo(userName);
}

function strToDate(strDate, pattern) {
	if(pattern !== "") {
		pattern = /(\d{4})\-(\d{2})\-(\d{2})/;
	}
	var dt = new Date(strDate.replace(pattern, '$3-$2-$1'));
	console.log(dt);
	//return dt.format('M jS, Y');
	return strDate.replace(pattern, '$3-$2-$1');
}