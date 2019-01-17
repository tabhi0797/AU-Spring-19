

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HeadersServlet")
public class HeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HeadersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> headers = request.getHeaderNames();
		String table = "<table border='1px' ><tr><th>Header</th><th>Header value</th></tr>";
		while(headers.hasMoreElements())
		{
			String key = headers.nextElement();
			String value = request.getHeader(key);
			table+="<tr><td>"+key+"</td><td>"+value+"</td></tr>";
//			System.out.println(key);
		}
		table+="</table>";
		response.getWriter().append(table);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
