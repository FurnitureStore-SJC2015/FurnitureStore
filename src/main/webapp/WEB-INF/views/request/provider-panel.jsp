<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-12 well">
	<h1>All requests</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Request Date</th>
				<th>Id</th>
			</tr>
		</thead>

		<tbody>
			<c:set var="i" value="1"></c:set>
			<c:forEach items="${requests}" var="request">
				<tr>
					<td>${i}</td>
					<td>${request.requestDate}</td>
					<td><strong>${request.id}</strong></td>
					<c:set var="i" value="${i + 1}"></c:set>
				</tr>
			</c:forEach>
		</tbody>



	</table>

</div>