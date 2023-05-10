package com.simplilearn.flyaway;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UserDAO userdao;
    
    public UserControllerServlet() {
       
    }

    @Override
	public void init() throws ServletException {
		
		//Create UserDAO object in init So that as soon as servlet starts it will create UserDAO object and hence UserDAO constuctor will be called where SessionFactory object is created.
    	userdao = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
try {
			
			String theCommand = request.getParameter("command");   // taking command parameter having value ADD or UPDATE or DELETE
			
			// if theCommand is missing,default it to liststudents
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand){
				
			
		        case "VERIFY":
					//List the students in MVC fashion
		        	
					
					
			    case "ADD":
			
			        //Add the user in MVC fashion 
			    
			        signUp(request,response);    //Provided below
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

	
	private void signUp(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String e_mail = request.getParameter("username");	
		String password = request.getParameter("password");	
		
		userdao.addNewUser(e_mail, password);
		
		response.sendRedirect("SignInFront.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
