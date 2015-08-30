<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_COMPANY')">
	<div class="col-md-9 well">

		<c:url value="/catalog/action/add" var="action" />
		<div class="panel-body">
			<form:form commandName="product" method="POST"
				enctype="multipart/form-data">

				<fieldset>
					<legend>Add new product</legend>

					<div class="form-group">
						<form:label path="name">Name:</form:label>
						<form:input path="name" />
					</div>

					<div class="form-group">
						<form:label path="coefficient">Coefficient:</form:label>
						<form:input path="coefficient" />
					</div>

					<div class="form-group">
						<form:label path="description">Description:</form:label>
						<form:textarea path="description" />
					</div>

					<c:set var="iterator" value="0"></c:set>
					<c:forEach items="${product.productTemplates}" var="template">
						<div class="form-group">
							<label> ${template.module.moduleType} count</label> <input
								name="productTemplates[${iterator}].count" />

						</div>
						<c:set var="iterator" value="${iterator + 1}"></c:set>
					</c:forEach>

					<div class="form-group">
						<label>Product image</label> <input name="productImage"
							type="file">
					</div>

				</fieldset>

				<input type="submit" value="Save" />

			</form:form>
		</div>
	</div>
</sec:authorize>