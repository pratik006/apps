<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../resources/css/tutorials/style.css">
<style type="text/css">
body, textarea {
	font-family: sans-serif;
	font-size: 12px;
}
</style>
<style type="text/css" title="currentStyle">
	@import "../resources/css/cupertino/jquery-ui-1.10.3.custom.css";
	@import "../resources/js/rte/jquery.rte.css";
</style>
<script type="text/javascript" src="../resources/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../resources/js/rte/jquery.rte.js"></script>
<script type="text/javascript" src="../resources/js/rte/jquery.rte.tb.js"></script>
<script type="text/javascript" src="../resources/js/rte/jquery.ocupload-1.1.4.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui-1.10.3.custom.js"></script>

<title>Create Page</title>
</head>

<body>

	<div id="main" style="width: 800px;">
		<form id="rteForm">
			<textarea id="rte1" style="width: 90%; height: 80%;" name="form[info1]" rows="50" class="rte1"></textarea>
			<button title="submit">submit</button>
		</form>

		<script type="text/javascript">
			
			$(function() {
				$(":button, :input[type=submit], :input[type=reset]").button().click(function(event) {
					event.preventDefault();
					submitForm();
				});
				
				var arr = $('.rte1').rte({
					css : [ 'default.css' ],
					controls_rte : rte_toolbar,
					controls_html : html_toolbar
				});

				$('.rte2').rte({
					css : [ 'default.css' ],
					width : 450,
					height : 200,
					controls_rte : rte_toolbar,
					controls_html : html_toolbar
				}, arr);
				
			});
			function submitForm() {				
				var data = getContent();
				console.log('before: '+data);
				$.ajax({
					url: "../json/tutorials/createPage?action=hibernate",
			        type: 'POST',
			        data: data,
					dataType : 'json',
					async: true,
					success : function(state) {
						console.log(state);
					}
				});
			}
			
			function getContent(){
				return $("#rte1").contents().find("body").html()
				}
			
		</script>
	</div>
	<hr>
</body>
</html>