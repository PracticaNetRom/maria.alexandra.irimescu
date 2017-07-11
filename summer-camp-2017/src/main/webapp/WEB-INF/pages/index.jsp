<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
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
<style>
div.listAnnounce {
	width: 40%;
	margin: 70px 350px;
	padding: 10px 50px;
	background-color: cyan;
	border-radius: 8px;
}

@media screen and (max-width: 600px) {
	ul.topnav li {
		float: none;
		margin: 0;
		padding: 0;
	}
	div.listAnnounce {
		float: none;
		width: 100%;
		padding: 0;
		margin: 0;
	}
}
</style>



</head>
<body>
	<!--  Navigation bar -->
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

				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Category <span class="caret"></span></a>

						<ul class="dropdown-menu">
							<c:forEach var="category" items="${categories}">
								<li><a href="#">${category.getName()}<br> <i>Description:
											${category.getDescription()} </i></a></li>
								<li></li>
								<li role="separator" class="divider"></li>
							</c:forEach>
						</ul></li>


				</ul>
				<ul class="navbar-form navbar-right">

					<form action="addAnnouncement.html" method="GET">
						<button class="btn btn-primary btn-lg" data-toggle="modal"
							data-target="#myModal">Add announcement</button>
					</form>

				</ul>

			</div>
		</div>
		<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>


	<c:forEach var="obj" items="${modelAnnouncement}">
		<div class="listAnnounce">
			<form action="/showDetails.html?id=${obj.id}" method="GET">
				<button class="btn btn-primary ">Details</button>
			</form>

			<a href="showDetails.html?id=${obj.id}">Details</a><br>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
				data-target="#myModal_${obj.getId()}">Open Modal</button>
			<form
				action="/closeAnnouncement.do?id=${obj.id}&ownerEmail=${obj.ownerEmail}"></form>
			
			<a
				href="/closeAnnouncement.do?id=${obj.id}&ownerEmail=${obj.ownerEmail}">Close</a>
			
<form
				action="/closeAnnouncement.do?id=${obj.id}&ownerEmail=${obj.ownerEmail}"
				method="GET">
			
		
				<button type = "submit">Close</button>
			</form>
			<p>Id: ${obj.getId()}</p>
			<p>Title: ${obj.getTitle()}</p>
			<p>Location: ${obj.getLocation()}</p>
			<p>Content: ${obj.getContent()}</p>
			<p>Available: ${obj.getCreateDate()} to ${obj.getExpireDate()}</p>
			<form
				action="/closeAnnouncement.do?id=${obj.getId()}&ownerEmail=${obj.ownerEmail}"
				method="POST">
				<!-- Modal -->
				<div class="modal fade" id="myModal_${obj.getId()}" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Close announcement</h4>
							</div>
							<div class="modal-body">
								AnnouncementId:${obj.getId()}<br> Email: <input type="text"
									name="ownerEmail" />
							</div>

							<div class="modal-footer">
								<button type="submit" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>


						</div>

					</div>
				</div>


			</form>

		</div>
	</c:forEach>





</body>
<script type="text/javascript">
	$(function() {
		$("#expireDate").datepicker();
	});
</script>

</html>