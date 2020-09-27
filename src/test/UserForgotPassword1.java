package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UserForgotPassword1 extends HttpServlet {
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.getCon();
			}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{	
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String uname = req.getParameter("uname");
		try{
			con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from usertrainreg where uname=?");
		ps.setString(1, uname);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pw.println("<html><head><title>Trains</title>");
			pw.println("<style>body{background-color:#EAEDED;}");
			pw.println("input{margin:10px;}");
			pw.println("input[type=text]"
					+ "{mrgin:40px; width:500px; height:50px;"
					+ " padding:0 20px; font-size:30px; "
					+ "cursor-pointer:15px; border-radius:8px;}");
			pw.println("input[type=submit]{ text-size:40px; margin:20px; "
					+ "width:400px; height:40px; font-size:20px;"
					+ "color:white; background-color:#54CE88; "
					+ "cursor-pointer:20px; border-radius:8px;}");
			pw.println("</style></head><body>");
			pw.println("<form action='forgot2' method='post'>");
			pw.println("<div align='center'>");
			pw.println("<h1 align='center'><b><i>Change Password</i></b></h1>");
			pw.println("<hr color='black'><br><br><br><br>");
			pw.println("<input type='text' name='uname' readonly value="+rs.getString(5)+"><br>");
			pw.println("<input type='text' name='pword' placeholder='New Password' required> <br>");
			pw.println("<input type='submit' value='Change Password'>&nbsp;<br>"
					+ "</div></form></body></html>");
			}
		else{
			pw.println("Username is unavilable");
			RequestDispatcher rd = req.getRequestDispatcher("forgotpassword.html");
			rd.include(req, res);
	}
		}catch(Exception e){ }
	}
}
