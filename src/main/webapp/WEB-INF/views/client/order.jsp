<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9">
	<table class="table table-bordered table-striped">
		<h3>Order # ${order.id}</h3>
		<thead>
		</thead>
		<tbody>
			<tr>
				<td><strong>Order type:</strong></td>
				<td><strong>${order.paymentScheme.paymentForm.name}</strong></td>
			</tr>
			<tr>
				<td><strong>Term:</strong></td>
				<td><strong>${order.paymentScheme.term} days</strong></td>
			</tr>
			<tr>
				<td><strong>Percentage:</strong></td>
				<td><strong>${order.paymentScheme.percentage} %</strong></td>
			</tr>
			<tr>
				<td><strong>Penalty:</strong></td>
				<td><strong>${order.paymentScheme.penalty} %</strong></td>
			</tr>
		</tbody>
	</table>
</div>

<div class="row">
	<div class="col-md-9 col-md-offset-3">
		<h2>Payments</h2>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th><h2>#</h2></th>
					<th><h2>Payment Date</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><strong>Order type:</strong></td>
					<td><strong>${order.paymentScheme.paymentForm.name}</strong></td>
				</tr>
				<tr>
					<td><strong>Term:</strong></td>
					<td><strong>${order.paymentScheme.term} days</strong></td>
				</tr>
				<tr>
					<td><strong>Percentage:</strong></td>
					<td><strong>${order.paymentScheme.percentage} %</strong></td>
				</tr>
				<tr>
					<td><strong>Penalty:</strong></td>
					<td><strong>${order.paymentScheme.penalty} %</strong></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</div>