<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 ">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<strong>MODULE REQUESTS </strong>
			</h5>
		</div>
		<div class="panel-body">
			<div class="col-md-12">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Request Date</th>
							<th>Details</th>
							<th>Process Request</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${requests}" var="request">
							<tr>
								<td>${request.id}</td>
								<td>${request.requestDate}</td>
								<td><c:url var="link" value="/requests/${request.id}" />
									<button class="btn btn-info" onclick="location.href='${link}'">Show
										Detalis</button></td>

								<td><c:url var="link"
										value="/requests/${request.id}/processing_page" />
									<button class="btn btn-success"
										onclick="location.href='${link}'">Process Request</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>