<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="col-md-9 well right">

	<div class="col-md-9" align="center">
		<h2 align="center">
			<strong>NEW MODULES REQUEST</strong>
		</h2>
	</div>
	<div class="col-md-9">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h5 class="text-center">
					<span class="glyphicon glyphicon-list"></span><strong>New
						Request</strong>
				</h5>
			</div>
			<c:url value="request/send" var="sendUrl" />
			<div class="panel-body">

				<c:url var="sendRequest" value="/request/send"></c:url>
				<form name="editRequest" action="${checkNewOrder}" method="post">
					<div class="panel">
						<div class="form-group">
							<div class="col-md-3">
								<h5>${moduleType}</h5>
							</div>
							<div class="col-md-6">
								<label for="providerSelector">Select Provider</label> <select
									name="providerSelector" class="form-control" id="providerSelector"
									onchange="showButton()">
								</select>
							</div>
							<div class="col-md-3">
								<div class="calculateButton" style="display: none;">
									<label></label> <input type="submit"
										class="btn btn-success" value="Process order!" />
								</div>
							</div>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</div>