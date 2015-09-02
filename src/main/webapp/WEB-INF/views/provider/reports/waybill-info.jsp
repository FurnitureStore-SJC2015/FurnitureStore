<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 ">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<span class="glyphicon glyphicon-info-sign"></span><strong>WAYBILL
					INFO</strong>
			</h5>
		</div>
		<div class="panel-body">

			<div class="col-md-12">
				<table class="table table-striped">
					<thead>

					</thead>
					<tbody>
						<tr>
							<td><strong>ID:</strong></td>
							<td>${waybill.id}</td>
						</tr>
						<tr>
							<td><strong>DEPARTURE DATE:</strong></td>
							<td>${waybill.departureDate}</td>
						</tr>
						<tr>
							<td><strong>DELIVERY DATE:</strong></td>
							<td>${waybill.deliveryDate}</td>
						</tr>
						<tr>
							<td><strong>CONFIRMATION DATE:</strong></td>
							<td>${waybill.confirmationDate}</td>
						</tr>
						<tr>
							<td><strong>DELIVERY COST:</strong></td>
							<td>${waybill.deliveryCost}</td>
						</tr>
					</tbody>

				</table>
			</div>
		</div>

	</div>
</div>