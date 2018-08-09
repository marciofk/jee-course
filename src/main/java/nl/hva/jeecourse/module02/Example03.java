package nl.hva.jeecourse.module02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module02/example03")
public class Example03 extends HttpServlet {
	private static final long serialVersionUID = 6590382710831139790L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("02","03", "Retrieving HTTP headers"));
		
		sb.append("<table class=\"table table-striped\">");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th>Header name</th>");
		sb.append("<th>Value</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("</tbody>");	
		
		sb.append("<tr><td>Accept-Language</td><td>" + request.getHeader("Accept-Language") + "</td></tr>");
		sb.append("<tr><td>Host</td><td>" + request.getHeader("Host") + "</td></tr>");
		sb.append("<tr><td>Referer</td><td>" + request.getHeader("Referer") + "</td></tr>");
		sb.append("<tr><td>User-Agent</td><td>" + request.getHeader("User-Agent") + "</td></tr>");
		
		sb.append(HTMLUtils.buildFooter());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(sb.toString());
	}
}