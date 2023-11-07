

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class InterfaceDemo
 */
@WebServlet("/InterfaceDemo")
public class InterfaceDemo implements Servlet {
	
	ServletConfig config=null;
	public void init(ServletConfig config) {
		this.config=config;
		System.out.println("Initialization complete");
	}
	
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<html><body>");
		pw.print("In the service()method<br>");
		pw.println("</body></html>");
	}
	
	public void destroy() {
		System.out.println("In destroy() method");
	}
	public ServletConfig getServletConfig() {
		return config;
	}
	public String getServletInfo() {
		return "This is a sample servlet info";
	}
}
