<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<sec:authorize
	access="isAuthenticated() and hasAnyRole('ROLE_CLIENT','ROLE_COMPANY')">
	<div class="col-md-9">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h5 class="text-center">
					<strong>"${product.name}" information</strong>
				</h5>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-3">
						<img src="data:image/jpeg;base64,${product.image}"
							class="img-thumbnail">
					</div>

					<div class="col-md-9">
						<table class="table table-hover table-bordered">
							<thead>
								<tr>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><strong>Name:</strong></td>
									<td><strong>${product.name}</strong></td>
								</tr>

								<sec:authorize access="hasRole('ROLE_COMPANY')">
									<tr>
										<td><strong>Coefficient:</strong></td>
										<td><Strong>${product.coefficient}</Strong></td>
									</tr>
									<tr>
										<td><strong>Cost:</strong></td>
										<td><strong>${product.cost}</strong></td>
									</tr>

								</sec:authorize>
								<sec:authorize access="hasRole('ROLE_CLIENT')">
									<tr>
										<td><strong>Cost:</strong></td>
										<td><strong>${product.cost*product.coefficient}</strong></td>
									</tr>
								</sec:authorize>
							</tbody>
						</table>
					</div>
				</div>

				<sec:authorize access="hasRole('ROLE_CLIENT')">
					<div class="row">
					
					</div>
				</sec:authorize>


				<c:if test="${not empty product.feedbacks}">
					<div class="col-md-12">
						<h2 class="text-left">Feedbacks:</h2>
						<c:forEach var="feedback" items="${product.feedbacks}">
							<div class="row">
								<div class="col-md-2">
									<img src="data:image/jpeg;base64,${feedback.client.avatar}"
										class="img-thumbnail" alt="Sample Image">
								</div>
								<div class="col-md-10">
									<div class="media">
										<div class="media-body">
											<h4 class="media-heading">
												<small><i>Posted on <fmt:formatDate type="both"
															value="${feedback.date}" />
														<div class="text-right">My range: ${feedback.range}</div>
												</i></small>
											</h4>
											<p>
												<strong>${feedback.text}</strong>
											</p>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:if>

				<c:if test="${empty product.feedbacks}">
					<h2>No feedbacks</h2>
				</c:if>




			</div>

		</div>

	</div>
</sec:authorize>
