package test;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.*;
public class AddPessenger2 extends HttpServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.getCon();
		}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
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
				pw.println("body{background-color:#EAEDED;}")	;
				pw.println("a{font-size:30px; text-decoration:none; color:white;}");
				pw.println("td{font-size:30px;}");
				pw.println("input[type=submit]{ text-size:40px; margin:"
						+ "20px;width:400px; height:40px;font-size:"
						+ "20px;color:white;background-color :#2B8EF9;"
						+ "cursor-pointer:20px;	border-radius:8px;}");
				pw.println("input[type=number],[type=text]{mrgin:40px;width:500px;	height:50px;"
						+ "padding:0 20px;font-size:30px;cursor-pointer:15px;"
						+ "border-radius:8px;}");
				pw.println("#table{width:200px; font-size:15px; border-radius:8px; cursor-pointer:15px;");
				pw.println("border-radius:8px; background-color:#16F1B3; }");
				pw.println("#detail{ width:600px;height:40px; cursor-pointer:15px; border-radius:8px;} ");
				pw.println("</style></head><body>");
				pw.println("<form action='book4' method='post'>");
				pw.println("<div align='center'>");
				pw.println("<h2><i><b>Add Pessenger</i></b></h2><hr color='black'><br>");
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
				pw.println("<table width='600' height='40' align='center'>"
						+ "<tbody><tr><td>"
						+ "<b>"+bb.getName()+"</b></td></tr>"
						+ "<tr><td><b>"+bb.getpAge()+"</b>&nbsp;<b>"+bb.getGender()+"</b>"
						+ "<span>|</span><b>"+bb.getBirth()+"</b></td></tr>"
								+ "</tbody></table>");
				pw.println("<br><br><br><br>");
				pw.println("<input type='submit' value='Book Ticket'>");
				pw.println("</form></div></body></html>");
				
				
	}
		}catch(Exception e){ }
	}
	}
