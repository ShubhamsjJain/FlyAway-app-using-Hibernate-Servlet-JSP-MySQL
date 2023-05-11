package com.simplilearn.flyaway;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class FlightControllerServlet
 */
@WebServlet("/FlightControllerServlet")
public class FlightControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FlightDAO flightdao;
	
    public FlightControllerServlet() {
        	
    }

    @Override
	public void init() throws ServletException {
		
		//Create FlightDAO object in init So that as soon as servlet starts it will create FlightDAO object and hence FlightDAO constuctor will be called where SessionFactory object is created.
    	flightdao = new FlightDAO();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         try {
			
			String theCommand = request.getParameter("command");   // taking command parameter having value ADD or UPDATE or DELETE
			
			// if theCommand is missing,default it to listflights
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand){
			        
			
			    case "ADD":
			
			        //Add the flight in MVC fashion 
			    
			        flightAdd(request,response);    //Provided below
			        break;
			        
			        
			        
			    case "LOAD":
			    	
			    	//Load all student info from database based on student id got from list-student.jsp
			    	
			    	
			    	
			    case "UPDATE":
			    	
			    	//Update the student in MVC fashion 
			    	
			    	
			    	
                case "DELETE":
			    	
			    	//Delete the student in MVC fashion 
			    	
			    	
			        
			     default:
			    	 
			    	  //Provided below
					 
			
			}
			
			
			
		} catch (Exception e) {
						
			e.printStackTrace();
		}
	}

	private void flightAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		//Receive the data from HTML form and convert into proper dataType.
		//Note that since HTML form took data in string form we have to convert all data into proper data type
		
		
		String flynum = request.getParameter("flyno");
		String src = request.getParameter("src");
		String dest = request.getParameter("dest");
		int seats = Integer.parseInt(request.getParameter("seats"));
		int duration = Integer.parseInt(request.getParameter("duration"));
		double price = Double.parseDouble(request.getParameter("price"));
		
		//Converting date and time into (java.util.Date)then converting it into 
		//java.sql.time or java.sql.date as needed
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		
		java.util.Date arrTime =(java.util.Date)format.parse(request.getParameter("arrtime"));
		java.sql.Time arrival_time = new java.sql.Time(arrTime.getTime());
		
		java.util.Date depTime =(java.util.Date)format.parse(request.getParameter("deptime"));
		java.sql.Time departure_time = new java.sql.Time(depTime.getTime());
		
		java.util.Date schdate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("schdate"));
		java.sql.Date schedule_date = new java.sql.Date(schdate.getTime());
			
		
		
		// sending these converted data to FlightDAO
		
		flightdao.addNewFlight(flynum,src, dest,seats,duration, price,arrival_time,departure_time,schedule_date);
		
		//Return to Admin Home page
		
		response.sendRedirect("AdminWelcomePage.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
