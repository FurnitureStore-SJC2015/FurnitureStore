<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-9">
	<sec:authorize access="isAuthenticated() and hasRole('ROLE_COMPANY')">
		<c:if test="${not empty searchCriteria}">
			<c:url var="action" value="/catalog/search/result"></c:url>
			<form:form action="${action }" method="GET"
				commandName="searchCriteria">
				<fieldset>
					<legend>Search Criteria</legend>
					<table>
						<tr>
							<td><label> Minimum cost</label></td>
							<td><form:input path="minCost" /></td>
						</tr>
						<tr>
							<td><label> Maximum cost</label></td>
							<td><form:input path="maxCost" /></td>
						</tr>
					</table>
				</fieldset>
				<input type="submit" value="Search" />
			</form:form>
		</c:if>
	</sec:authorize>

	<sec:authorize
		access="isAuthenticated() and hasAnyRole('ROLE_CLIENT','ROLE_COMPANY') ">
		<c:if test="${not empty products }">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h5 class="text-center">
						<strong><span class="glyphicon glyphicon-list-alt"></span>Catalog</strong>
					</h5>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th></th>
							<th>Description</th>
							<th>Price</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${products}" var="item">
						<tr>
							<td>
								<div class="media">
									<a class="pull-left"> <img
										src="data:image/jpeg;base64,${item.product.image}"
										class="img-thumbnail" alt="${item.product.name }"
										width="175px" height="175px" /> <span
										class="badge badge-success pull-right"> <fmt:formatNumber
												type="number" pattern="0.0" value="${item.range}" /></span></a>
								</div>
							</td>
							<td>
								<h5>${item.product.description }</h5>
							</td>
							<td><sec:authorize access="hasRole('ROLE_COMPANY')">
									<h5><fmt:formatNumber value="${item.product.cost}" maxFractionDigits="2"/></h5>
								</sec:authorize> <sec:authorize access="hasRole('ROLE_CLIENT')">
									<h5><fmt:formatNumber value="${item.product.cost*item.product.coefficient}" maxFractionDigits="3"/></h5>
								</sec:authorize></td>
							<td><c:url var="link"
									value="catalog/product/${item.product.id}" />
								<button class="btn btn-primary btn-md"
									onclick="location.href='${link}'">Show info</button> <sec:authorize
									access="hasRole('ROLE_COMPANY')">
									<c:set var="link" value="product/delete/${item.product.id}" />
									<button class="btn btn-default btn-md"
										onclick="location.href='${link}'">Delete</button>
									<c:set var="link" value="product/edit/${item.product.id}" />
									<button class="btn btn-default btn-md"
										onclick="location.href='${link}'">Edit</button>
								</sec:authorize></td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</c:if>
		<c:if test="${empty products}">
		<h1>No products added</h1>
		</c:if>
	</sec:authorize>
</div>