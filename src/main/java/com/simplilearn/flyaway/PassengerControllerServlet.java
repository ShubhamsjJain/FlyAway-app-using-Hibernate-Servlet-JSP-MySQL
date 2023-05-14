package com.simplilearn.flyaway;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PassengerControllerServlet
 */
@WebServlet("/PassengerControllerServlet")
public class PassengerControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private PassengerDAO passengerdao;
    
    public PassengerControllerServlet() {
        
    }

	
	@Override
	public void init() throws ServletException {
		
		//Create PassengerDAO object in init So that as soon as servlet starts it will create PassengerDAO object and hence PassengerDAO constuctor will be called where SessionFactory object is created.
		passengerdao = new PassengerDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
try {
			
			String theCommand = request.getParameter("command");   // taking command parameter having value ADD or UPDATE or DELETE
			
			// if theCommand is missing,default it to listflights
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand){
			        
			
			    case "LIST":
				
		        //List the flights in MVC fashion 
		    
		        
			
			    case "ADD":
			
			        //Add the passenger in MVC fashion 
			    
			        passengerAdd(request,response);    //Provided below
			        break;
			        
			        
			        
			    case "LOAD":
			    	
			    	//Load all flight info from database based on flight number got from list-flights.jsp
			    	
			    	
			    	
			    	
			    case "UPDATE":
			    	
			    	//Update the flight in MVC fashion 
			    	
			    	
			    	
			    	
			    	
                case "DELETE":
			    	
			    	//Delete the flight in MVC fashion 
			    	
                	
			        
			        
               case "SEARCH":
			    	
			    	//Search the flight in MVC fashion 
			    	
                	
			        
			    	
			        
			     default:
			    	 
			    	  //Provided below
					 
			    	 
			
			}
			
			
			
		} catch (Exception e) {
						
			e.printStackTrace();
		}
	}

	
	private void passengerAdd(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String flyno = request.getParameter("flyno");
		String firstname= request.getParameter("firstname");
		String lastname= request.getParameter("lastname");
		Long phoNo=Long.parseLong(request.getParameter("phoneno"));
		Integer noOfPerson=Integer.parseInt(request.getParameter("pxc"));
		String aadhar= request.getParameter("addr");
		
		Passenger passenger  = passengerdao.addPassenger(flyno, firstname, lastname, phoNo, noOfPerson, aadhar);
	
		request.setAttribute("PASSENGER_DETAILS", passenger);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("payment.jsp");
		dispatcher.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
