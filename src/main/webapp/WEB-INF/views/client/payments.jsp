<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-9">
	<c:set var="i" value="1"></c:set>
	<div class="pane panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<strong><span class="glyphicon glyphicon-list-alt"></span>Payments
					for next 30 days</strong>
			</h5>
		</div>

		<div class="panel-body">
			<c:if test="${empty payments}">
				<h3>No payments found!</h3>
			</c:if>


			<c:if test="${not empty payments}">
				<table class="table table-hover table-bordered">
					<thead>
						<tr class="text-center">
							<td>#</td>
							<td>Payment Date</td>
							<td>Sum</td>
							<td>Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="payment" items="${payments}">
							<c:if test="${payment.paymentStatus eq false}">
								<tr class="text-center">
									<td>${i}</td>
									<td><fmt:formatDate type="date" value="${payment.date}" /></td>
									<td>${payment.sum}</td>
									<td><c:url var="toOrder"
											value="/order/${payment.order.id}" /> <a
										class="btn btn-primary" href="${toOrder}">To order</a></td>
									<c:set var="i" value="${i + 1}"></c:set>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>