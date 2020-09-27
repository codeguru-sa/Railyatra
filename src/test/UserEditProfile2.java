package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class UserEditProfile2 extends HttpServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.getCon();
			}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{	
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String mid = req.getParameter("mid");
		Long phno = Long.parseLong(req.getParameter("phno"));
		String uname = req.getParameter("uname");
		String pword = req.getParameter("pword");
		
		try{
			con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("update usertrainreg set fname=?,lname=?,mailid=?,phno=?,uname=?,pword=? where uname=?");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, mid);
			ps.setLong(4, phno);
			ps.setString(5, uname);
			ps.setString(6, pword);
			ps.setString(7, uname);
			int k = ps.executeUpdate();
			if(k>0){
				pw.println("Your profile is Updated");
				RequestDispatcher rd = req.getRequestDispatcher("userhome.html");
				rd.include(req, res);
			}
		}catch(Exception e){ }
	}
}
