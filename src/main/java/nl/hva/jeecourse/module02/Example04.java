package nl.hva.jeecourse.module02;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module02/example04")
public class Example04 extends HttpServlet {

	private static final long serialVersionUID = 7828693751952240032L;

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("02", "04","Retrieving all HTTP headers"));
		sb.append("<table class=\"table table-striped\">");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th>Header name</th>");
		sb.append("<th>header value</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("</tbody>");		

		Enumeration<String> headerNames = req.getHeaderNames();

		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = req.getHeader(name);
			sb.append("<tr>");
			sb.append("<td>" + name + "</td>");
			sb.append("<td>" + value + "</td>");
			sb.append("</tr>");
		}

		sb.append("</tbody>");
		
		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(sb.toString());
	}
}