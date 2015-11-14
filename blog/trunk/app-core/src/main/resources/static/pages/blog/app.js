var MONTHS = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
var AM_PM = ['AM', 'PM'];

var blogs = new Array();

function createBlogEntries(id) {
	$.ajax({url: "../../rest/blogs/", success: function(blogs) {
		var html = '';
		for (var i = blogs.length - 1; i >= 0; i--) {
			html += createBlogEntry(blogs[i]);
		};
		$("#"+id).html(html);
    }});
	
}

function createBlogEntry(blog) {
	var html = '<div id="blogEntry"><h2><a href="./post/blog.html?id='+blog.id+'">'+blog.title
	+'</a></h2> <p class="lead">by <a href="index.php">'+blog.createdBy+'</a></p>'
	+'<p><span class="glyphicon glyphicon-time"></span> Posted on '
	+formatDate(blog.created)+'</p><hr>';

	if (blog.coverLink) {
		html += '<img class="img-responsive" '+'src="'+blog.coverLink+'" alt=""><hr>';
	}

	if(blog.lead) {
		html += '<p class="lead">'+blog.lead+'</p>';
	}
	html += '<p>'+blog.intro+'</p>';
	html += '<a class="btn btn-primary" onclick=loadBlog('+blog.id+')>Read More <span class="glyphicon glyphicon-chevron-right"></span></a><hr></div>';

	return html;
}

function formatDate(date) {date = new Date(date);
	var hour = (date.getHours()%12)<10?'0'+date.getHours():date.getHours();
	var min = date.getMinutes()<10?'0'+date.getMinutes():date.getMinutes();
	return MONTHS[date.getMonth()] +' '+date.getDate()+', '+date.getFullYear()+' '+hour+':'+min+' '+AM_PM[parseInt(date.getHours()/12)];
}

function createBlogPost(id) {
 	$.ajax({url: "/app/rest/blogs/"+id, success: function(blog){
        $("#title").html(blog.title);
        $("#postBy").html(blog.createdBy);
        $("#postTime").html(formatDate(blog.created));
        $("#coverImage").attr("src",blog.coverLink);
        $("#content").html(blog.content);
    }});
}

function loadBlog(id) {
	$("#pageContent").load("./post/index1.html");
	createBlogPost(id);
}
