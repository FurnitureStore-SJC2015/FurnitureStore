<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="col-md-9 well">
	<div class="page-header">
		<h1>"${product.name}" information</h1>
	</div>
	
	<div class="col-md-6">
		<img src="data:image/jpeg;base64,${product.image}" class="img-thumbnail">
	</div>
	
	<c:url var="addToCart" value="/cart/add/${product.id}"></c:url>
	<form:form action = "${addToCart}" method="POST" commandName="product">
		<label> Count </label>
		<form:input path="cost"/>
		
		<input type="submit" value="Add to shopping cart" />
		
	</form:form>
	
	<div class = "row">
		<div class="col-md-12">
			<h1>Description</h1>
			<h3>${product.description}</h3>
		</div>
		
		
		<div class="col-md-9">
			<table class="table">
				<thead>
					<tr>
						<th>
							<h1>Product characteristics</h1>
						</th>
					</tr>
				</thead>
				<tr>
					<td>
						Product name
					</td>
					<td>
						${product.name}
					</td>
				</tr>
				<tr>
					<td>
						Cost
					</td>
					<td>
						${product.cost}
					</td>
				</tr>
				<c:if test="${ product.sale != 0 }">
					<tr>
						<td>
							Sale
						</td>
						<td>
							${product.sale}
						</td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>
</div>
