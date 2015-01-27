<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Heaven</title>

<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/knockout.js"></script>
<script src="resources/js/sammy.js"></script>
<script src="resources/js/bootstrap.js"></script>

<script type="text/javascript">
$(document).ready(function() {

	function product(data) {
		var self = this;

		self.id = ko.observable(data.itemId);
		self.name = ko.observable(data.itemName);
		self.description = ko.observable(data.itemDescription);
		//self.price = ko.observable(data.itemPrice);
		self.brand = ko.observable(data.itemBrand);
		
	    self.formattedPrice = ko.computed(function() {
	        var price = data.itemPrice;
	        return price ? "R" + price.toFixed(2) : "Free";        
	    });  
	}

	function itemViewModel() {
		
		var self = this;
		
		self.products = ko.observableArray([]);
		
		$.getJSON('http://localhost:8080/RESTfulKnockout/api/itemresources/getAllProducts', function(allData) {
			console.log(allData);
			
            var mappedData= $.map(allData, function(data) { return new product(data) });
            
            	self.products(mappedData);
            	console.log(self.products());
        	});
		
		self.postItems = function() {
	        $.ajax('http://localhost:8080/RESTfulKnockout/api/itemresources/save', {
	            data: ko.toJSON({ tasks: self.tasks }),
	            type: "post", contentType: "application/json",
	            success: function(result) { alert(result) }
	        });
		}
		
	    self.addOrderItem = function() {
	        self.orderItems.push({
	            id: "",
	            name: "",
	            description: "",
	            price: "",
	            brand: ""
	        });
	    };
		
	}

		ko.applyBindings(new itemViewModel());
	});

</script>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">

		<hr>
		<div class="container">
			<div class="row-fluid">
				<div class="jumbotron">
					<h1>Welcome to the Shopping Factory</h1>
					<p>This is the largest online shopping website of its kind. We
						stock all kinds of goods that we can have delivered to you for
						free.</p>
				</div>
			</div>
		
		<hr>

		<div class="row">
			<div class="col-sm-12 col-md-10 col-md-offset-1">
				<table>
					<thead>
						<tr>
							<th>Product</th>
							<th>Quantity</th>
							<th class="text-center">Price</th>
							<th class="text-center">Total</th>
							<th> </th>
						</tr>
					</thead>
					<tbody data-bind="foreach: products">
						<tr>
							<td class="col-sm-8 col-md-6">
								<div class="media">
									<a class="thumbnail pull-left" href="#"> <img
										class="media-object" src="resources/product-icon.png"
										style="width: 72px; height: 72px;">
									</a>
									<div class="media-body">
										<h4 class="media-heading" data-bind='text: name'></h4>
										
										<h5 class="media-heading" data-bind='text: brand'></h5>
										<span>Status: </span><span class="text-success"><strong>In
												Stock</strong></span>
									</div>
								</div>
							</td>
							<td class="col-sm-1 col-md-1" style="text-align: center"><input
								type="email" class="form-control" value="0"></td>
							<td class="col-sm-1 col-md-1 text-center"><strong data-bind='text: formattedPrice'> </strong></td>
							<td class="col-sm-1 col-md-1 text-center"><strong>$14.61</strong></td>
							<td class="col-sm-1 col-md-1">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Remove
								</button>
							</td>
						</tr>
						
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td><h5>Subtotal</h5></td>
							<td class="text-right"><h5>
									<strong>$24.59</strong>
								</h5></td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td><h5>Estimated shipping</h5></td>
							<td class="text-right"><h5>
									<strong>$6.94</strong>
								</h5></td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td><h3>Total</h3></td>
							<td class="text-right"><h3>
									<strong>$31.53</strong>
								</h3></td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td>
								<button type="button" class="btn btn-default">
									<span class="glyphicon glyphicon-shopping-cart"></span>
									Continue Shopping
								</button>
							</td>
							<td>
								<button type="button" class="btn btn-success">
									Checkout <span class="glyphicon glyphicon-play"></span>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>

