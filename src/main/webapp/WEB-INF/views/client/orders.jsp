<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-9 well">
	<c:if test="${not empty orderList}">
	<h1>Orders</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Order date</th>
					<th>Execution date</th>
					<th> </th>
				</tr>
			</thead>
			<tbody>
				<c:set var="i" value="1"></c:set>
				<c:forEach items="${orderList}" var="order">
					<tr>
						<td>${i}</td>
						<td>${order.orderDate}</td>
						<td>${order.executionDate}</td>
						<td>
						<c:set var="link" value="orders/${order.id}"></c:set>
						<button class="btn btn-info" onclick="location.href='${link}'">More info</button>
						</td>
						<c:set var="i" value="${i + 1}"></c:set>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	<c:if test="${empty orderList}">
	<h1>No orders!</h1>
	</c:if>








</div>