<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 well right">

	<div class="col-md-12">
		<h2>
			<strong>REQUEST #${request.id}</strong>
		</h2>
	</div>
	<div class="col-md-12">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>MODULE NAME</th>
					<th>MODULE COST</th>
					<th>NUMBER OF UNITS</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${requestUnits}" var="requestUnit">
					<tr>
						<td>${requestUnit.id}</td>
						<td>${requestUnit.moduleName}</td>
						<td>${requestUnit.moduleCost}</td>
						<td>${requestUnit.count}</td>
					</tr>
				</c:forEach>
			</tbody>



		</table>
	</div>
</div>