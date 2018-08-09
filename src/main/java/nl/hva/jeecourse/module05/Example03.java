package nl.hva.jeecourse.module05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module05/example03")
public class Example03 extends HttpServlet {
	private static final long serialVersionUID = 1610706059903551412L;

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String name = (String) session.getAttribute("name");
		
		StringBuilder html = new StringBuilder();
		
		html.append(HTMLUtils.buildHeader("05","03","Getting session attributes"));
		html.append("<div class=\"alert alert-info\" role=\"alert\">");
		html.append("<p>Logged user: " + name + "</p>");
		html.append("</div>");
		
		// getting all session attributes
		
		html.append("<p class=\"lead\">All session attributes</p>");
		html.append("<table class=\"table table-striped\">");
		html.append("<thead>");
		html.append("<tr>");
		html.append("<th>attribute name</th>");
		html.append("<th>value</th>");
		html.append("</tr>");
		html.append("</thead>");
		html.append("</tbody>");

		Enumeration<String> names = session.getAttributeNames();

		while (names.hasMoreElements()) {
			String attributeName = names.nextElement();
			Object value = session.getAttribute(attributeName);
			html.append("<tr>");
			html.append("<td>" + attributeName + "</td>");
			html.append("<td>" + value + "</td>");
			html.append("</tr>");
		}
		
		html.append("</tbody></table>");
		
		String url = resp.encodeURL("/JEECourse/module05/example.html");
		
		html.append("<p><a href=\"" + url + "\">Back to the main page</a></p>");
		
		html.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(html.toString());				
	}

}