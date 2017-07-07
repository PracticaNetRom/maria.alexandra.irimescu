<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/resources/css/jquery-ui.css">
<link rel="stylesheet" href="/resources/css/bootstrap-theme.css">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/bootstrap-theme.css.map">
<link rel="stylesheet" href="/resources/css/bootstrap.css.map">


<script src="/resources/js/jquery-3.2.1.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<script src="/resources/js/bootstrap.js"></script>

<title>Announcement</title>
</head>
<style>
body {
	width: 100%;
}



.left {
	width: 50px;
	margin-left: 25px;
	background-color: white;
}

.right {
	width: 100px;
	margin-left: 25px;
}

.comment {
	float: clear;
}
</style>

<body>
	<nav class="navbar navbar-default" style="top: 0">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Announcements</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav">



			</ul>
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>

			</form>
			<ul class="navbar-form navbar-right">

				<!-- 	<form action="addAnnouncement.html" method="GET">
					<button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#myModal">Add announcement</button>
				</form>
			 -->
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	
		<div class="left">

			<p>Title: ${announcementById.getTitle()}</p>
			<p>Content: ${announcementById.getContent()}</p>
			<p>Expire: ${announcementById.getExpireDate()}</p>
			<p>Location: ${announcementById.getLocation()}</p>
			<p>Category name:${announcementById.getCategoryName() }</p>


		</div>
		<div class="right">

			<p>${announcementById.getOwnerFirstName()}</p>
			<p>${announcementById.getOwnerLastName() }</p>
			<p>${announceemntById.getOwnerEmail() }</p>
			<p>${announcementById.getOwnerPhone() }</p>
		</div>
	
	
	<c:forEach var="node" items="${comments}">
		<c:set var="node" value="${node}" scope="request" />
		<jsp:include page="comment.jsp" />

	</c:forEach>
	<div class="comment">
		<form>
			<label>Comment: </label> <input type="text" name="content">
			<button type="submit">Add comment</button>
		</form>
	</div>
</body>
</html>