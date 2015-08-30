<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="i" value="1"></c:set>

<div class="col-md-9">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<span class="glyphicon glyphicon-edit"></span><strong>Modules
					Catalog</strong>
			</h5>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>MODULE ID</th>
						<th>MODULE NAME</th>
						<th>COST</th>
						<th>NUMBER OF UNITS</th>
						<th>PICTURE</th>
						<th>SEND A REPLY</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${modules}" var="module">
						<tr id="record${i}">
							<td>${module.moduleId}</td>
							<td>${module.moduleName}</td>
							<td>${module.moduleCost}</td>
							<td>${module.count}</td>
							<td><c:if test="${not empty module.image}">
									<div class="col-md-4">
										<img src="data:image/jpeg;base64,${module.image}"
											class="img-thumbnail">
									</div>
								</c:if></td>

							<td><c:set var="link"
									value="request/${module.moduleId}"></c:set>
								<button class="btn btn-default" 
									onclick="location.href='${link}'" >
									<span class="glyphicon glyphicon-send"></span>
								</button></td>
							<c:set var="i" value="${i + 1}"></c:set>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

		<div class="panel-footer clearfix"></div>
	</div>

</div>