package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EditTrainDetails extends HttpServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.getCon();
			}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{	
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		Long tno = Long.parseLong(req.getParameter("tno"));
		try{
			con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from trains where tno=?");
		ps.setLong(1, tno);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pw.println("<html><head><title>Trains</title>");
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
			pw.println("<form action='uptrain2' method='post'>");
			pw.println("<h1 align='center'><b><i>Edit Train</i></b></h1>");
			pw.println("<hr><table align='right' bgcolor='#6EACED' frame='box'>"
					+ "<thead><th><a href='logoutservlet'>Logout</a></th></thead></table>");
			pw.println("<table bgcolor='#6EACED'  frame='box'><thead><th>"
					+ "<a href='adminhome.html'>Home</a></th></thead></table>");
			pw.println("<div align='center'>");
			pw.println("<input type='number' name='tno' readonly value="+rs.getLong(1)+"><br>");
			pw.println("<input type='text' name='tname' placeholder='Train Name' "
					+ "required value="+rs.getString(2)+"><br>");
			pw.println("<input type='text' name='fstation' placeholder='From-Station'"
					+ " required value="+rs.getString(3)+"><br>");
			pw.println("<input type='text' name='tstation' placeholder='To-Station' "
					+ "required value="+rs.getString(4)+" ><br>");
			pw.println("<input type='number' name='avilable' placeholder='Avilable seats'"
					+ " required   value="+rs.getLong(5)+"><br>");
			pw.println("<input type='number' name='price' placeholder='Ammont of One seat' "
					+ "required value="+rs.getLong(6)+"><br>");
			pw.println("<input type='submit' value='Update'>&nbsp;<br>"
					+ "</div></form></body></html>");
			}
		else{
			pw.println("Train Number is no valid");
			RequestDispatcher rd = req.getRequestDispatcher("updatetrain.html");
			rd.include(req, res);
	}
		}catch(Exception e){ }
	}
}