<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
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
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

<script src="/resources/js/jquery-3.2.1.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<script src="/resources/js/bootstrap.js"></script>

<title>Announcement</title>
</head>
<style>
body {
	width: 100%;
}

.container {
	width: 1000px;
}

.left {
	width: 700px;
	background-color: lightgray;
	float: left;
	border-radius: 8px;
	border-top: 2px solid blue;
}

.right {
	width: 250px;
	float: right;
	margin-bottom: 50px;
}

.info {
	border-radius: 5px;
	background-color: lightblue;
	color: white;
	text-indent: 12px;
}

.phone {
	border-radius: 5px;
	background-color: lightblue;
}

.email {
	border-radius: 5px;
	background-color: lightblue;
	font-size: 20px;
	margin-top: 10px;
}

.comment {
	clear: both;
}

ul {
	list-style-type: none;
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

			<form class="navbar-form navbar-left">

				<div class="form-group">

					<input type="text" class="form-control" placeholder="Search">

				</div>

				<button type="submit" class="btn btn-default">Submit</button>

			</form>

			<ul class="navbar-form navbar-right">

				<form action="addAnnouncement.html" method="GET">
					<button class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#myModal">Add announcement</button>
				</form>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div class="container">

		<div class="left">

			<h2 style="text-align: center;">${announcementById.getTitle()}</h2>
			<p style="text-indent: 12px;">${announcementById.getLocation()}</p>
			<h6 style="text-indent: 12px;">Add at:
				${announcementById.getCreateDate() }</h6>
			<hr>
			<p>Category name:${announcementById.getCategoryName() }</p>
			<p>Content: ${announcementById.getContent()}</p>

		</div>

		<div class="right">

			<div class="info">

				<span class="glyphicon glyphicon-user"
					style="font-size: 25px; text-indent: 100px; padding: 5px;"></span>
				<p style="text-align: center;">${announcementById.getOwnerFirstName()}
					${announcementById.getOwnerLastName() }</p>

			</div>

			<div class=" phone">

				<span class="glyphicon glyphicon-earphone"
					style="font-size: 20px; display: block; padding: 20px; text-align: center;">
					${announcementById.getOwnerPhone() } </span>

			</div>

			<div class="email">

				<span class="glyphicon glyphicon-envelope" style="padding: 20px;">
					${announcementById.getOwnerEmail() } </span>
			</div>

		</div>

		<div class="comment">

			<div
				style="border-top: 2px solid black; border-bottom: 2px solid black; margin-bottom: 45px;">

				<h3 style="text-align: center;">Alatura-te conversatiei</h3>

			</div>

			<form action="/addComment.do?announcementId=${announcementById.id}" method="POST" id="collapseExample">

				<div class="row" style="margin-left: 75px;">

					<div class="col-sm-1">

						<div class="thumbnail">
							<img class="img-responsive user-photo"
								src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
						</div>
						<!-- /thumbnail -->

					</div>
					<!-- /col-sm-1 -->

					<textarea class="form-control" rows="3" style="width: 700px;"
						placeholder="Say something..." name="content"></textarea>

					<div class="form-inline">

						<label style="margin-left: 15px; margin-top: 25px;">Name</label> <input
							type="text" class="form-control" placeholder="Name*"
							style="width: 700px; margin-left: 18px;" name="name">

					</div>

					<button type="submit" class="btn btn-primary"
						style="margin-top: 25px; margin-left: 350px;">Add comment
					</button>
				</div>
			</form>


			<div class="container1" style="margin-top: 25px;">
				<ul>
					<c:forEach var="node" items="${comments}">
						<c:set var="children" value="${node.children}" scope="request" />
						<c:set var="comment" value="${node}" scope="request" />
						<jsp:include page="comment.jsp" />
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>




</body>
</html>