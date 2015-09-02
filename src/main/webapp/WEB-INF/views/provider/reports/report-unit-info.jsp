<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 ">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<span class="glyphicon glyphicon-info-sign"></span><strong>SHIPMENT
					#${shipment.id}</strong>
			</h5>
		</div>
		<div class="panel-body">

			<div class="col-md-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>MODULE NAME</th>
							<th>COST</th>
							<th>NUMBER OF UNITS</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${shipmentUnits}" var="shipmentUnit">
							<tr>
								<td>${shipmentUnit.moduleName}</td>
								<td>${shipmentUnit.cost}</td>
								<td>${shipmentUnit.count}</td>
							</tr>
						</c:forEach>
					</tbody>



				</table>
			</div>
		</div>
	</div>
</div>