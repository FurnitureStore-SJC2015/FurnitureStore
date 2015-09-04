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
						<th class="text-center">Module ID</th>
						<th class="text-center">Module Name</th>
						<th class="text-center">Cost</th>
						<th class="text-center">Number Of Units</th>
						<th class="text-center">Picture</th>
						<th class="text-center">Send A Reply</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach items="${modules}" var="module">
						<tr id="record${i}">
							<td class="text-center">${module.moduleId}</td>
							<td class="text-center">${module.moduleName}</td>
							<td class="text-center">${module.moduleCost}</td>
							<td class="text-center">${module.count}</td>
							<td class="text-center"><c:if test="${not empty module.image}">
									<div>
										<img src="data:image/jpeg;base64,${module.image}" width="175px"
											class="img-thumbnail">
									</div>
								</c:if></td>

							<td class="text-center"><c:url var="link" value="/modules/request/${module.moduleId}"/>
								<div align="center">
									<button class="btn btn-default"
										onclick="location.href='${link}'">
										<span class="glyphicon glyphicon-send"></span>
									</button>
								</div></td>
							<c:set var="i" value="${i + 1}"></c:set>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

		<div class="panel-footer clearfix"></div>
	</div>

</div>