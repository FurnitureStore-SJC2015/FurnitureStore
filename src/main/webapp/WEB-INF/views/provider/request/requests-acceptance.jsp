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
							<th class="text-center">ID</th>
							<th class="text-center">Request Date</th>
							<th class="text-center">Details</th>
							<th class="text-center">Process Request</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${requests}" var="request">
							<tr >
								<td class="text-center">${request.id}</td>
								<td class="text-center">${request.requestDate}</td>
								<td class="text-center"><c:url var="link" value="/requests/${request.id}" />
									<button class="btn btn-info" onclick="location.href='${link}'">Show
										Detalis</button></td>

								<td class="text-center"><c:url var="link"
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