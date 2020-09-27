package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class UserEditProfile1 extends HttpServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.getCon();
			}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{	
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		String uname = (String)session.getAttribute("uname");
		
		try{
			con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from usertrainreg where uname=?");
		ps.setString(1,uname);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pw.println("<html><head><title>update</title>");
			pw.println("<style>body{background-color:#EAEDED;}");
			pw.println("table{width:200px; font-size:20px; cursor-pointer:15px;"
					+ " border-radius:8px; background-color:#DD3737}");
			pw.println("input{margin:10px;}");
			pw.println("input[type=text],[type=number]"
					+ "{mrgin:40px; width:500px; height:50px;"
					+ " padding:0 20px; font-size:30px; "
					+ "cursor-pointer:15px; border-radius:8px;}");
			pw.println("a{text-decoration:none; color:white; }");
			pw.println("input[type=submit]{ text-size:40px; margin:20px; "
					+ "width:400px; height:40px; font-size:20px;"
					+ " color:white; background-color:#54CE88; "
					+ "cursor-pointer:20px; border-radius:8px;}");
			pw.println("</style></head>");
			pw.println("<body vlink='white' alink='white'>");
			pw.println("<form action='editprofile2' method='post'>");
			pw.println("<h1 align='center'><b><i>Update Profile</i></b></h1>");
			pw.println("<hr><table align='right' bgcolor='#6EACED' frame='box'>"
					+ "<thead><th><a href='logoutservlet'>Logout</a></th></thead></table>");
			pw.println("<table bgcolor='#6EACED'  frame='box'><thead><th>"
					+ "<a href='userhome.html'>Home</a></th></thead></table>");
			pw.println("<div align='center'>");
			pw.println("<input type='text' name='fname'  placeholder='First Name' "
					+ "value="+rs.getString(1)+"><br>");
			pw.println("<input type='text' name='lname' placeholder='Last Name' "
					+ "required value="+rs.getString(2)+"><br>");
			pw.println("<input type='text' name='mid' placeholder='Mail-Id'"
					+ " required value="+rs.getString(3)+"><br>");
			pw.println("<input type='number' name='phno' placeholder='Phone Number' "
					+ "required value="+rs.getLong(4)+" ><br>");
			pw.println("<input type='text' name='uname' readonly value="+rs.getString(5)+"><br>");
			pw.println("<input type='text' name='pword' placeholder='Password' "
					+ "required value="+rs.getString(6)+"><br>");
			pw.println("<input type='submit' value='Update'>&nbsp;<br>"
					+ "</div></form></body></html>");
			}
		}catch(Exception e){e.printStackTrace(); }
	}
}