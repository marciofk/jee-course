package nl.hva.jeecourse.module05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module05/example01")
public class Example01 extends HttpServlet {
	private static final long serialVersionUID = -7584977492970966669L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// how to get a session object
		HttpSession session = req.getSession(true);

		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("05","01","Creating sessions"));
		sb.append("<div class=\"alert alert-info\" role=\"alert\">");
		sb.append("<p>This example illustrates the usage of the method HttpServletRequest.getSession(booean).<p>");
		
		if(session.isNew()) {
			sb.append("<p>A new session has been created</p>");
		} else {
			sb.append("<p>A session object already exists</p>");
		}
		
		sb.append("</div>");
		
		sb.append("<p><a href=\"/JEECourse/module05/example.html\">Back to the main page</a></p>");
		
		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(sb.toString());						
	}
}