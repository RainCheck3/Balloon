$(document).ready(function() { 
	$('#updateBtn').click(function(event) {
	        // get the form data
	        // there are many ways to get this data using jQuery (you can use the class or id also)	
	        // process the form
	        $.ajax({
	            type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
	            url         : 'acnt', // the url where we want to POST
	            data        : $('#updateCustomer').serialize(), // our data object
	            success		: function(result){
	            	$("#updateResponse").html("Account Info Updated");
	            	$("#hello").html("<p>Hello " + result + "</p>");
	            }
	        })
	            // using the done promise callback
	            .done(function(data) {
	
	                // log data to the console so we can see
	                console.log(data);
	
	                // here we will handle errors and validation messages
	            });
	
	        // stop the form from submitting the normal way and refreshing the page
	        event.preventDefault();
	    });
});