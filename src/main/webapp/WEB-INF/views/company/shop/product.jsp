<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<script>
	function changeDisplayStatus() {
		var feedbacks = $('.allFeedbacks');
		if (feedbacks.css('display') == 'none') {
			feedbacks.show('slow');
		} else {
			feedbacks.hide('slow');
		}
	}

	function addFeedback() {
		var feedback = $('.oneFeedback');
		if (feedback.css('display') == 'none') {
			feedback.show('slow');
		} else {
			feedback.hide('slow');
		}
	}
</script>

<sec:authorize
	access="isAuthenticated() and hasAnyRole('ROLE_CLIENT','ROLE_COMPANY')">
	<div class="col-md-9">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h5 class="text-center">
					<strong><span class="glyphicon glyphicon-info-sign"></span>${product.name} information</strong>
				</h5>
			</div>
			<div class="panel-body">

				<div class="row">
					<div class="col-md-3">
						<img src="data:image/jpeg;base64,${product.image}"
							class="img-thumbnail">
					</div>

					<div class="col-md-9">
						<h4>
							<strong>Description:</strong>
						</h4>
						${product.description}
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
										<td><strong><fmt:formatNumber value="${product.coefficient}" maxFractionDigits="2"/></strong></td>
									</tr>
									<tr>
										<td><strong>Cost:</strong></td>
										<td><strong>${product.cost}</strong></td>
									</tr>
								</sec:authorize>
								<sec:authorize access="hasRole('ROLE_CLIENT')">
									<tr>
										<td><strong>Cost:</strong></td>
										<td><strong><fmt:formatNumber value="${product.cost*product.coefficient}" maxFractionDigits="2"/></strong></td>
									</tr>
								</sec:authorize>
							</tbody>
						</table>
					</div>
				</div>

				<sec:authorize access="hasRole('ROLE_CLIENT')">
					<a href="javascript:addFeedback()"><p class="text-right">Add
							your own feedback:</p></a>
					<div class="oneFeedback" style="display: none;">
						<c:url var="url" value="/feedback/add" />
						<form action="${url}" method="post">
							<div class="col-md-10 col-md-offset-1 well">
								<h4 class="text-center">
									<strong>What do you think about this ${product.name}?</strong>
								</h4>
								<div class="form-group">
									<div class="col-sm-8">
										<textarea class="form-control" id="message" name="message"
											rows="4"></textarea>
									</div>
									<div class="col-sm-2">
										<select id="range" name="range" class="form-control">
											<option value="5">5</option>
											<option value="4">4</option>
											<option value="3">3</option>
											<option value="2">2</option>
											<option value="1">1</option>
										</select>
									</div>
									<div class="col-md-2">
										<input type="submit" class="btn btn-primary"
											value="Add feedback" />
									</div>

									<input type="hidden" id="productId" name="productId"
										value="${product.id}">

								</div>
							</div>
						</form>
					</div>
				</sec:authorize>


				<c:if test="${not empty product.feedbacks}">
					<div class="col-md-12">
						<a href="javascript:changeDisplayStatus()">Feedbacks: </a>
						<div class="allFeedbacks">
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
					</div>
				</c:if>

				<c:if test="${empty product.feedbacks}">
					<div class="col-md-12">
						<h2>No feedbacks</h2>
					</div>
				</c:if>
			</div>
			<div class="panel-footer clearfix">
				<div class="pull-right">
					<c:url value="/cart/add/many" var="addToCart" />
					<form action="${addToCart}" method="post">
						<div class="col-md-6">
							<select id="count" name="count" class="form-control">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
						<div class="col-md-6">
							<input type="hidden" id="productId" name="productId"
								value="${product.id}"> <input type="submit"
								class="btn btn-primary" value="Add to Cart" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</sec:authorize>
