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
					Shipemnt For Request #${request.id} </strong>
			</h5>
		</div>
		<div class="panel-body">


			<h1>
				<strong>Shipment was successfully sent!</strong>
			</h1>

		</div>
	</div>
</div>