<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-9 well">
	<div class="row">
		<div class="col-md-3">Here goes picture!</div>
		<div class="col-md-6">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>General Info</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><strong>Name:</strong></td>
						<td><strong>${user.name}</strong></td>
					</tr>
					<tr>
						<td><strong>Surname:</strong></td>
						<td><strong>${user.surname}</strong></td>
					</tr>
					<tr>
						<td><strong>E-mail:</strong></td>
						<td><strong>${user.email}</strong></td>
					</tr>
					<tr>
						<td><strong>Current Bonus:</strong></td>
						<td><strong>${user.bonus.percentage} %</strong></td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>

	<div class="row">Here goes top-5 future bills</div>
</div>


