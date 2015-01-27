<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
<script type="text/javascript" src="resources/js/knockout.js"></script>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	//$("#getBtn").click(function(e){

	function orderItem(data) {
		var self = this;

		self.id = ko.observable(data.itemId);
		self.name = ko.observable(data.itemName);
		self.description = ko.observable(data.itemDescription);
		self.quantity = ko.observable(data.itemQuantity);
		self.price = ko.observable(data.itemPrice);
	}

	function itemViewModel() {
		
		var self = this;
		
		self.orderItems = ko.observableArray([]);
		
		self.getItems = function() {
		
		$.getJSON('http://localhost:8080/RESTfulKnockout/api/itemresources/getAllProducts', function(allData) {
			console.log(allData);
			
            var mappedData= $.map(allData, function(data) { return new orderItem(data) });
            
            	self.orderItems(mappedData);
            	console.log(self.orderItems());
        	});
		}
		
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
	            quantity: "",
	            price: ""
	        });
	    };
		
	}

		ko.applyBindings(new itemViewModel());
	});
//});
</script>

</head>
<body>
<div class="container">
		<div class="j">

			<h3>Items Application</h3>

			<table>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
				<tbody data-bind="foreach: orderItems">
					<tr>
						<td><input type="text" class="form-control" data-bind='value: id' /></td>
						<td><input type="text" class="form-control" data-bind='value: name' /></td>
						<td><input type="text" class="form-control" data-bind='value: description' /></td>
						<td><input type="text" class="form-control" data-bind='value: quantity' /></td>
						<td><input type="text" class="form-control" data-bind='value: price' /></td>
					</tr>
				</tbody>
			</table>

			<div>
				<button data-bind="click: addOrderItem">New Order Item</button>
				<button data-bind="click: getItems">Get all items</button>
				
				<br> <input type="submit" class="btn btn-primary" id="postBtn" value="Post Items">
			</div>
		</div>

	</div>
</body>
</html>