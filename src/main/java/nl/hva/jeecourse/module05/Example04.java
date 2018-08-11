package nl.hva.jeecourse.module05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module05/example04")
public class Example04 extends HttpServlet {
	private static final long serialVersionUID = 4887552195150414093L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("05","04","Getting session information"));
		sb.append("<div class=\"alert alert-info\" role=\"alert\">");
		
		sb.append("<ul class=\"list-group\">");
		sb.append("<li class=\"list-group-item\"><span class=\"badge\">" + 
					session.getId() + "</span>" + "session id" + "</li>");
		sb.append("<li class=\"list-group-item\"><span class=\"badge\">" + 
				new Date(session.getCreationTime()) + "</span>" + "creation time" + "</li>");
		sb.append("<li class=\"list-group-item\"><span class=\"badge\">" + 
				new Date(session.getLastAccessedTime()) + "</span>" + "last accessed time" + "</li>");
		sb.append("<li class=\"list-group-item\"><span class=\"badge\">" + 
				session.getMaxInactiveInterval() + "</span>" + "max inactive interval (seconds)" + "</li>");		
		sb.append("</ul>");
		
		sb.append("</div>");
		sb.append("<p><a href=\"/JEECourse/module05/example.html\">Back to the main page</a></p>");
		
		
		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(sb.toString());				
	}
}