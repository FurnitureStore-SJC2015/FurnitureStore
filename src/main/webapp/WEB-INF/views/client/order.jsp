<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set var="i" value="1"></c:set>
<c:set var="j" value="1"></c:set>
<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">
	<div class="col-md-9">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h5 class="text-center">
					<strong><span class="glyphicon glyphicon-info-sign"></span>Order
						#${order.id}</strong>
				</h5>
			</div>

			<div class="panel-body">
				<div class="col-md-4 well">
					<address>
						<h3 class="text-center">
							<strong>Order composition:</strong>
						</h3>
						<c:forEach var="orderUnit" items="${order.orderUnits}">
							<c:url var="productLink"
								value="/catalog/product/${orderUnit.productCatalogUnit.id}" />
						${i}<a href="${productLink}">${orderUnit.productCatalogUnit.name}</a> Cost - ${orderUnit.cost}<br>
							<c:set var="i" value="${i + 1}"></c:set>
						</c:forEach>
					</address>
				</div>

				<div class="col-md-7 col-md-offset-1 well ">
					<h3 class="text-center">
						<strong>Payments:</strong>
					</h3>
					<table class="table table-hover table-bordered">
						<thead>
							<tr class="text-center">
								<td>#</td>
								<td>Date</td>
								<td>Sum</td>
								<td>Info</td>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="paymentDto" items="${paymentList}">

								<jsp:useBean id="now" class="java.util.Date" />
								<c:if test="${paymentDto.payment.paymentStatus eq true}">
									<tr class="text-center success">
										<td>${j}</td>
										<td><fmt:formatDate type="date"
												value="${paymentDto.payment.date}" /></td>
										<td>${paymentDto.payment.sum}</td>
										<td>Payed</td>
										<c:set var="j" value="${j + 1}"></c:set>
									</tr>
								</c:if>
								<c:if test="${paymentDto.payment.paymentStatus eq false}">
									<tr class="text-center active">
										<td>${j}</td>
										<td><fmt:formatDate type="date"
												value="${paymentDto.payment.date}" /></td>
										<td>${paymentDto.payment.sum}</td>
										<c:if test="${paymentDto.canBePayed eq false}">
											<td>Not payed</td>
										</c:if>
										<c:if test="${paymentDto.canBePayed eq true}">
											<c:url var="pay"
												value="/payment/${paymentDto.payment.id}/pay" />
											<form action="${pay}" method="post" />
											<td><input type="submit" class="btn btn-success"
												value="Pay now!"></td>
											</form>

										</c:if>

										<c:set var="j" value="${j + 1}"></c:set>
									</tr>
								</c:if>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="panel-footer clearfix">
				<c:url var="toShop" value="/catalog" />
				<a href="${toShop}">To catalog</a>
			</div>
		</div>
	</div>
</sec:authorize>