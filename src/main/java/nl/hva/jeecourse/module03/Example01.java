package nl.hva.jeecourse.module03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module03/example01")
public class Example01 extends HttpServlet {

	private static final long serialVersionUID = -8124703456584611693L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		
		StringBuilder html = new StringBuilder();
		
		html.append(HTMLUtils.buildHeader("03", "01","Generating a servlet response"));
		html.append("<h4>This is an HTML response generated by a servlet</h4>");
		html.append(HTMLUtils.buildFooter());
		
		out.println(html.toString());
	}

}
