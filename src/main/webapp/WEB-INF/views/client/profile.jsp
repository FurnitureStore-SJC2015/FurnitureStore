<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-9 well">
	<div class="row">
		<div class="col-md-3">
			<img src="data:image/jpeg;base64,${profile.encodedAvatar}" class="img-thumbnail">
		</div>
		<div class="col-md-6">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Personal info:</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><strong>Name:</strong></td>
						<td><strong>${profile.client.name}</strong></td>
					</tr>
					<tr>
						<td><strong>Surname:</strong></td>
						<td><strong>${profile.client.surname}</strong></td>
					</tr>
					<tr>
						<td><strong>E-mail:</strong></td>
						<td><strong>${profile.client.email}</strong></td>
					</tr>
					<tr>
						<td><strong>Current Bonus:</strong></td>
						<td><strong>${profile.client.bonus.percentage} %</strong></td>
					</tr>
				</tbody>
			</table>
			<button type="button" class="btn btn-primary"
				onclick="location.href='edit'">Edit profile</button>
		</div>
	</div>

	<div class="row">Here goes top-5 future bills</div>
</div>


