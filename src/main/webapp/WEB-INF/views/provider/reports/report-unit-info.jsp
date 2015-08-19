<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 well">

	<div class="col-md-12">
		<h2>
			<strong>SHIPMENT #${shipment.id}</strong>
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

				<c:forEach items="${shipmentUnits}" var="shipmentUnit">
					<tr>
						<td>${shipmentUnit.id}</td>
						<td>${shipmentUnit.moduleName}</td>
						<td>${shipmentUnit.moduleCost}</td>
						<td>${shipmentUnit.count}</td>
					</tr>
				</c:forEach>
			</tbody>



		</table>
	</div>

</div>