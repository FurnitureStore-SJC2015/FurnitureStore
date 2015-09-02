<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<script src="//canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript">
	    function showChart(values, year) {
		
		var chart = new CanvasJS.Chart("chartContainer", {
			theme : "theme2",
			title : {
				text : "Gain Statistics For " + year
			},
			animationEnabled : true, 
			data : [ {
				type : "column",
				dataPoints : [ {
					label : "jan",
					y : values[0]
				}, {
					label : "feb",
					y : values[1]
				}, {
					label : "mar",
					y : values[2]
				}, {
					label : "apr",
					y : values[3]
				}, {
					label : "may",
					y : values[4]
				},
				   {
					label : "jun",
					y : values[5]
				},
				   {
					label : "jul",
					y : values[6]
				},
				   {
					label : "aug",
					y : values[7]
				},
				   {
					label : "sep",
					y : values[8]
				},
				   {
					label : "oct",
					y : values[9]
				},
				   {
					label : "nov",
					y : values[10]
				},
				   {
					label : "dec",
					y : values[11]
				}
				]
			} ]
		});
		chart.render();
		$("#chartContainer").show(1000);
	}
</script>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_PROVIDER')">
	<div class="col-md-9 ">

		<div class="panel panel-default">
			<div class="panel-heading ">
				<h5 class="text-center">
					<span class="glyphicon glyphicon-user"></span> <strong>${provider.name}'s
						profile</strong>
				</h5>
			</div>
			<div class="panel-body">

				<c:if test="${not empty provider.avatar}">
					<div class="col-md-4">
						<img src="data:image/jpeg;base64,${provider.avatar}"
							class="img-thumbnail">
					</div>
				</c:if>
				<div class="col-md-8">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><strong>Name:</strong></td>
								<td><strong>${provider.name}</strong></td>
							</tr>
							<tr>
								<td><strong>Surname:</strong></td>
								<td><strong>${provider.surname}</strong></td>
							</tr>
							<tr>
								<td><strong>E-mail:</strong></td>
								<td><strong>${provider.email}</strong></td>
							</tr>
							<tr>
								<td><strong>Provider name:</strong></td>
								<td><strong>${provider.providerName} </strong></td>
							</tr>

							<tr>
								<td><strong>Provider phone:</strong></td>
								<td><strong>${provider.phone} </strong></td>
							</tr>
							<tr>
								<td><strong>Zip code:</strong></td>
								<td><strong>${provider.zipCode} </strong></td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="col-md-12" align="center">
				<button class="btn btn-primary"
											onclick="showChart(${values},${year})">SHOW GAIN STATISTICS FOR ${year}</button>
					<div id="chartContainer" style="display: none; height: 400px; width: 60%; display: none;"></div>
				</div>


			</div>

			<div class="panel-footer clearfix">

				<div class="pull-right">
					<c:url var="edit" value="/provider/profile/edit" />
					<a href="${edit}" class="btn btn-primary">Edit profile</a>
				</div>
			</div>
		</div>
	</div>
</sec:authorize>

