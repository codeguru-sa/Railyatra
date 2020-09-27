package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Pessenger extends HttpServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.getCon();
		}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{	
		
		HttpSession hs = req.getSession(false);
		
		if(hs!=null)
		System.out.println("Success");
			Long  tno = (Long)hs.getAttribute("tno");
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ServletContext sct = req.getServletContext();
		BookBean bb = (BookBean)sct.getAttribute("bookRef");
		try{
			con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from trains where tno=?");
		ps.setLong(1, tno);
			ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pw.println("<html><head><style>");
			pw.println("body{background-color:#EAEDED;}"
					+ "tbody{font-size:30px;}")	;
			pw.println("a{font-size:30px; text-decoration:none; color:white;}");
			pw.println("td{font-size:30px;}");
			pw.println("#table{width:500px; font-size:30px; border-radius:8px; cursor-pointer:15px;");
			pw.println("border-radius:8px; background-color:#16F1B3; }");
			pw.println("#detail{ width:600px;height:40px; cursor-pointer:15px; border-radius:5px;} ");
			pw.println("</style></head><body>");
			pw.println("<br>");
			pw.println("<h2 align='center'><i><b>Add Pessenger</i></b></h2><hr color='black'><br><br>");
			pw.println("<table width='310' align='center'><tbody><tr>"
					+ "<td>"+rs.getString(2)+"&nbsp;("+rs.getLong(1)+")</td></tr>");
			pw.println("<tr><td>"+rs.getString(3)+"<b>&nbsp;&nbsp;"
					+ "&#8594;&nbsp;</b>"+rs.getString(4)+"</td></tr>");
			pw.println("<tr><td>Avilable:&nbsp;"+rs.getLong(5)+"&nbsp;&nbsp;"
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#8377;");
			pw.println(""+rs.getLong(6)+"</td></tr>");
			pw.println("</tbody></table><br>");
			pw.println("<table id='detail' align='center' bgcolor='lightblue' frame='box' rules='all'><tbody><tr>"
					+ "<td  align='center' width='200'><a href='booking.html'>Add Pessenger</a>"
					+ "</td><td align='center' width='200'>"
					+ "<a href='addchild.html'>Add Child</a></td></tr>"
					+ "</tbody></table>");
			pw.println("<br>");
			pw.println("</body></html>");
}
	}catch(Exception e){ }
}
}
