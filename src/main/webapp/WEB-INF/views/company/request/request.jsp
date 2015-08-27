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
					<span class="glyphicon glyphicon-list"></span><strong>New Request</strong>
				</h5>
			</div>
			<c:url value="request/send" var="sendUrl" />
			<div class="panel-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>MODULE</th>
							<th>PROVIDER</th>
							<th>COUNT</th>

						</tr>
					</thead>

					<tbody>

						<c:set var="i" value="1"></c:set>
						<c:forEach items="${requestUnits}" var="requestUnit">
							<tr id="record${i}">
								<td>${requestUnit.moduleName}</td>
								<td><select name="id" class="form-control" id="selector">
										<c:forEach var="item" items="${requestUnit.providerNames}">
											<option disabled>Choose provider</option>

											<option value="${i}">${item}</option>
											<c:set var="i" value="${i + 1}"></c:set>
										</c:forEach>
								</select></td>
								<td>${requestUnit.count}</td>
							</tr>
							<td>
								<button class="btn btn-default"
									onclick="location.href='${sendUrl}'">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</td>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>