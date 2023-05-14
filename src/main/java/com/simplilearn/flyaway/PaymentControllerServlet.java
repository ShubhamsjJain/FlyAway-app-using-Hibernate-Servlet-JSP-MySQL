package com.simplilearn.flyaway;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentControllerServlet
 */
@WebServlet("/PaymentControllerServlet")
public class PaymentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PaymentDAO paymentdao;
	
    public PaymentControllerServlet() {
        
    }

	
	@Override
	public void init() throws ServletException {
		
		//Create PaymentDAO object in init So that as soon as servlet starts it will create PaymentDAO object and hence PaymentDAO constuctor will be called where SessionFactory object is created.
		paymentdao = new PaymentDAO();
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
			
			        //Add the payment in MVC fashion 
			    
			        paymenttAdd(request,response);    //Provided below
			        break;
			        
			        
			        
			    case "LOAD":
			    	
			    	//Load all flight info from database based on flight number got from list-flights.jsp
			    	
			    	
			    	
			    	
			    case "UPDATE":
			    	
			    	//Update the flight in MVC fashion 
			    	
			    	
			    	
			    	
                	
			        
			        
               case "SEARCH":
			    	
			    	//Search the flight in MVC fashion 
			    	
                	
			        
			        
			    	
			        
			     default:
			    	 
			    	  //Provided below
					 
			    	 
			
			}
			
			
			
		} catch (Exception e) {
						
			e.printStackTrace();
		}
	}

	
	private void paymenttAdd(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String cardNo = request.getParameter("cardNo");
		String cardHolderName = request.getParameter("cardHolderName");
		String MM = request.getParameter("MM");
		String YYYY = request.getParameter("YYYY");
		String CVV = request.getParameter("CVV");
		Double paidAmt = Double.parseDouble(request.getParameter("paidAmt"));
		
		java.util.Date schPaiddate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("paidDate"));
		java.sql.Date schedule_paid_date = new java.sql.Date(schPaiddate.getTime());
		
		int passenger_id = Integer.parseInt(request.getParameter("passenger_id"));
		
		Payment object = paymentdao.addPayment(cardNo, cardHolderName, MM, YYYY, CVV, paidAmt, schedule_paid_date, passenger_id);
		
		request.setAttribute("CONFIRM_PAYMENT", object);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("final-booking-confirmation.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
