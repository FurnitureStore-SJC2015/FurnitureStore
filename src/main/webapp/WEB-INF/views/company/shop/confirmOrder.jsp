<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-9">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<strong>Orders to confirm</strong>
			</h5>
		</div>

		<div class="panel-body">
			<div class="col-md-10 col-md-offset-1">
				<c:if test="${empty orders}">
					<h3>No new orders!</h3>
				</c:if>
				<c:if test="${not empty orders}">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>Order date</th>
								<th>Action</th>
							</tr>
						</thead>
						<c:forEach items="${orders}" var="item">
							<tr>
								<td>${item.id}</td>
								<td><fmt:formatDate type="both" dateStyle="medium"
										timeStyle="long" value="${item.orderDate}" /></td>
								<td><c:url var="showOrder"
										value="/order/check/${item.id}" /> <c:url var="confirm"
										value="catalog/product/${item.id}" />
									<button class="btn btn-primary"
										onclick="location.href='${showOrder}'">Show order</button>
									<button class="btn btn-success"
										onclick="location.href='${confirm}'">Confirm</button></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
		<div class="panel-footer clearfix">Some info!</div>
	</div>


</div>