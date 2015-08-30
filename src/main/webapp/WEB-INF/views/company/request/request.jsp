<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="col-md-9 well right">

	<div class="col-md-12" align="center">
		<h2 align="center">
			<strong>NEW MODULES REQUEST</strong>
		</h2>
	</div>
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h5 class="text-center">
					<span class="glyphicon glyphicon-list"></span><strong>New
						Request</strong>
				</h5>
			</div>

			<div class="panel-body">

				<c:if test="${not empty error}">
					<h5>${error}</h5>
				</c:if>
				<c:url var="sendRequest" value="/modules/request/${id}/send"></c:url>
				<form:form method="POST" action="${sendRequest}"
					modelAttribute="requestUnit" class="form-horizontal"
					enctype="multipart/form-data" role="form">
					<div class="panel">
						<div class="form-group">
							<div class="col-md-2">
								<label for="moduleId">Module Id</label>
								<div id="moduleId">
									<h5>${id}</h5>
								</div>
							</div>
							<div class="col-md-3">
								<label for="moduleName">Module Name</label>
								<div id="moduleName">
									<h5>${moduleName}</h5>
								</div>
							</div>
							<div class="col-md-2">
								<label for="numberModules">Number</label>
								<form:input type="number" path="count" id="numberModules"
									name="number" class="form-control" />
								<form:errors path="count" class="danger"></form:errors>
							</div>
							<div class="col-md-3">
								<c:set var="link" value="providers/${id}"></c:set>
								<label for="providerSelector">Select Provider</label>
								<form:select path="chosenProvider" name="providerSelector"
									class="form-control" id="providerSelector">
									<c:forEach items="${providers}" var="provider">
										<option value="${provider.providerName}">${provider.providerName}</option>
									</c:forEach>

								</form:select>
								<form:errors path="chosenProvider" class="danger"></form:errors>
							</div>
							<div class="col-md-2">
								<div class="calculateButton">
									<label></label> <input type="submit" class="btn btn-success"
										value="Send Request" />
								</div>
							</div>
						</div>
					</div>
				</form:form>

			</div>
		</div>
	</div>
</div>