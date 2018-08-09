package nl.hva.jeecourse.module03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module03/example06")
public class Example06 extends HttpServlet {
	private static final long serialVersionUID = -7458692972689919241L;

	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Refresh", "3");

		resp.setContentType("text/html");

		StringBuilder html = new StringBuilder();

		html.append(HTMLUtils.buildHeader("03", "06",
				"Setting response headers"));
		html.append("<p>Random number (just to check that the page was really refreshed each 3 seconds: " +
					new Random().nextInt(1000) + "</p>");
		html.append(HTMLUtils.buildFooter());
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(html.toString());				
	}
}