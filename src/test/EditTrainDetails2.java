package test;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class EditTrainDetails2 extends HttpServlet{
	public Connection con;
	public void init() throws ServletException{
		con=DBConnection.getCon();
			}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{	
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		Long tno = Long.parseLong(req.getParameter("tno"));
		String tname  = req.getParameter("tname");
		String fstation = req.getParameter("fstation");
		String tstation = req.getParameter("tstation");
		Long avilable = Long.parseLong(req.getParameter("avilable"));
		Long price = Long.parseLong(req.getParameter("price"));
		
		try{
			con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("update trains set tno=?,tname=?,from_station=?,to_station=?,avilable=?,price=? where tno="+tno+"");
			ps.setLong(1, tno);
			ps.setString(2, tname);
			ps.setString(3, fstation);
			ps.setString(4, tstation);
			ps.setLong(5, avilable);
			ps.setLong(6, price);
			
			int k = ps.executeUpdate();
			if(k>0){
				pw.println("Your Train Data is Updated");
				RequestDispatcher rd = req.getRequestDispatcher("updatetrain.html");
				rd.include(req, res);
			}
		}catch(Exception e){ }
	}
}
