<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.simplilearn.flyaway.*" %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
table{
 border: 2px solid black;
border-collapse: collapse;
  width: 50%;
}
th, td {
  font-size:20px;
  padding: 10px;
  text-align: center;
  border-bottom: 1px solid #ddd;
}
  
tr:nth-child(even) {background-color: #f2f2f2;}
tr:hover {background-color: coral;}
table.center {

margin: auto; 
}
</style>

<meta charset="ISO-8859-1">
<title>Flights List</title>
</head>

<%
//Get the flights from the request object (sent by the servlet)
List<Flight> theFlights = (List<Flight>)request.getAttribute("LIST_FLIGHTS");
%>
<body>

         <h1 style="margin-left: 50px;mamargin-top:50px;"><h1> All Flights List</h1> 
         <button type="button" onclick="location.href='AdminWelcomePage.jsp'">Back to Previous Page</button><br><br> 
         
         <TABLE class='center' BORDER="1">
             <tr>
 
                   <TH>ID</TH>
                   <TH>Flight Number </TH>
                   <TH>Source </TH>
                   <TH>Destination </TH>
                   <TH>Scheduled date </TH>
                   <TH>Duration in (Hours) </TH>
                   <TH>Arrival Time</TH>
                   <TH>Departure Time</TH>
                   <TH>Price in (Rupees)</TH>
                   <TH>Seats </TH>
                   
         
           </tr>
           
             
                   <% for(Flight f: theFlights) {%>
                
            <tr>
                     <td><%= String.valueOf(f.getID())%></td>
                     <td><%= f.getFly_Num()%></td>
                     <td><%= f.getSource()%></td>
                     <td><%= f.getDestination()%></td>
                     <td><%= f.getSchedule()%></td>
                     <td><%= f.getDuration()%></td>
                     <td><%= f.getArrival_time()%></td>
                     <td><%= f.getDeparture_time()%></td>
                     <td><%= f.getPrice()%></td>
                     <td><%= f.getSeats()%></td>
                     <td><form action="AdminUpdateFrontEnd.jsp">
                            <input type="hidden" name="flynum" value="<%=f.getFly_Num()%>"/>
                            <input type="submit" value="Update">
                        </form></td>
                     <td><form action="AdminDelete.jsp">
                            <input type="hidden" name="flynum" value="<%=f.getFly_Num()%>"/>
                            <input type="submit" value="Delete">
                         </form></td>
             
 
           </tr>
      
		         
               <% } %> 
               
         </TABLE>
        
         
    
</body>
</html>