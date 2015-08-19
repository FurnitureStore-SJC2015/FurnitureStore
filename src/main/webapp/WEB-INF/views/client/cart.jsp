<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<c:url var="getPaymentForms" value="/payment/forms" />
<script type="text/javascript">


function removeFromCart(i) {
	$.ajax({
		url : "cart/delete/" + i,
		type : "POST",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(obj) {
			var temp=$("#record"+i);
			temp.fadeOut(800, function(){
                temp.remove();
            });
			
			location.reload();
		}
	});
}


function getPaymentForms(){
	$.ajax({
		url : "payment/forms/",
		type : "POST",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(paymentForms) {
			$('#selector').empty();
			//$("#selector")[0].options.add( new Option(id,value));
			$("#selector")[0].options.add( new Option("<-- Select -->","0"));
			
			for (i=0;i<paymentForms.length;i++){
				var id=paymentForms[i]["id"];
				var value=paymentForms[i]["name"];
				$("#selector")[0].options.add( new Option(value,id));
			}
			$(".panel").slideToggle("slow");
			
			
			
			
		}
	});
}

function getPaymentSchemes(){
	
	var paymentFormId = $('#selector option:selected').val();
	var paymentType=$( "#selector option:selected" ).text();
	var json={id:paymentFormId, name: paymentType };
	$.ajax({
		url : "payment/schemes/",
		type : "POST",
		data: JSON.stringify(json),
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(paymentSchemes) {
			$('#schemeSelector').empty();
			
			if (paymentSchemes.length==0){
				$(".calculateButton").hide();
			}
			else $(".calculateButton").show();

			for (i=0;i<paymentSchemes.length;i++){
				var id=paymentSchemes[i]["id"];
				var term=paymentSchemes[i]["term"];
				var penalty=paymentSchemes[i]["penalty"];
				var numberOfPayments=paymentSchemes[i]["numberOfPayments"];
				var persentage=paymentSchemes[i]["percentage"];
				var value="term: "+term+" days, payments:"+numberOfPayments+", under "+persentage+"%";
				$("#schemeSelector")[0].options.add( new Option(value,id));
			}			
		}
	});
	
	

}

</script>

<sec:authorize access="isAuthenticated() and hasRole('ROLE_CLIENT')">

	<div class="col-md-7">
		<c:if test="${empty shoppingCart.items}">
			<h3>You have no products added!</h3>
			<c:set var="toShop" value="catalog"></c:set>
			<a href="${toShop}">To catalog</a>
		</c:if>

		<c:if test="${not empty shoppingCart.items}">
			<c:set var="i" value="1"></c:set>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Shopping cart</th>
					</tr>
					<tr>
						<th>#</th>
						<th>Product Name</th>
						<th>Product Price</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${shoppingCart.items}">
						<tr id="record${i}">
							<td>${i}</td>
							<td>${item.name}</td>
							<td>${item.cost}</td>
							<td>
								<button class="btn btn-primary" onclick="removeFromCart(${i})">Delete</button>
							</td>
							<c:set var="i" value="${i + 1}"></c:set>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
				<tr>
				<td></td>
				<td>Total price:</td>
				<td>${shoppingCart.totalPrice}</td>
				</tr>
				</tfoot>
			</table>
			<button type="button" class="btn btn-link"
				onclick="getPaymentForms()">Choose payment scheme</button>
		</c:if>


		<div class="row">
			<c:url var="checkNewOrder" value="/order/check"></c:url>
			<form name="selectFormAndScheme" action="${checkNewOrder}" method="post">
				<div class="panel" style="display: none;">
					<div class="form-group">
						<div class="col-md-3">
							<label for="selector">Payment Form:</label> <select
								name="selector" class="form-control" id="selector"
								onclick="getPaymentSchemes()">
							</select>
						</div>
						<div class="col-md-6">
							<label for="schemeSelector">Select Payment Scheme</label> <select
								name="schemeSelector" class="form-control" id="schemeSelector"
								onchange="showButton()">
							</select>
						</div>
						<div class="col-md-3">
							<div class="calculateButton" style="display: none;">
								<label>Process ordering</label> 
								<input type="submit"
									class="btn btn-success" value="Process order!"/>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</sec:authorize>