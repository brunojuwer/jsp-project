package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Login;

import java.io.IOException;


@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletLogin() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		if(!username.isEmpty() && !password.isEmpty()) {
			Login login = new Login();
			login.setUsername(username);
			login.setPassword(password);
			
			if(login.getUsername().equalsIgnoreCase("admin") && login.getPassword().equals("admin")) {
				
				request.getSession().setAttribute("usuario", login.getUsername());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/home.jsp");
				request.setAttribute("msg", "Username and Password can not be empty!");
				requestDispatcher.forward(request, response);
				
				
			}else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Username and Password can not be empty!");
				requestDispatcher.forward(request, response);
			}
			
		}else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Username and Password can not be empty!");
			requestDispatcher.forward(request, response);
		}
	}

}
