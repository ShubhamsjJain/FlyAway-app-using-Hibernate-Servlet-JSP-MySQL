<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
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

.bold-red {
font-weight: bold;
color: black;
}
</style>
<meta charset="ISO-8859-1">
<title>Payment info</title>
</head>

<%
//Get the passenger info from the request object (sent by the servlet)
Passenger thePassenger = (Passenger)request.getAttribute("PASSENGER_DETAILS");
%>
<body>

<!-- Now since we have passenger object,we also need object of flight in which passenger wants to travel -->
<!-- so that we can get price details of that flight   -->


     <% FlightDAO flightdao= new FlightDAO();
	    Flight flight = flightdao.getFlightObject(thePassenger.getFlightNumber());
	    
	    if(thePassenger.getNoOfPerson() > flight.getSeats()){%>
	     
   	    <h1><b>Sorry only <%= flight.getSeats() %> seats available.</b></h1>
	 
	    <% }else{
	    	
	    	double paidAmt=(flight.getPrice()*thePassenger.getNoOfPerson());
	    	long millis = System.currentTimeMillis();  
	        java.sql.Date paidDate = new java.sql.Date(millis);
	    	
	    	%>
	    
     
	<table class="center" >
	
	      <tr>
	         <td><b class="bold-red">Flight Details</b></b></td>
	      </tr>
	      
	      
	      <tr>
	          <td>Flight Number:<%= thePassenger.getFlightNumber()%></td>
	          <td>Travel:<%= flight.getSource()%> to  <%= flight.getDestination() %>
	      </tr>
	      
	      <tr>
	          <td>Date:<%= flight.getSchedule() %></td>
	          <td>Time:<%= flight.getDeparture_time() %></td>
	      </tr>
	      
	      <tr>
	          <td>Travel duration:<%= flight.getDuration() %> hrs</td>
	          <td>Ticket Price :<%= flight.getPrice() %> Rs.</td>
	      </tr>
	      
	      <tr>
	          <td><b class="bold-red">Your Details<strong></b></td>
	      </tr>
	      
	      <tr>
	          <td>Name:<%= thePassenger.getFirstName() %> <%= thePassenger.getLastName() %></td>
	          <td>Phone Number:<%= thePassenger.getMobileNumber() %>
	      </tr>
	      
	      <tr>
	          <td>No Of Persons:<%= thePassenger.getNoOfPerson() %></td>
	          <td>Aadhar Number:<%= thePassenger.getAadhar() %></td>
	      </tr>
	      
	      <tr>
	          <td>Total Price:<%= paidAmt %> Rs.</td>
	          <td>Paid Date:<%= paidDate %></td>
	      </tr>
	</table>
	
	
 <div class="content">
 
        <form action="payment" method="get">
             <div class="container">
                    <h1>Payment</h1>
                    
                    <label><b>Card No*</b></label>
                    <input type="text" placeholder="Enter Card No" name="cardNo" required><br>
                    
                    <label ><b>Card Holder Name*</b></label>
                    <input type="text" placeholder="Enter Card Holder name" name="cardHolderName" required><br>
                    
                    <label ><b>Month*</b></label>
                    <input type="text" placeholder="MM" name="MM" required><br>
                    
                    <label ><b>Year*</b></label>
                    <input type="text" placeholder="YYYY" name="YYYY" required><br>
      
                    <label ><b>CVV Number*</b></label>
                    <input type="text" placeholder="Enter CVV" name="CVV" required><br>
                    
                    <input type="hidden" name="command" value="ADD">
                    <input type="hidden" id="paidAmt" name="paidAmt" value="<%= paidAmt %>">
                    <input type="hidden" id="paidDate" name="paidDate" value="<%= paidDate %>"> 
                    <input type="hidden" id="passenger_id" name="passenger_id" value="<%= thePassenger.getID() %>">                 
                    
                    
                   
                    
     
	               <input type="submit" value="Payment and Book">
           </div>
       </form>
    </div>
    
    <% } %>
</body>
</html>