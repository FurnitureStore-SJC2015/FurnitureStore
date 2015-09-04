<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9 ">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<span class="glyphicon glyphicon-lidt-alt"></span><strong>SHIPMENTS</strong>
			</h5>
		</div>
		<div class="panel-body">


			<div class="col-md-12">

				<table style="font-size: 100%" class="table table-striped">
					<thead>
						<tr>
							<th class="text-center">ID</th>
							<th class="text-center">Margin Percent</th>
							<th class="text-center"></th>
							<th class="text-center"></th>
							<th class="text-center"></th>
						</tr>
					</thead>

					<tbody>


						<c:forEach items="${shipments}" var="shipment">
							<c:url value="/shipments/${shipment.id}" var="link1" />
							<c:url value="/shipments/${shipment.id}/waybill" var="link2" />
							<c:url value="/shipments/${shipment.id}/accept" var="link3" />
							<tr>
								<td class="text-center">${shipment.id}</td>
								<td class="text-center">${shipment.providerMarginPercent}</td>
								<td class="text-center">
									<button class="btn btn-info" onclick="location.href='${link1}'">Show
										Units</button>
								</td>
								<td class="text-center">
									<button class="btn btn-default"
										onclick="location.href='${link2}'">Show Waybill</button>
								</td>

								<td class="text-center">
									<button class="btn btn-success"
										onclick="location.href='${link3}'">Accept And Sign
										Waybill</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>