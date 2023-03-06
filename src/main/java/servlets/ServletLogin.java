package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Login;

import java.io.IOException;

import dao.DAOLoginRepository;


@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();
   
    public ServletLogin() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String url = request.getParameter("url");
				
		try {
		if(!username.isEmpty() && !password.isEmpty()) {
			Login login = new Login();
			login.setUsername(username);
			login.setPassword(password);
			
			
				if(daoLoginRepository.validateAuthentication(login)) {
					
					if(url == null || url.equals("null")) {
						url = "main/home.jsp";
					}
					
					request.getSession().setAttribute("user", login.getUsername());
					RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
					request.setAttribute("msg", "Username and Password can not be empty!");
					requestDispatcher.forward(request, response);
					
					
				}else {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
					request.setAttribute("msg", "Username and Password can not be empty!");
					requestDispatcher.forward(request, response);
				}
			 
			
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Username and Password can not be empty!");
			requestDispatcher.forward(request, response);
		  }
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("msg", e.getMessage());
			requestDispatcher.forward(request, response);
			
		}
	}

}
