package nl.hva.jeecourse.module03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/module03/example03")
public class Example03 extends HttpServlet {

	private static final long serialVersionUID = 2827502715095398256L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		URL url = getServletContext().
					getResource("/courseinfo/slides/00.pdf");

		try {
			URI uri = new URI(url.toString());

			File f = new File(URLDecoder.decode(url.getPath(), "UTF-8"));

			resp.setContentType("application/pdf");
			resp.setContentLength((int)f.length());
			System.out.println(f.length() + f.toString());

			OutputStream os = resp.getOutputStream();

			InputStream is = new FileInputStream(f);

			byte[] b = new byte[(int) f.length()];
			int qtd = is.read(b);
			os.write(b,0,qtd);

			is.close();
		} catch (URISyntaxException e) {
			throw new IllegalStateException("Invalid URI");
		}


	}
	
}
