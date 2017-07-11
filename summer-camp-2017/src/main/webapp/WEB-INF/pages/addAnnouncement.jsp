<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
.subtitle {
	background-color: green;
	color: white;
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
	<div class=" subtitle">
		<h3 style="margin-left: 50px; padding: 15px 0;">New Announcement</h3>
	</div>
	<form action="/addAnnouncement.html" method="POST"
		class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-2 control-label">Title</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Title"
					name="title">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Content</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Content"
					name="content">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Location</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Location"
					name="location">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Confirmation Code</label>
			<div class="col-sm-8">
				<input type="text" class="form-control"
					placeholder="Confirmation code" name="confirmationCode">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"> ExpireDate</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Expire date"
					name="expireDate" id="expireDate">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Email</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Email"
					name="ownerEmail">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">First Name</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="First name"
					name="ownerFirstName">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Last Name</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Last name"
					name="ownerLastName">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Phone</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Phone"
					name="ownerPhone">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Category</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="Categrory name"
					name="categoryName">
			</div>
		</div>

		<div class="col-sm-2 control-label">

			<button type="submit" class="btn btn-default">Submit</button>

		</div>

	</form>

</body>
<script type="text/javascript">
	$(function() {
		$("#expireDate").datepicker();
	});
</script>
</html>