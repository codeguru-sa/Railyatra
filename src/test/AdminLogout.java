package test;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class AdminLogout extends HttpServlet{
			public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
				PrintWriter pw = res.getWriter();
				res.setContentType("text/html");
				
				RequestDispatcher rd = req.getRequestDispatcher("home.html");
				rd.include(req, res);
				
				Cookie ck1 = new Cookie("uname","");
				ck1.setMaxAge(0);
				Cookie ck2 = new Cookie("pword","");
				ck2.setMaxAge(0);
				
				pw.println("Logout Successfully......!!!");
			}
}
