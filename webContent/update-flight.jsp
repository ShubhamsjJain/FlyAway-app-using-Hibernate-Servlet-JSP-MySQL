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
  padding: 10px;
  margin: 4px 0 15px 0;
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
  margin: auto;
}

</style>
<meta charset="ISO-8859-1">
<title>Update Flight Form</title>
</head>

<% 
//Get flight object from servlet
Flight flight = (Flight)request.getAttribute("LOAD_FLIGHT"); 
%>

<body>

  <div class="content">

	   <form action="flight" method="get" style="border:1px solid #ccc">
	   
	           <div class="container">
	           
	                <h2>Add Updated Flight information</h2>
	                <hr>
	                
	                <input type="hidden" name="command" value="UPDATE"/>
	                
		            <label>Flight Number</label> 
		            <input type="text" name="flyno" value="<%= flight.getFly_Num() %>"/><br><br>
		
		            <label>Source</label> 
		            <input type="text" name="src" value="<%= flight.getSource() %>"/><br><br>
		
		            <label>Destination</label> 
		            <input type="text" name="dest" value="<%= flight.getDestination() %>"/><br><br>
		
		            <label> Seats</label> 
		            <input type="text" name="seats" value="<%= flight.getSeats() %>"  /><br><br>
		
		            <label>Duration</label> 
		            <input type="text" name="duration" value="<%= flight.getDuration() %>"  /><br><br>
		
		            <label>Price</label> 
		            <input type="text" name="price" value="<%= flight.getPrice() %>" /><br><br>
		            
		             <label>Departure Time</label> 
		            <input type="time" name="deptime" value="<%= flight.getDeparture_time() %>"/><br><br>
		
		            <label>Arrival Time</label> 
		            <input type="time" name="arrtime" value="<%= flight.getArrival_time() %>"/><br><br>
		
		
		            <label> scheduled Date</label> 
		            <input type="date" name="schdate" value="<%= flight.getSchedule() %>"><br><br>
		
		
		
		
		            <input type="submit" name="operation" value="Submit"/>
		      </div>
	   </form>
</div>
</body>
</html>