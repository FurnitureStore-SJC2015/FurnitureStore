<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 well">

	<div class="col-md-12">
		<h2>
			<strong>MODULE REQUESTS</strong>
		</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>REQUEST DATE</th>
					<th>DETAILS</th>
					<th>PROCESS REQUEST</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${requests}" var="request">
					<tr>
						<td>${request.id}</td>
						<td>${request.requestDate}</td>
						<td><c:set var="link" value="module_requests/${request.id}"></c:set>
							<button class="btn btn-info" onclick="location.href='${link}'">SHOW
								DETAILS</button></td>

						<td><c:set var="link"
								value="module_requests/${request.id}/processing_page"></c:set>
							<button class="btn btn-success" onclick="location.href='${link}'">PROCESS
								REQUEST</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>