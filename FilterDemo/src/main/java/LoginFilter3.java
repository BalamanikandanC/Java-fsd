

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LoginFilter3
 */
@WebServlet("/LoginFilter3")
public class LoginFilter3 implements Filter {
    public LoginFilter3() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException,ServletException{
		String userId=request.getParameter("userid");
		if(userId!=null) {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isLoggable(LogRecord record) {
		// TODO Auto-generated method stub
		return false;
	}

}
