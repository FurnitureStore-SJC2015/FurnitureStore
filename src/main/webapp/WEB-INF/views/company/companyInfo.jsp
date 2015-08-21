<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<sec:authorize access="isAuthenticated() and hasRole('ROLE_COMPANY')">
	<div class="col-md-9">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h5 class="text-center">
					<span></span><strong>${company.companyName}</strong>
				</h5>
			</div>
			<div class="panel-body">
				<h1>Description</h1>
				<h3>${company.description}</h3>
			</div>
			<table class="table table-hover table-stripped">
				<thead>
				</thead>
				<tr>
					<td>Email</td>
					<td>${company.email}</td>
				</tr>
				<tr>
					<td>Company address</td>
					<td>${company.address}</td>
				</tr>
				<tr>
					<td>ZIP code</td>
					<td>${company.zip}</td>
				</tr>
				<tr>
					<td>director</td>
					<td>${company.director}</td>
				</tr>
			</table>

		</div>



	</div>


	<div class="row">



		<div class="col-md-9"></div>
	</div>
	</div>
</sec:authorize>