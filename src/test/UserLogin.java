package test;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class UserLogin extends HttpServlet{
			public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
				PrintWriter pw = res.getWriter();
				res.setContentType("text/html");
				String uname= req.getParameter("uname");
				String  pword = req.getParameter("pword");
				try{
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement
						("select * from usertrainreg where uname=? and pword=?");
				ps.setString(1, uname);
				ps.setString(2, pword);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					HttpSession session = req.getSession();
					session.setAttribute("uname",uname);
					pw.println("You are successfully login.....");
					Cookie ck1 = new Cookie("uname",uname);
					res.addCookie(ck1);
					Cookie ck2 = new Cookie("pword",pword);
					res.addCookie(ck2);
				RequestDispatcher rd = req.getRequestDispatcher("userhome.html");
				rd.forward(req,res);
				}
				else{
					pw.println("Username or password is wrong.....!!!");
					RequestDispatcher rd = req.getRequestDispatcher("userlogin.html");
					rd.include(req, res);
				}
			}catch(Exception e){}
			}
}
