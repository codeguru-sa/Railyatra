package test;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class DeleteTrain extends HttpServlet{
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
							("delete trains where tno=?");
					ps.setLong(1, tno);
					ResultSet rs = ps.executeQuery();
				if(rs.next())	{
					pw.println("Train record is deleted...");
					RequestDispatcher rd = req.getRequestDispatcher("deletetrain.html");
					rd.include(req, res);
				}
				else{
					pw.println("Train Number is not valid...");
					RequestDispatcher rd = req.getRequestDispatcher("deletetrain.html");
					rd.include(req, res);
			}
				}catch(Exception e){ }
			}
}