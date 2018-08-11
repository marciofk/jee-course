package nl.hva.jeecourse.module03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module03/example07")
public class Example07 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1549510236688939937L;

	public void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("03","07", "Generating independent URIs"));
		
		sb.append("<a href=\"" + req.getContextPath() + "/module02/example05\">" +
			"click here to execute the servlet module02/example05</a>");
		
		sb.append(HTMLUtils.buildFooter());
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(sb.toString());		
		
	}
}