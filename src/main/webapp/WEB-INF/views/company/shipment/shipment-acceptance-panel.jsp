<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 ">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<span class="glyphicon glyphicon-lidt-alt"></span><strong>SHIPMENTS</strong>
			</h5>
		</div>
		<div class="panel-body">


			<div class="col-md-8">

				<table style="font-size: 100%" class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>MARGIN PERCENT</th>
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
								<td><c:set var="link1"
										value="/FurnitureStore/shipments/${shipment.id}"></c:set>
									<button class="btn btn-info" onclick="location.href='${link1}'">SHOW
										UNITS</button></td>
								<td><c:set var="link2"
										value="/FurnitureStore/shipments/${shipment.id}/waybill"></c:set>
									<button class="btn btn-default"
										onclick="location.href='${link2}'">SHOW WAYBILL</button></td>

								<td><c:set var="link3"
										value="/FurnitureStore/shipments/${shipment.id}/accept"></c:set>
									<button class="btn btn-success"
										onclick="location.href='${link3}'">ACCEPT AND SIGN
										WAYBILL</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>