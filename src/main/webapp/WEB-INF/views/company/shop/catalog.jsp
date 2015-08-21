<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_COMPANY')">


	<div class="col-md-9 well">
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

		<c:if test="${not empty products }">
			<div class="col-md-15 well">
				<div class="page-header">
					<h3>Products catalog</h3>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Description</th>
							<th>Approximate price</th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${products }" var="product">
						<tr>
							<td><a class="pull-left" href="#"> <img
									src="data:image/jpeg;base64,${product.image}"
									class="media-object" alt="${product.name }" height="150"
									width="150">
							</a></td>
							<td>
								<h5>${product.description }</h5>
							</td>
							<td>
								<h5>${product.cost }</h5>
							</td>
							<td>
								<div>
									<c:set var="link" value="product/${product.id}" />
									<button class="btn btn-default btn-md"
										onclick="location.href='${link}'">Show info</button>
								</div>
								<div>
									<c:set var="link" value="product/delete/${product.id}" />
									<button class="btn btn-default btn-md"
										onclick="location.href='${link}'">Delete</button>
								</div>
								<div>
									<c:set var="link" value="product/edit/${product.id}" />
									<button class="btn btn-default btn-md"
										onclick="location.href='${link}'">Edit</button>
								</div>
							</td>
						</tr>

					</c:forEach>
				</table>

			</div>
		</c:if>
	</div>
</sec:authorize>