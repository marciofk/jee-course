package nl.hva.jeecourse.module03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module03/example02")
public class Example02 extends HttpServlet {

	private static final long serialVersionUID = 7635443858065878055L;
	
	private static final String [][] profiles = {{"Grumpy","Cat","grumpy.jpg"},
												 {"Mr","Bean","bean.jpg"},
												 {"Mike","Wazowski","mike.png"}}; 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("application/json");

		PrintWriter out = resp.getWriter();
		
		out.println(getProfile());
	}
	
	private String getProfile() {
		int pos = new Random().nextInt(3);
		return "{ \"firstName\" : \"" + profiles[pos][0] + "\"," +
			   "\"lastName\" : \"" + profiles[pos][1] + "\"," +
			   "\"photo\" : \"" + profiles[pos][2] + "\"}";
		
	}
	
}
