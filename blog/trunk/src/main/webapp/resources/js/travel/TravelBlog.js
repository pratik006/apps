$(function() {
	$("#submitComment").click(function(event) {
		event.preventDefault();
		saveComment(1);
	});
	
	 $( "#galleria" ).dialog({
		 autoOpen: false,
		 height: "600",
		 width: "600",
		 position: { my: "center", at: "top", of: window },
		 show: {
		 effect: "blind",
		 duration: 1000
		 },
		 hide: {
		 effect: "explode",
		 duration: 1000
		 }
	});
	loadAllComments(1);
});


function saveComment(blogId) {
	var travelComment = new Object();
	travelComment.name=$("#commentForm").find("#name").val();
	travelComment.email=$("#commentForm").find("#email").val();
	travelComment.title=$("#commentForm").find("#title").val();
	travelComment.comment=$("#commentForm").find("#comment").val();
	
	var data = JSON.stringify(travelComment);
	console.log('before: ' + data);
	$.ajax({
		url : "/travel/save/"+blogId,
		type : 'POST',
		data : data,
		//dataType : 'json',
		contentType : "application/json",
		async : true,
		success : function(state) {
			console.log("state: "+state);
			$("#commentForm")[0].reset();
			loadAllComments(blogId);
		},
		 error:function() { 
             alert("error");
        }
	});
}

function loadAllComments(blogId) {
	console.log('loadAllComments');
	$.ajax({
		url : "/travel/load/"+blogId,
		type : 'GET',
		//data : data,
		dataType : 'json',
		contentType : "application/json",
		async : true,
		success : function(comments) {
			var htmlRows = '';
			for(var i=0;i<comments.length;i++) {
				//console.log(comments[i]);
				comments[i].time = new Date(comments[i].time);
				htmlRows += '<tr><td>'+comments[i].email+' &nbsp;&nbsp; '+comments[i].time+'</td></tr>'+'<tr><td><b>'+comments[i].title+'</b>: '+comments[i].comment+'</td></tr>';
			}
			$('#commentsBody').fadeOut('slow').html(htmlRows).fadeIn("slow");
		}
	});
}

function initGallery() {
	var data = [
			{
				image : "https://lh4.googleusercontent.com/-yCAp4_l9s-g/VLzqg9btfTI/AAAAAAAABlg/OTjJ934B1Nw/w1190-h894-no/100_8251.JPG"
			},
			{
				image : "https://lh3.googleusercontent.com/wSnOIZjlsIv-G_C04ztlZWSBQbml47obyP5D-aFAQu4=w1192-h894-no"
			},
			{
				image : "https://lh4.googleusercontent.com/-O1eJSqtsWec/VMAOivLKAcI/AAAAAAAABys/3Ha435626bM/w1192-h894-no/DSCN0374-SMILE.jpg"
			},
			{
				image : "https://lh3.googleusercontent.com/-mJqX63jk-Co/VL01hqQuKOI/AAAAAAAABrw/pTf-flT6Dcw/w1192-h894-no/IMG_20150118_072824.jpg"
			},
			{
				image : "https://lh4.googleusercontent.com/-EbXIW0SKHoY/VMFO10GggvI/AAAAAAAAB5Q/BbVcju0UK98/w1341-h894-no/Fire.jpg"
			},
			{
				image : "https://lh6.googleusercontent.com/-vQcFI-yTuUc/VMAPV_6djmI/AAAAAAAABzI/6dj9e6qwHkM/w1192-h894-no/DSCN0453.JPG"
			},
			{
				image : "https://lh3.googleusercontent.com/-nfCDDmix4tg/VMPmOdYO-jI/AAAAAAAAB-g/exMKTo-jrQc/w1273-h848-no/Nilanjan.jpg"
			},
			{
				image : "https://lh5.googleusercontent.com/ZcYqVI59PQdBEuXE3OclsU4U5bKOmircPAGj66dDpmY=w1192-h894-no"
			},
			{
				image : "https://lh5.googleusercontent.com/aGib574rbZIJ1kfsrP6CYTQztu8-DYZ80bJSdi0lVb0=w1192-h894-no"
			},
			{
				image : "https://lh5.googleusercontent.com/-Bj3FBwoJL2U/VMAIYHsjL2I/AAAAAAAABwo/sCoVzQeiSkw/w1192-h894-no/DSCN0281.JPG"
			},
			{
				image : "https://lh4.googleusercontent.com/-yCAp4_l9s-g/VLzqg9btfTI/AAAAAAAABlg/OTjJ934B1Nw/w1190-h894-no/100_8251.JPG"
			},
			{
				image : "https://lh3.googleusercontent.com/wSnOIZjlsIv-G_C04ztlZWSBQbml47obyP5D-aFAQu4=w1192-h894-no"
			},
			{
				image : "https://lh3.googleusercontent.com/-EbXIW0SKHoY/VMFO10GggvI/AAAAAAAAB5Q/BbVcju0UK98/w1001-h667-no/Fire.jpg"
			},
			{
				image : "https://lh3.googleusercontent.com/-1xLpF6yq9Yw/VMFQQfB4nZI/AAAAAAAAB5c/SyZXnM4Nq8w/w1001-h667-no/House.jpg"
			},
			
			];
	$("#galleria").dialog("open");
	Galleria.loadTheme('/resources/galleria/themes/classic/galleria.classic.min.js');
	Galleria.run('#galleria', {
		dataSource : data,
	});

}