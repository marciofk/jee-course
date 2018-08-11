package nl.hva.jeecourse.module02;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module02/example02")
public class Example02 extends HttpServlet {

	private static final long serialVersionUID = 2493333023001574225L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("02", "02","Retrieving all HTTP parameters"));
		sb.append("<table class=\"table table-striped\">");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th>Parameter</th>");
		sb.append("<th>Value</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("</tbody>");

		Enumeration<String> names = req.getParameterNames();

		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = req.getParameter(name);
			sb.append("<tr>");
			sb.append("<td>" + name + "</td>");
			sb.append("<td>" + value + "</td>");
			sb.append("</tr>");
		}
		
		sb.append("</tbody></table>");
		
		sb.append("ampersand (&) = " + URLEncoder.encode("&","UTF-8"));
		
		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(sb.toString());
	}
}