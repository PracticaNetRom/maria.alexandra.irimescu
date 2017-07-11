<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<li>
<!-- 	${comment.id}<br> ${comment.name}
	${comment.content }

 -->
	<div class="row">
		<div class="col-sm-1" style="margin-left: 75px;">
			<div class="thumbnail">

				<img class="img-responsive user-photo"
					src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">

			</div>
		
		</div>

		<div class="col-sm-5">
			<div class="panel panel-default" style="width: 700px;">
				<div class="panel-heading">

					<strong>${comment.name}</strong> <span class="text-muted">commented
						${comment.getCreateDate() }</span> <a class="btn btn-primary" role="button"
						href="#collapseExample">Reply</a>

				</div>
				<div class="panel-body">

					<p>	${comment.content }</p>

				</div>
			
			</div>
	
		</div>


	</div>


 
	<div>
		<c:if test="${not empty children}">
			<ul>
				<c:forEach var="child" items="${children}" varStatus="loop">
					<c:set var="children" value="${child.children}" scope="request"/>
					<c:set var="comment" value="${child}" scope="request"/>
					<jsp:include page="comment.jsp"/>
				</c:forEach>
			</ul>
		</c:if>
	</div>
</li>