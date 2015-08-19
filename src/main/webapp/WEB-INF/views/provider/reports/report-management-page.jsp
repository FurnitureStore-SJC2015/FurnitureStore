<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="col-md-9 well">

	<div class="col-md-12">
		<h2>
			<strong>SHIPMENT REPORTS</strong>
		</h2>
	</div>

	<c:url var="action" value="/provider/reports/filtered"></c:url>
	<form:form action="${action}" method="GET" commandName="dateFilter">

		<div class="col-md-4">
			<input type="text" class="form-control" name="daterange" />
		</div>
		<div class="col-md-3">
			<input name="submit" type="submit" class="btn btn-danger"
				value="FILTER" />
		</div>

	</form:form>


	<script type="text/javascript">
		$(function() {
			$('input[name="daterange"]').daterangepicker();
		});
	</script>

	<div class="col-md-12">





		<table class="table table-striped">
			<thead>
				<tr>
					<th>SHIPMENT ID</th>
					<th>PROVIDER MARGIN PERCENT</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${shipments}" var="shipment">
					<tr>
						<td>${shipment.id}</td>
						<td>${shipment.providerMarginPercent}</td>
						<td><c:set var="link" value="reports/${shipment.id}"></c:set>
							<button class="btn btn-info" onclick="location.href='${link}'">SHOW
								UNITS</button></td>

						<td><c:set var="link"
								value="reports/${shipment.id}/waybill"></c:set>
							<button class="btn btn-success" onclick="location.href='${link}'">SHOW
								WAYBILL</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>