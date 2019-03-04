package com.medical.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/medical_database")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection myCon = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			
			myCon = dataSource.getConnection();
			String q = "SELECT * FROM pharmacy";
			st = myCon.createStatement();
			rs = st.executeQuery(q);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("medicine");
				String mfg = rs.getString("mfg");
				String exp = rs.getString("exp");
				String cost = rs.getString("cost");

				out.println("<html><body>");
				out.println("This id is: " + id + "<br>");
				out.println("This name is: " + name + "<br>");
				out.println("This mfg is: " + mfg + "<br>");
				out.println("This exp is: " + exp + "<br>");
				out.println("This cost is: " + cost + "<br>");
				out.println("</body></html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
