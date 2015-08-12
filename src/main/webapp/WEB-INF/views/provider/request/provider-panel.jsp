<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 right">
	<h1 align="center">INCOMING REQUESTS</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>REQUEST DATE</th>
				<th></th>
				<th></th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${requests}" var="request">
				<tr>
					<td>${request.id}</td>
					<td>${request.requestDate}</td>
					<td><c:set var="link" value="provider_panel/${request.id}"></c:set>
						<button class="btn btn-default" onclick="location.href='${link}'">SHOW
							UNITS</button></td>

					<td><c:set var="link" value="provider_panel/process_request"></c:set>
						<button class="btn btn-default" onclick="location.href='${link}'">PROCESS
							REQUEST</button></td>
				</tr>
			</c:forEach>
		</tbody>



	</table>

</div>