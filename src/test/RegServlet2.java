package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import test.RegBean;
public class RegServlet2 extends HttpServlet{
	public void doPost(HttpServletRequest req , HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ServletContext sct = req.getServletContext();
		RegBean rb = (RegBean)sct.getAttribute("beanRef");
		String uname = req.getParameter("uname");
		rb.setUName(uname);
		String pword = req.getParameter("pword");
		rb.setPWord(pword);
		RequestDispatcher rd = req.getRequestDispatcher("finalreg.html");
		rd.forward(req, res);		
		}
}
