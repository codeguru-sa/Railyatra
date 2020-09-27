package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class UserViewProfile extends HttpServlet{
			public Connection con;
			public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
				res.setContentType("text/html");
				PrintWriter pw = res.getWriter();
				HttpSession session = req.getSession();
				String uname = (String)session.getAttribute("uname");
						try{
							con = DBConnection.getCon();
							PreparedStatement ps = con.prepareStatement
									("select * from usertrainreg where uname=?");
							ps.setString(1, uname);
							ResultSet rs = ps.executeQuery();
							if(rs.next()){
								pw.println("<html><head><title>Trains</title>");
								pw.println("<style>thead,tbody{ font-size:40px; }");
								pw.println("body{background-color:#EAEDED;}")	;
								pw.println("a{ text-decoration:none; color:white; font-size:15px; }");
								pw.println("#table{ width:200px; font-size:15px; border-radius:8px; cursor-pointer:15px;"); 
							pw.println("border-radius:8px; background-color:#DD3737; }");
							pw.println("#tableback{ width:200px; font-size:15px;  border-radius:8px; cursor-pointer:15px;");
							pw.println("border-radius:8px; background-color:#16F1B3; }");
							pw.println("</style></head>");
								pw.println("<body>");
								pw.println("<div align='center'>");

								pw.println("<b><i><h2>Profile</h2></b></i><hr color='black'>");
								pw.println("<table id ='table' align='right'><thead><th><a href='logoutservlet'>Logout"
										+ "</a></th></thead></table>");
								
								pw.println("<table id='tableback' align='left'><thead><th><a href='userhome.html'>Home</a></th>"
										+ "</thead></table>");
								pw.println("<br><br><br><br>");
								pw.println("<table frame='box' rules='all' width='500' align='center'>");
								pw.println("<thead><th colspan='2'>Your Profile</th></thead>");
								pw.println("<tbody align='center'>");
								pw.println("<tr><td>First Name</td>"+"<td >" +rs.getString(1)+"</td></tr>");
								pw.println("<tr><td>Last Name</td> "+"<td>"+rs.getString(2)+"</td></tr>");
								pw.println("<tr><td>Mail-Id </td> "+"<td>"+rs.getString(3)+"</td></tr>");
								pw.println("<tr><td>Phone Number </td> "+"<td>"+rs.getLong(4)+"</td></tr>");
								pw.println("<tr><td>UserName </td> "+"<td>"+rs.getString(5)+"</td></tr>");
								pw.println("</tbody></table></div></body></html>");
						}
							
				}catch(Exception e){ }
						}
			}				