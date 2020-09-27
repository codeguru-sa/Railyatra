package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import test.RegBean;
public class RegServlet1 extends HttpServlet{
	public void doPost(HttpServletRequest req , HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		RegBean rb = new RegBean();
		ServletContext sct = req.getServletContext();
		sct.setAttribute("beanRef", rb);
		String fname= req.getParameter("fname");
		rb.setFName(fname);
		String lname = req.getParameter("lname");
		rb.setLName(lname);
		String mid=req.getParameter("mid");
		rb.setMail(mid);
		Long phno = Long.parseLong(req.getParameter("phno"));
		rb.setPhNo(phno);
		
		RequestDispatcher rd = req.getRequestDispatcher("register2.html");
		rd.forward(req, res);
			
	}
}
