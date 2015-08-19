<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 well">

	<div class="col-md-8">
		<h2>
			<strong>SHIPMENTS</strong>
		</h2>
		<table style="font-size: 100%" class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>MARGIN PERCENT</th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${shipments}" var="shipment">
					<tr>
						<td>${shipment.id}</td>
						<td>${shipment.providerMarginPercent}</td>
						<td><c:set var="link" value="shipments/${shipment.id}"></c:set>
							<button class="btn btn-info" onclick="location.href='${link}'">SHOW
								UNITS</button></td>
						<td><c:set var="link"
								value="shipments/${shipment.id}/waybill"></c:set>
							<button class="btn btn-default" onclick="location.href='${link}'">SHOW
								WAYBILL</button></td>

						<td>
							<button class="btn btn-success"
								onclick="acceptShipment(${shipment.id})">ACCEPT AND
								SIGN WAYBILL</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</div>