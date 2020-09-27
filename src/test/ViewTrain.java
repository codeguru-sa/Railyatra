package test;
import javax.servlet.*;
import java.util.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class ViewTrain extends HttpServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.getCon();
			}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{	
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String fTrain = req.getParameter("fst");
		String tTrain = req.getParameter("tst");
		try{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select tno from trains where from_station=? and to_station=?");
			ps.setString(1, fTrain);
			ps.setString(2, tTrain);
			
			ResultSet rs = ps.executeQuery();
			pw.println("<html><head><title>Trains</title><style>"
					+ "a{ text-decoration:none; color:#DD3737; font-size:40px; margin:10px;}"
					+ "body{ background-color:#EAEDED;} </style></head>");
			pw.println("<body><div align='center'><font size='6'><b><i>"
					+ "<h2>Train Number</h2></b></i></font><hr color='black'>");
			pw.println("<br><br><br>");
			while(rs.next())
			{
				pw.println("<a href='link?tno="+rs.getLong(1)+"'>"+rs.getLong(1)+"</a><br><br>");
			}
			pw.println("</div></body></html>");
		}catch(Exception e){ } 
	}
}