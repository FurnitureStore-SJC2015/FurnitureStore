<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$("#confirmationDate").datepicker({
			minDate : 0
		});

	});

	function buttonEffect() {
		$("#submitButton").show();
	}
</script>
<sec:authorize
	access="isAuthenticated() and hasAnyRole('ROLE_COMPANY','ROLE_CLIENT')">
	<div class="col-md-9">
		<sec:authorize access="hasRole('ROLE_CLIENT')">
			<div class="panel panel-success">
				<div class="panel-heading ">
					<h5 class="text-center">
						<span class="glyphicon glyphicon glyphicon-ok"></span> <strong>Your
							order is formed!</strong>
					</h5>
				</div>
		</sec:authorize>

		<sec:authorize access="hasRole('ROLE_COMPANY')">
			<c:if test="${flag eq false}">
				<div class="panel panel-danger">
					<div class="panel-heading ">
						<h5 class="text-center">
							<span class="glyphicon glyphicon-warning-sign"></span> <strong>
								Order ${order.id}</strong>
						</h5>
					</div>
			</c:if>
			<c:if test="${flag eq true}">
				<div class="panel panel-success">
					<div class="panel-heading ">
						<h5 class="text-center">
							<span class="glyphicon glyphicon glyphicon-ok"></span> <strong>
								Order ${order.id}</strong>
						</h5>
					</div>
			</c:if>

		</sec:authorize>
		<div class="panel-body">
			<table class="table table-bordered table-striped">
				<tr>
					<h3>
						<strong>Order composition:</strong>
					</h3>
				</tr>
				<thead>
					<tr>
						<td><strong>#</strong></td>
						<td><strong>Product Name</strong></td>
						<td><strong>Cost:</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:set var="i" value="1"></c:set>
					<c:forEach var="unit" items="${order.orderUnits}">
						<tr>
							<td>${i}</td>
							<td>${unit.productCatalogUnit.name }</td>
							<td><fmt:formatNumber value="${unit.cost}"
									maxFractionDigits="2" /></td>
						</tr>
						<c:set var="i" value="${i + 1}"></c:set>
					</c:forEach>
				</tbody>
			</table>


			<sec:authorize access="hasRole('ROLE_CLIENT')">
				<div class="text-left">
					<strong><h3>Current Bonus:
							${sessionScope.loggedClient.profile.bonus.percentage} %</h3></strong>
				</div>
			</sec:authorize>
			<div class="row">
				<div class="col-md-4">
					<div class="text-left">
						<strong>Order date:</strong>
						<fmt:formatDate pattern="yyyy-MM-dd" value="${order.orderDate}" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="text-center">
						<strong>Order term : ${order.paymentScheme.term} days</strong>
					</div>
				</div>
				<div class="col-md-4">
					<div class="text-right">
						<strong>Payments:${order.paymentScheme.numberOfPayments}</strong>
					</div>
				</div>
			</div>

		</div>
		<div class="panel-footer clearfix">
			<sec:authorize access="hasRole('ROLE_CLIENT')">
				<div class="pull-left">
					<c:url var="toCart" value="/cart" />

					<a class="btn btn-primary" href="${toCart}"><span
						class="glyphicon glyphicon-triangle-left"></span>To cart</a>
				</div>

				<div class="pull-right">
					<c:url var="confirm" value="/order/save" />
					<form action="${confirm}" method="POST">
						<input type="submit" class="btn btn-success" value="Confirm order">
						<input type="hidden" id="paymentScheme" name="paymentScheme"
							value="${order.paymentScheme.id}">
					</form>
				</div>
			</sec:authorize>

			<sec:authorize access="hasRole('ROLE_COMPANY')">
				<c:if test="${flag eq true}">
					<div class="row">

						<div class="col-md-2">
							<strong>Assembly date:</strong>
						</div>
						<c:url value="/order/confirm" var="confirm" />
						<form action="${confirm}" method="POST">
							<div class="col-md-4">
								<div class="form-group">
									<div class='input-group date' id='datetimepicker1'
										onclick="buttonEffect()">
										<input type='text' id="confirmationDate"
											name="confirmationDate" class="form-control" /> <span
											class="input-group-addon"> <span
											class="glyphicon glyphicon-calendar"></span></span>
									</div>
								</div>
							</div>

							<input type="submit" style="display: none;" id="submitButton"
								name="submitButton" class="btn btn-success"
								value="Confirm order" onchange="buttonEffect()"> <input
								type="hidden" id="orderId" name="orderId" value="${order.id}">

						</form>

					</div>
				</c:if>


				<c:if test="${flag eq false}">
					<div class="row">
						<div class="col-md-3">
							<strong class="text-danger">Not enough modules!</strong>
						</div>
						<div class="col-md-4">

							<c:url var="link" value="/requests/order/${order.id}" />
							<button class="btn btn-promary" onclick="location.href=${link}">Order
								modules</button>
						</div>
					</div>
				</c:if>
			</sec:authorize>
		</div>
	</div>
	</div>
	</div>
</sec:authorize>