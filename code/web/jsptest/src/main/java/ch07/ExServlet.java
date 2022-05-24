package ch07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExServlet
 */
@WebServlet("/ch07/ExServlet")
public class ExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
	    out.println("<h1>이클립스로 서블릿 만들기</h1>");
	    out.println("</body>");
	    out.println("</html>");
	}
	// service메소드는 브라우저의 url 요청을 받아옴.
}
