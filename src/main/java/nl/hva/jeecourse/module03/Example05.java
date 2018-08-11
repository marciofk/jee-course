package nl.hva.jeecourse.module03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module03/example05")
public class Example05 extends HttpServlet {
	private static final long serialVersionUID = -917788745544572073L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");

		resp.sendError(404, 
				"This file is unavailable. This is a custom message");
	}
}