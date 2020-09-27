package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AddPessenger5 extends HttpServlet{
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
				pw.println("input[type=text],[type=date]{mrgin:40px;width:500px;height:50px;padding:0 20px;"
						+ "font-size:30px;cursor-pointer:15px;border-radius:8px;}");
				pw.println("</style></head><body>");
				pw.println("<form action='book7' method='post'>");
				pw.println("<div align='center'>");
				pw.println("<h2><i><b>Payment Mode</i></b></h2><hr color='black'><br><br><br><br><br><br>");
				pw.println("<input type='text' name='accno' placeholder='Account Number'><br><br>");
				pw.println("<input type='date' name='expdate'><br><br>");
				pw.println("<input type='text' name='phno' placeholder='Phone Number'><br><br><br>");
					pw.println("<input type='submit' value='Pay'>");
				pw.println("</div></form></body></html>");
			}
			}catch(Exception e){ }
	}
}
