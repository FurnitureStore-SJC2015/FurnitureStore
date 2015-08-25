<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="i" value="1"></c:set>
<div class="col-md-9">

	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 class="text-center">
				<strong>Order #${order.id}</strong>
			</h5>
		</div>

		<div class="panel-body">
			<div class="col-md-3">
				<address>
					<strong>Order composition:</strong>
					<c:forEach var="orderUnit" items="${order.orderUnits}">
						<c:url var="productLink"
							value="/catalog/product/${orderUnit.productCatalogUnit.id}" />
						<br>
						${i}<a href="${productLink}">${orderUnit.productCatalogUnit.name}</a> Cost - ${orderUnit.cost}
						<c:set var="i" value="${i + 1}"></c:set>
				</c:forEach>
				</address>
			</div>

			<!--<h3>Order composition:</h3>
			<div class="col-md-6">
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th>Product ID</th>
							<th>Name</th>
							<th>Cost</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${order.orderUnits}">
							<tr>
								<c:url var="productLink"
									value="/catalog/product/${product.productCatalogUnit.id}" />
								<td><a href="${productLink}">${product.productCatalogUnit.id}</a></td>
								<td>${product.productCatalogUnit.name}</td>
								<td>${product.cost}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>-->
		</div>
		<div class="panel-footer clearfix">
			<c:url var="toShop" value="/catalog" />
			<a href="${toShop}">To catalog</a>
		</div>
	</div>
</div>