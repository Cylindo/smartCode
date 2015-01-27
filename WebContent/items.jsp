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
		self.quantity = ko.observable(1);
		self.brand = ko.observable(data.itemBrand);
		self.unitPrice = ko.observable(data.itemPrice);
		
	    self.subTotal = ko.computed(function() {
	        subtotal = (parseInt(self.quantity()) * (parseFloat(self.unitPrice())));
	        if (isNaN(subtotal)) return 0;
	        return subtotal ? "R" + subtotal.toFixed(2) : "Free";
	    });
		
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
		
	 	$('.alert-autocloseable-success');
	 	
		$('#addToCart').click(function() {
			$('#addToCart').prop("disabled", true);
			$('.alert-autocloseable-success').show();

			$('.alert-autocloseable-success').delay(5000).fadeOut( "slow", function() {
				// Animation complete.
				$('#addToCart').prop("disabled", false);
			});
		});
		
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
		</div>
		<hr>
		
			<div class="col-md-9">
        <!-- Success messages -->
    	<div class="alert alert-success alert-autocloseable-success">
       		Well done! You added a product to the cart.
        </div>
	</div>

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
							<td class="col-sm-1 col-md-1" style="text-align: center">
							<input class="form-control" data-bind='value: quantity'></td>
							<td class="col-sm-1 col-md-1 text-center"><strong data-bind='text: formattedPrice'> </strong></td>
							<td class="col-sm-1 col-md-1 text-center"><strong data-bind='text: subTotal(), valueUpdate: "afterkeydown"'></strong></td>
							<td class="col-sm-1 col-md-1">
								<button id="addToCart" name="addToCart" type="button" class="btn btn-success">
									<span class="glyphicon glyphicon-plus"></span> Add to Cart
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>



</html>

