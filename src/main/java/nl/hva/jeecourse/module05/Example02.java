package nl.hva.jeecourse.module05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module05/example02")
public class Example02 extends HttpServlet {
	private static final long serialVersionUID = -2828512280164863001L;

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String name = req.getParameter("name");
		
		HttpSession session = req.getSession(true);
		session.setAttribute("name",name);
		session.setAttribute("host", req.getRemoteHost());
		session.setAttribute("port", req.getRemotePort());
		
		@SuppressWarnings("unchecked")
		List<Date> dates = (List<Date>) 
				session.getAttribute("listOfDate");
		
		if(dates == null) {
			dates = new ArrayList<Date>();
			session.setAttribute("listOfDate", dates);
		}
		
		dates.add(new Date());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("05","01","Log in"));
		sb.append("<div class=\"alert alert-info\" role=\"alert\">");
		sb.append("<p>This example illustrates the usage of the method HttpServletRequest.setAttribute(object).<p>");
		
		sb.append("<p>The user " + name + " is now stored in the session</p>");

		sb.append("</div>");
		
		sb.append("<p><a href=\"/JEECourse/module05/example.html\">Back to the main page</a></p>");
		
		
		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(sb.toString());		
		
		
	}

}