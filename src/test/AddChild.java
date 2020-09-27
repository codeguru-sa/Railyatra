package test;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.*;
public class AddChild extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		ServletContext sct = req.getServletContext();
		BookBean bb = (BookBean)sct.getAttribute("bookRef");
		Long cage=Long.parseLong(req.getParameter("cage"));
		bb.setcAge(cage);
		String cname=req.getParameter("cname");
		bb.setcName(cname);
		String cgender=req.getParameter("cgender");
		bb.setcGender(cgender);
		RequestDispatcher rd = req.getRequestDispatcher("addpessenger");
		rd.forward(req, res);
	}
}
