package test;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.*;
public class AddPessenger extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		BookBean bb = new BookBean();
		ServletContext sct = req.getServletContext();
		sct.setAttribute("bookRef", bb);		

		String name = req.getParameter("name");
		bb.setName(name);
		Long page = Long.parseLong(req.getParameter("page"));
		bb.setpAge(page);
		String birth = req.getParameter("birth");
		bb.setBirth(birth);
		String gender = req.getParameter("gender");
		bb.setGender(gender);
		RequestDispatcher rd = req.getRequestDispatcher("book3");
		rd.forward(req, res);
	}
}