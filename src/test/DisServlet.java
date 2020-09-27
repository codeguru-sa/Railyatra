package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import test.RegBean;
public class DisServlet extends HttpServlet{
	public void doPost(HttpServletRequest req , HttpServletResponse res)
	throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ServletContext sct = req.getServletContext();
		RegBean rb = (RegBean)sct.getAttribute("beanRef");
		String sub = req.getParameter("Preview");
		if(sub.equals("Preview")){
			pw.println("<html><head><title>register</title>");
			pw.println("<style>thead,tbody{ font-size:30px; }");
			pw.println("body{background-color:#EAEDED;}</style></head>");
			pw.println("<body>");
			pw.println("<div align='center'>");
			pw.println("<h2><i><b>Confirm info by yourself </i></b></h2><hr color='black'>");
			pw.println("<br><br><br><br><br>");
			pw.println("<table frame='box' rules='all' width='500' align='center'>");
			pw.println("<thead><th colspan='2'>Preview</th></thead>");
			pw.println("<tbody align='center'>");
			pw.println("<tr><td>First Name </td>"+"<td >" +rb.getFName()+"</td></tr>");
			pw.println("<tr><td>Last Name</td>"+"<td >" +rb.getLName()+"</td></tr>");
			pw.println("<tr><td>Mail Id</td>"+"<td >" +rb.getMail()+"</td></tr>");
			pw.println("<tr><td>Phone Number</td>"+"<td >" +rb.getPhNo()+"</td></tr>");
			pw.println("<tr><td>User Name</td>"+"<td >" +rb.getUName()+"</td></tr>");
			pw.println("<tr><td>PassWord</td>"+"<td >" +rb.getPWord()+"</td></tr>");
			pw.println("</tbody></table></div></body></html>");
			RequestDispatcher rd = req.getRequestDispatcher("final.html");
			rd.include(req,res);
		}
		else{
			try{
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement
						("insert into usertrainreg values(?,?,?,?,?,?)");
				ps.setString(1, rb.getFName());
				ps.setString(2,rb.getLName());
				ps.setString(3, rb.getMail());
				ps.setLong(4, rb.getPhNo());
				ps.setString(5, rb.getUName());
				ps.setString(6, rb.getPWord());
				
				int k  = ps.executeUpdate();
				if(k==1){
					pw.println("User registration successfully....!!!");
					RequestDispatcher rd = req.getRequestDispatcher("userlogin.html");
					rd.include(req, res);
				}
			}catch(Exception e){ }
		}
	}
}