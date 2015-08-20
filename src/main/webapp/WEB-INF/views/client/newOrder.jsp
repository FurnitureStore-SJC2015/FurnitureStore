<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col-md-9">

	<div class="panel panel-success">
		<div class="panel-heading ">
			<h5 class="text-center">
				<span class="glyphicon glyphicon glyphicon-ok"></span> <strong>Your
					order is formed!</strong>
			</h5>
		</div>
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
							<td>${unit.productCatalogUnit.cost}</td>
						</tr>
						<c:set var="i" value="${i + 1}"></c:set>
					</c:forEach>
				</tbody>
			</table>

			<div class="row">
				<div class="col-md-4">
					<div class="text-left">
						<strong>Order date:</strong>
						<fmt:formatDate pattern="yyyy-MM-dd" value="${order.orderDate}" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="text-center">
						<strong>Execution date:</strong>
						<fmt:formatDate pattern="yyyy-MM-dd"
							value="${order.executionDate}" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="text-right">
						<strong>Payments:${order.paymentScheme.numberOfPayments}</strong>
					</div>
				</div>
			</div>


			<div class="pull-left">
				<c:url var="toCart" value="/cart" />

					 <a class="btn btn-primary" href="${toCart}"><span
					class="glyphicon glyphicon-triangle-left"></span>To cart</a>
			</div>
			<div class="pull-right">
				<form action="${confirm}" method="POST">
					<input type="submit" class="btn btn-success" value="Confirm order">
					<input type="hidden" id="paymentScheme" name="paymentScheme"
						value="${order.paymentScheme.id}">
				</form>
			</div>
		</div>
	</div>
</div>