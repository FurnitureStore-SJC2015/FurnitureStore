<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	$(function() {
		$("#deliveryDate").daterangepicker({
			singleDatePicker : true,
			showDropdowns : true
		});
	});
</script>

<div class="col-md-9 right">

	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<span class="glyphicon glyphicon-send"></span><strong>SEND
					SHIPMENT FOR REQUEST #${request.id} </strong>
			</h5>
		</div>
		<div class="panel-body">


			<div class="col-md-12">
				<c:url value="/requests/${request.id}/process" var="processUrl" />
				<form:form align="center" name="processingForm"
					modelAttribute="requestProcessDto" action="${processUrl}"
					method="POST" class="form-horizontal" role="form">

					<div class="form-group" align="center" class="col-md-12">
						<label for="delivery-cost" class="col-sm-4 control-label">DELIVERY
							COST</label>
						<div class="col-sm-4 control-label">
							<form:input type="text" path="deliveryCost" id="delivery-cost"
								name="delivery-cost" class="form-control" />

							<form:errors path="deliveryCost" class="danger"></form:errors>
						</div>
					</div>



					<div class="form-group" align="center" class="col-md-12">
						<label for="provider-margin-percent"
							class="col-sm-4 control-label">PROVIDER MARGIN PERCENT</label>
						<div class="col-sm-4 control-label">
							<form:input type="text" id="provider-margin-percent"
								path="providerMarginPercent" name="provider-margin-percent"
								class="form-control" />
							<form:errors path="providerMarginPercent" class="danger"></form:errors>
						</div>
					</div>


					<div class="form-group" align="center" class="col-md-12">
						<label for="delivery-date" class="col-sm-4 control-label">DELIVERY
							DATE</label>
						<div class="col-md-4 control-label">
							<form:input type="text" id="deliveryDate" name="deliveryDate"
								path="deliveryDate" class="form-control" />
							<form:errors path="deliveryDate" class="danger"></form:errors>
						</div>
					</div>

					<div class="form-group" align="center" class="col-md-12">
						<div class=" col-md-12" align="center">
							<input type="submit" class="btn btn-success"
								value="SEND
						SHIPMENT" />
						</div>
					</div>
				</form:form>
			</div>

		</div>
	</div>
</div>