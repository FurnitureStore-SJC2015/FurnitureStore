<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>






<div class="col-md-9">
	<div class="col-md-4 col-md-offset-4">
		<h2>Order info</h2>

	</div>

	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<td>Payment Date</td>
				<td>Payment Sum</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="payment" items="${order.payments}">
				<tr>
					<td><strong><fmt:formatDate pattern="yyyy-MM-dd"
								value="${payment.date}" /></strong></td>
					<td><strong>${payment.sum }</strong></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>














	${payment.sum}

</div>