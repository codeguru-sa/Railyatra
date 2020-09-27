package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class UserTrainDetails extends HttpServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.getCon();
			}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{	
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		Long tno = Long.parseLong(req.getParameter("tno"));
		HttpSession hs = req.getSession();
		hs.setAttribute("tno", tno);
		try{
			con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from trains where tno=?");
		ps.setLong(1, tno);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pw.println("<html><head><title>Trains</title>");
			pw.println("<style>thead,tbody{ font-size:40px; }");
			pw.println("body{background-color:#EAEDED;}")	;
			pw.println("a{font-size:20px; text-decoration:none; color:white;}");
			pw.println("#book{ width:300px; height:50px; font-size:15px; cursor-pointer:15px; border-radius:8px;");
			pw.println("border-radius:8px; }");
			pw.println("#table{ width:200px; font-size:15px; cursor-pointer:15px; border-radius:8px;"); 
			pw.println("border-radius:8px; background-color:#DD3737; }");
			pw.println("#tableback{ width:200px; font-size:15px; border-radius:8px; cursor-pointer:15px;");
			pw.println("border-radius:8px; background-color:#16F1B3; }");
			pw.println("</style></head>");
			pw.println("<body>");
			pw.println("<div align='center'>");

			pw.println("<b><i><h2>View train Details</h2></b></i><hr color='black'>");
			pw.println("<table id='table' align='right'><thead><th><a href='logoutservlet'>Logout"
					+ "</a></th></thead></table>");
			
			pw.println("<table id='tableback' align='left'><thead><th><a href='userhome.html'>Home</a></th>"
					+ "</thead></table>");
			pw.println("<br><br><br>");

			pw.println("<table frame='box' rules='all' width='500' align='center'>");
			pw.println("<thead><th colspan='2'>Train Details</th></thead>");
			pw.println("<tbody align='center'>");
			pw.println("<tr><td>Train Number</td>"+"<td >"+rs.getLong(1)+"</td></tr>");
			pw.println("<tr><td >Train Name</td> "+"<td>"+rs.getString(2)+"</td></tr>");
			pw.println("<tr><td>From Station</td> "+"<td>"+rs.getString(3)+"</td></tr>");
			pw.println("<tr><td>To Station</td> "+"<td>"+rs.getString(4)+"</td></tr>");
			pw.println("<tr><td>Avilable seats</td>"+"<td>"+rs.getLong(5)+"</td></tr>");
			pw.println("<tr><td>Ammount</td> "+"<td>"+rs.getLong(6)+"</td></tr></tbody></table>");
			pw.println("<br><table id='book' align='center' frame='box' bgcolor='lightblue'><thead><th>"
					+ "<a href='book1'>Book Ticket</a></th></thead></table>");
			pw.println("</body></html>");
		}
		}catch(Exception e){ }	
	}
}