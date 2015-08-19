<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 well">


	<div class="col-md-12">
		<table class="table table-striped">
			<thead>
				<tr>
					<th><h2>
							<strong>WAYBILL INFO</strong>
						</h2></th>
				</tr>
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