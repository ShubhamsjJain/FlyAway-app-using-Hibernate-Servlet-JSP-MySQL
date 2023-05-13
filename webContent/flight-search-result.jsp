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

.right-align {
text-align: right;
}
</style>


<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>

<%
//Get the flights from the request object (sent by the servlet)
List<Flight> theFlights = (List<Flight>)request.getAttribute("AVAILABLE_FLIGHTS");
%>
<body>

         
         
  <% if(!theFlights.isEmpty()){ %>    
     
     
     <% Flight firstFlight = theFlights.get(0); %>
         <h1 style="margin-left: 50px;mamargin-top:50px;">Results for Flights From <%= firstFlight.getSource() %> to <%= firstFlight.getDestination() %> on <%= firstFlight.getSchedule() %> </h1>
         
         
         <div class="right-align">
         <button type="button" onclick="location.href='index.html'">Back to Previous Page</button>  <br><br> 
         </div>
         <hr>
          
         <TABLE class='center' BORDER="1">
             <tr>
 
                   
                   <TH>Flight Number </TH>  
                   <TH>Departure Time</TH>
                   <TH>Duration in (Hours) </TH>
                   <TH>Arrival Time</TH>
                   <TH>Price in (Rupees)</TH>
                   <TH></TH>
                   
                   
         
            </tr>
           
             
              
                   <% for(Flight f: theFlights) {%>
                
            <tr>
            
            
                    
                     
                           <td><%= f.getFly_Num()%></td>
                           <td><%= f.getDeparture_time()%></td>
                           <td><%= f.getDuration()%></td>
                           <td><%= f.getArrival_time()%></td>
                           <td><%= f.getPrice()%></td>
                    
                           <td><form action="Passenger.jsp">
                        
                        
                                   <input type="hidden" name="flynum" value="<%=f.getFly_Num()%>" />
                                   <input type="submit" value="Book">
                               </form></td>
             
             
                    
 
           </tr>
                   <% } %>
		         
                    
               
         </TABLE>
         
         <% }else{ %>
         
                        <div class="right-align">
                        <button type="button" onclick="location.href='index.html'">Back to Previous Page</button>  <br><br> 
                        </div>
               
                         <h1 align ="center">Sorry!No Flights Found.</h1>
               
               <% } %>
      
        
         
    
</body>
</html>