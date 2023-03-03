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

@WebFilter(urlPatterns = {"/main/*"})
public class FilterAutentication extends HttpFilter implements Filter {
       
    private static final long serialVersionUID = 1L;

	public FilterAutentication() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
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
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
