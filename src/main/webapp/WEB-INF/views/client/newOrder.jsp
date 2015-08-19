<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col-md-9 well">
	<div class="col-md-12">
		<h1 class="text-center">Your order is formed!</h1>
	</div>

	<div class="col-md-8 col-md-offset-2">
		<table class="table table-bordered table-striped">
			<tr>
				<strong>Order composition:</strong>
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
						<td>${unit.productCatalogUnit.cost}</td>
					</tr>
					<c:set var="i" value="${i + 1}"></c:set>
				</c:forEach>
			</tbody>
		</table>
		<div class="col-md-6">
			<strong>Order date:</strong>
			<fmt:formatDate pattern="yyyy-MM-dd" value="${order.orderDate}" />
		</div>
		<div class="col-md-6">
			<strong>Execution date:</strong>
			<fmt:formatDate pattern="yyyy-MM-dd" value="${order.executionDate}" />
		</div>
	</div>



	<div class="col-md-4 col-md-offset-4">
		<c:url var="confirm" value="/order/save" />
		<form action="${confirm}" method="POST">
		<input type="hidden" id="paymentScheme" name="paymentScheme" value="${order.paymentScheme.id}">
			<input type="submit" value="Configm order">
		</form>
	</div>
</div>





