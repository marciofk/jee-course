package nl.hva.jeecourse.module04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module04/example02")
public class Example02 extends HttpServlet {
	private static final long serialVersionUID = -112277080722567147L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();

		StringBuilder sb = new StringBuilder();

		sb.append(HTMLUtils.buildHeader("04", "02", "Retrieving cookies"));
		sb.append("<table class=\"table table-striped\">");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th>name</th>");
		sb.append("<th>value</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("</tbody>");

		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("visits")) {
				continue;
			}
			sb.append("<tr>" + "<td>" + cookies[i].getName() + "</td>" + "<td>"
					+ cookies[i].getValue() + "</td>" + "</tr>");
		}

		sb.append("</tbody></table>");

		int visits = updateAndGetVisits(req,resp);
		
		sb.append("<p> Number of visits: " + visits + "</p>");

		sb.append(HTMLUtils.buildFooter());

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(sb.toString());
	}

	private int updateAndGetVisits(HttpServletRequest req,HttpServletResponse resp) {
		int visits = 0;
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("visits")) {
				visits = Integer.parseInt(cookies[i].getValue());
				break;
			}
		}
		resp.addCookie(new Cookie("visits", Integer.toString(++visits)));
		return visits;
	}
}