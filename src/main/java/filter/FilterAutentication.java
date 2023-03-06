package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connections.SingleConnetionDB;

@WebFilter(urlPatterns = {"/main/*"})
public class FilterAutentication extends HttpFilter implements Filter {
       
    private static final long serialVersionUID = 1L;

    private static Connection connection;
    
	public FilterAutentication() {
    }

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			
			String logedUser = (String) session.getAttribute("user");
			String urlToAthenticate = req.getServletPath(); // url que está sendo acessada
			
			if(logedUser == null || (logedUser != null && logedUser.isEmpty()) 
					&& !urlToAthenticate.contains("Login")) {
				
				RequestDispatcher redirect = request.getRequestDispatcher("/index.jsp?url=" + urlToAthenticate);
				request.setAttribute("msg", "Por Favor realize o login!");
				redirect.forward(request, response);
				return;
			}
			
			chain.doFilter(request, response);
			connection.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("msg", e.getMessage());
			requestDispatcher.forward(request, response);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnetionDB.getConnection();
	}

}
