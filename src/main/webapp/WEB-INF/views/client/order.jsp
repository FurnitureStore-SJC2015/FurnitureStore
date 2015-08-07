<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 well">
	<table class="table table-hover">
		<thead>
			<tr>
				<th><h2>Order # ${order.id}</h2></th>
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