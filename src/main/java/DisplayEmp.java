import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/displayemp")
public class DisplayEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
       
   public void init() {
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "purna1234");
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employee1");
			PrintWriter out = response.getWriter();
			
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>");
			out.println("Id");
			out.print("</th>");
			out.print("<th>");
			out.println("Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Age");
			out.print("</th>");
			out.print("<th>");
			out.println("Salary");
			out.print("</th>");
			out.print("<th>");
			out.println("Designation");
			out.print("</th>");
			out.print("</tr>");
			out.print("</table>");
			
			while (resultSet.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.print(resultSet.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(3));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(4));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(5));
				out.println("</td>");
				out.println("</tr>");
				out.println("</br>");
				out.println("</br>");
				out.println("<a href=\"http://localhost:8080/Assign1/home.html\" style= \"color: red;\r\n"
						+ "  background-color: transparent;\r\n"
						+ "  text-decoration: underline;\">Homepage</a>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

