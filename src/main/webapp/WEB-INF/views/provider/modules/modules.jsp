<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	function deleteModule(moduleId, i) {
		var selectedOption = $('#selector option:selected').val();

		$.ajax({
			url : "modules/" + modulesId + "/delete",
			type : "POST",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			success : function(obj) {
				var temp = $("#record" + i);
				temp.fadeOut(800, function() {
					temp.remove();
				});

			}
		});
	}
</script>

<div class="col-md-9 well">

	<div class="col-md-12">
		<h2>
			<strong>MODULES MANAGEMENT</strong>
		</h2>
	</div>


	<div class="col-md-12">





		<table class="table table-striped">
			<thead>
				<tr>
					<th>MODULE ID</th>
					<th>MODULE NAME</th>
					<th></th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${modules}" var="module">
					<tr>
						<td>${shipment.id}</td>
						<td>${shipment.providerMarginPercent}</td>
						<td><c:set var="link" value="reports/${shipment.id}"></c:set>
							<button class="btn btn-info" onclick="location.href='${link}'">SHOW
								UNITS</button></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>