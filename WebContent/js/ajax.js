$(document).ready(function() { 
	$('#updateBtn').click(function(event) {
	        // get the form data
	        // there are many ways to get this data using jQuery (you can use the class or id also)
	        var formData = {
	            'fName'             : $("input[name='fName']").val(),
	            'lName'             : $("input[name='lName']").val(),
	            'email'    			: $("input[name='email']").val(),
	            'street'			: $("input[name='street'").val(),
	            'city'				: $("input[name='city'").val(),
	            'state'				: $("input[name='state'").val(),
	            'zip'				: $("input[name='zip'").val(),
	            'country'			: $("input[name='country'").val()
	        };
	
	        // process the form
	        $.ajax({
	            type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
	            url         : 'rest/account/upd', // the url where we want to POST
	            data        : formData, // our data object
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