<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	</ul>
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
	<!-- /.container-fluid -->
	</nav>


	<c:forEach var="obj" items="${modelAnnouncement}">
		<div class="listAnnounce">
			<form action="showDetails.html?id=${obj.id}" method="get">
				<button class="btn btn-primary ">Details</button>
			</form>

			<a href="showDetails.html?id=${obj.id}">Details</a>

			<p>Title: ${obj.getTitle()}</p>
			<p>Location: ${obj.getLocation()}</p>
			<p>Content: ${obj.getContent()}</p>
			<p>Available: ${obj.getCreateDate()} to ${obj.getExpireDate()}</p>

		</div>
	</c:forEach>
</body>
<script type="text/javascript">
	$(function() {
		$("#expireDate").datepicker();
	});
</script>
</html>