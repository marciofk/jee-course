package nl.hva.jeecourse.module02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module02/example05")
public class Example05 extends HttpServlet {
	private static final long serialVersionUID = 7575900159776417573L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(HTMLUtils.buildHeader("02", "05","Retrieving request information"));
		sb.append("<table class=\"table table-striped\">");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th>Information</th>");
		sb.append("<th>Value</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("</tbody>");		
		
		sb.append("<tr><td>Method</td><td>" + request.getMethod() + "</td></tr>");
		sb.append("<tr><td>Protocol</td><td>" + request.getProtocol() + "</td></tr>");
		sb.append("<tr><td>Remote Host</td><td>" + request.getRemoteHost() + "</td></tr>");
		sb.append("<tr><td>Remote Port</td><td>" + request.getRemotePort() + "</td></tr>");
		sb.append("<tr><td>Server Name</td><td>" + request.getServerName() + "</td></tr>");
		sb.append("<tr><td>Server Port</td><td>" + request.getServerPort() + "</td></tr>");
		sb.append("<tr><td>Servlet Path</td><td>" + request.getServletPath() + "</td></tr>");
		sb.append("<tr><td>Request URI</td><td>" + request.getRequestURI() + "</td></tr>");
		sb.append("<tr><td>Query String</td><td>" + request.getQueryString() + "</td></tr>");
		
		sb.append("</tbody>");
		
		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(sb.toString());		

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}