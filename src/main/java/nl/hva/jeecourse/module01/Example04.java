package nl.hva.jeecourse.module01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module01/example04")
public class Example04 extends HttpServlet {

	private static final long serialVersionUID = 1612538233809174504L;
	private static final Logger log = Logger.getLogger(Example04.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		log.log(Level.INFO,"Entering in the service method ");
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/plain");

		out.println("Servlet Course");
		out.println("\n- Module01 - Examplo 04");
		out.println("\n- Sending a plain text as a response\n");
	}

}
