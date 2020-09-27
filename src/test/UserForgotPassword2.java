package test;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class UserForgotPassword2 extends HttpServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.getCon();
			}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{	
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String uname = req.getParameter("uname");
		String pword= req.getParameter("pword");
		
		try{
			con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
("update usertrainreg set uname=?,pword=? where uname=?");
			ps.setString(1,uname);
			ps.setString(2, pword);
			ps.setString(3, uname);
			
			int k = ps.executeUpdate();
			if(k>0){
				pw.println("Your Password is changed");
				RequestDispatcher rd = req.getRequestDispatcher("userlogin.html");
				rd.include(req, res);
			}
		}catch(Exception e){ } 
	}
}