<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.simplilearn.flyaway.*" %>
<!DOCTYPE html>
<html>
<head>

<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}
.content {
  max-width: 500px;
 margin-left: 350px; 
  margin-right: 150px;
  margin-top:50px;
}

table{
 border: 2px solid black;
border-collapse: collapse;
  width: 50%;

}
th, td {

  font-size:20px;
  padding: 10px;
  
  border-bottom: 1px solid #ddd;
}
  
tr:nth-child(even) {background-color: #f2f2f2;}

table.center {
  margin-left: 300px; 
  margin-right: 100px;
  margin-top:10px;
}
</style>
<meta charset="ISO-8859-1">
<title>Booking Confirmation</title>
</head>

<%
//Get the payment info from the request object (sent by the servlet)
Payment thePayment = (Payment)request.getAttribute("CONFIRM_PAYMENT");
%>

<body>

<%

//Now since the booking is confirmed, reduce number of seats from flight and update new number of seats

Passenger passenger = thePayment.getPassenger();
FlightDAO flightdao = new FlightDAO();
flightdao.updateSeatsInFlight(passenger);
 
%>

<h1>Ticket Booked successfully </h1>
<p><h4><b>Take screenshot of your ticket</b></h4></p>

<% 

// Getting flight objject of respective flight number

Flight flight = flightdao.getFlightObject(passenger.getFlightNumber());
%>
    <table class="center" >
    
	    <tr>
	        <td><b>Flight Details</b></td>
	    </tr>
	    
	    <tr>
	        <td>Flight Number: <%= passenger.getFlightNumber() %></td>
	        <td>Travel: <%= flight.getSource() %> to <%= flight.getDestination() %></td>
	    </tr>
	    
	    <tr>
	        <td>Date: <%= flight.getSchedule() %></td>
	        <td>Time: <%= flight.getDeparture_time() %></td>
	    </tr>
	    
	    <tr>
	        <td>Travel duration: <%= flight.getDuration() %> hrs</td>
	        <td>Ticket Price : <%= flight.getPrice() %> Rs</td>
	    </tr>
	    
	    <tr>
            <td><b>Your Details</b></td>
            
        </tr>
            
	    <tr>
	        <td>Name: <%= passenger.getFirstName() %> <%= passenger.getLastName() %></td>
	        <td>Phone Number: <%= passenger.getMobileNumber() %></td>
	    </tr>
	    
	    <tr>
	        <td>No Of Persons: <%= passenger.getNoOfPerson() %></td>
	        <td>Aadhar Number: <%= passenger.getAadhar() %></td>
	    </tr>
	    
	    <tr>
	        <td>Total Price: <%= thePayment.getPaidAmount() %> Rs</td>
	        <td>Date: <%= thePayment.getPaidDate() %></td>
	    </tr>
	</table>
</body>
</html>