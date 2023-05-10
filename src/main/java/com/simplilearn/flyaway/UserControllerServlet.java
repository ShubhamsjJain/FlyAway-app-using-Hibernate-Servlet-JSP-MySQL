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
					//Verify the user in MVC fashion
		        	
		        	signIn(request,response);    //Provided below
			        break;
			        
		        case "VERIFYADMIN":
					//Verify the admin in MVC fashion
		        	
		        	AdminsignIn(request,response);    //Provided below
			        break;
			        
			        
		        	
					
					
			    case "ADD":
			
			        //Add the user in MVC fashion 
			    
			        signUp(request,response);    //Provided below
			        break;
			        
			    case "NEWADMIN":
					
			        //Add the Admin in MVC fashion 
			    
			        signUpAdmin(request,response);    //Provided below
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

	
	private void AdminsignIn(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String e_mail = request.getParameter("username");	
		String password = request.getParameter("password");	
		
        Admin admin = userdao.verifyAdmin(e_mail, password);
        
        if(admin == null) {            // i.e Admin doesn't exist
        	response.sendRedirect("AdminSigninFailure.jsp");
        }else {                        // i.e since got Admin object hence admin exist;
        	response.sendRedirect("AdminWelcomePage.jsp");
        }
		
	}

	private void signUpAdmin(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String e_mail = request.getParameter("username");	
		String password = request.getParameter("password");	
		
		userdao.addNewAdmin(e_mail, password);
		
		response.sendRedirect("AdminSignin.jsp");
		
		
	}

	private void signIn(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String e_mail = request.getParameter("username");	
		String password = request.getParameter("password");	
		
        User user = userdao.verifyUser(e_mail, password);
        
        if(user == null) {            // i.e User doesn't exist
        	response.sendRedirect("signInFailure.jsp");
        }else {                        // i.e since got user object hence user exist;
        	response.sendRedirect("index.html");
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
