package nl.hva.jeecourse.module02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.jeecourse.utils.HTMLUtils;

@WebServlet("/module02/example01")
public class Example01 extends HttpServlet {
	private static final long serialVersionUID = -5059972525337698685L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name, ageRequest;
		int age = 0;
		String[] gradeRequest;
		int[] grade = null;
		StringBuilder errorMessages = new StringBuilder();

		// Getting parameters
		name = req.getParameter("name");
		if (name == null || name.equals(""))
			errorMessages.append("Name required\n");

		ageRequest = req.getParameter("age");
		if (ageRequest == null || ageRequest.equals(""))
			errorMessages.append("Age required\n");
		else
			try {
				age = Integer.parseInt(ageRequest);
			} catch (NumberFormatException e) {
				errorMessages.append("Invalid age: " + ageRequest + "\n");
			}

		gradeRequest = req.getParameterValues("grade");
		if (gradeRequest == null || gradeRequest.length == 0)
			errorMessages.append("Grade required\n");
		else {
			grade = new int[gradeRequest.length];
			for (int i = 0; i < gradeRequest.length; i++) {
				try {
					grade[i] = Integer.parseInt(gradeRequest[i]);
					if (grade[i] < 0 || grade[i] > 10)
						errorMessages.append("Grade " + (i + 1) + " must be between 0 and 10\n");
				} catch (NumberFormatException e) {
					errorMessages.append("Invalid grade: " + (i + 1) + "\n");
				}
			}
		}

		// HTML rendering
		String html;
		
		if (errorMessages.length() == 0)
			html = buildResponsePage(req, resp, name, age, grade);
		else
			html = HTMLUtils.buildErrorMessages("02", "01", errorMessages.toString());
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println(html);
		
	}

	public String buildResponsePage(HttpServletRequest request,
			HttpServletResponse resp, String name, int age, int[] grades)
			throws ServletException, IOException {
		
		StringBuilder message = new StringBuilder("<p class=\"lead\">Received parameters</p>\n"
				+ "<p>Name : <mark>" + name + "</mark></p>"
				+ "<p>Age: <mark>" + age + "</mark></p>");
		
		if (grades != null)
			for (int i = 0; i < grades.length; i++)
				message.append("<p>Grade " + (i + 1) + " : <mark>" + grades[i] + "</mark><p>\n");

		StringBuilder sb = new StringBuilder();
		sb.append(HTMLUtils.buildHeader("02","01","Retrieving HTTP parameters"));
		sb.append(message.toString());
		sb.append(HTMLUtils.buildFooter());
		
		return sb.toString();

	}
}