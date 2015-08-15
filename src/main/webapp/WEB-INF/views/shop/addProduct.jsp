<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="col-md-9 well">
	<div class="page-header">
		<h1>"You can add new product</h1>
	</div>
	
	<c:url value="/catalog/action/add" var="action"/>
	
	<form:form commandName="product" method="POST" enctype="multipart/form-data">
		
		<form:label path="name">Name:</form:label>
		<form:input path="name" />

		<form:label path="coefficient">Coefficient:</form:label>
		<form:input path="coefficient"/>
		
		<form:label path="description">Description:</form:label>
		<form:textarea path="description"/>
		
		<c:set var = "iterator" value="0"></c:set>
        <c:forEach items="${product.productTemplates}" var = "template">
			<label> ${template.module.moduleType} count</label>
			<input name = "productTemplates[${iterator}].count"/>
			<c:set var = "iterator" value = "${iterator + 1}"></c:set>
		</c:forEach>
		
		<label>Product image</label>
		<input name="productImage" type="file">
		
		
		
	  	<input type="submit" value="Save" />
	  	
	</form:form> 
</div>

