package test;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class UserDeleteProfile extends HttpServlet{
			public Connection con;
			public void init() throws ServletException{
				con=DBConnection.getCon();
					}
			public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{	
				
				PrintWriter pw = res.getWriter();
				res.setContentType("text/html");
				String uname= req.getParameter("uname");
				String  pword = req.getParameter("pword");
				try{
					con=DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement
							("delete usertrainreg where uname=? and pword=?");
					ps.setString(1, uname);
					ps.setString(2, pword);
					ResultSet rs = ps.executeQuery();
				if(rs.next())	{
					pw.println("Your Profile is deleted...");
					RequestDispatcher rd = req.getRequestDispatcher("userlogin.html");
					rd.include(req, res);
				}
				else{
					pw.println("Username or password is invalid...");
					RequestDispatcher rd = req.getRequestDispatcher("deleteuserprofile.html");
					rd.include(req, res);
			}
				}catch(Exception e){ }
			}
}