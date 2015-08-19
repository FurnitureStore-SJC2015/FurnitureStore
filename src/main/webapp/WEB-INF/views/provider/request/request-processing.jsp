<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	$(function() {
		$('input[name="delivery-date"]').daterangepicker({
			singleDatePicker : true,
			showDropdowns : true
		});
	});
</script>

<div class="col-md-9 well right">

	<div class="col-md-12" align="center">
		<h2 align="center">
			<strong>REQUEST #${request.id} </strong>
		</h2>
	</div>
	<div class="col-md-12">
		<c:url value="/provider/module_requests/${request.id}/process" var="processUrl" />
		<form:form align="center" name="processingForm" action="${processUrl}"
			method="POST" class="form-horizontal" role="form">

			<div class="form-group" align="center" class="col-md-12">
				<label for="delivery-cost" class="col-sm-4 control-label">DELIVERY
					COST</label>
				<div class="col-sm-4 control-label">
					<input type="text" id="delivery-cost" name="delivery-cost"
						class="form-control">
				</div>
			</div>



			<div class="form-group" align="center" class="col-md-12">
				<label for="provider-margin-percent" class="col-sm-4 control-label">PROVIDER
					MARGIN PERCENT</label>
				<div class="col-sm-4 control-label">
					<input type="text" id="provider-margin-percent"
						name="provider-margin-percent" class="form-control">
				</div>
			</div>


			<div class="form-group" align="center" class="col-md-12">
				<label for="delivery-date" class="col-sm-4 control-label">DELIVERY
					DATE</label>
				<div class="col-md-4 control-label">
					<input type="text" name="delivery-date" class="form-control" />
				</div>
			</div>

			<div class="form-group" align="center" class="col-md-12">
				<div class=" col-md-12" align="center">
					<button type="submit" class="btn btn-success btn-sm">SEND
						SHIPMENT</button>
				</div>
			</div>
		</form:form>
	</div>
</div>

