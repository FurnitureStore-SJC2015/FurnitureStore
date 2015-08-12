<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 right">
	<h2 align="center">REQUEST # ${request.id}</h2>
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
					<td></td>
					<td></td>
					<td>${requestUnit.count}</td>
				</tr>
			</c:forEach>
		</tbody>



	</table>
</div>