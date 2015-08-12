<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="col-md-9 well">
	<div class="page-header">
		<h1>"${company.companyName}" information</h1>
	</div>
	
	<div class = "row">
		<div class="col-md-12">
			<h1>Description</h1>
			<h3>${company.description}</h3>
		</div>
		
		
		<div class="col-md-9">
			<table class="table">
				<thead>
					<tr>
						<th>
							<h1>Company props</h1>
						</th>
					</tr>
				</thead>
				<tr>
					<td>
						Company name
					</td>
					<td>
						${company.companyName}
					</td>
				</tr>
				<tr>
					<td>
						Email
					</td>
					<td>
						${company.email}
					</td>
				</tr>
				<tr>
					<td>
						Company address
					</td>
					<td>
						${company.address}
					</td>
				</tr>
				<tr>
					<td>
						ZIP code
					</td>
					<td>
						${company.zip}
					</td>
				</tr>
				<tr>
					<td>
						director
					</td>
					<td>
						${company.director}
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>