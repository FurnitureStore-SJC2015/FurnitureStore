<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 right">

	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<span class="glyphicon glyphicon-info-sign"></span><strong>Request
					#${request.id} </strong>
			</h5>
		</div>
		<div class="panel-body">

			<div class="col-md-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Module Name</th>
							<th>Module Cost</th>
							<th>Number Of Units</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${requestUnits}" var="requestUnit">
							<tr>
								<td>${requestUnit.moduleName}</td>
								<td>${requestUnit.moduleCost}</td>
								<td>${requestUnit.count}</td>
							</tr>
						</c:forEach>
					</tbody>



				</table>
			</div>
		</div>
	</div>
</div>