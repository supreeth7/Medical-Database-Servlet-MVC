package com.medical.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAO dao;

	@Resource(name = "jdbc/medical_database")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			dao = new DAO(dataSource);
		} catch (Exception e) {
			throw new ServletException();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String form = request.getParameter("add");
			String form2 = request.getParameter("del");
			if (form == null) {
				form = "LIST";
			}

			if (form2 == null) {
				form2 = "LIST";
			}
			switch (form) {
			case "LIST":
				listMedicine(request, response);
				break;
			case "ADD":
				addMedicine(request, response);
				break;

			default:
				listMedicine(request, response);
			}

			switch (form2) {
			case "LIST":
				listMedicine(request, response);
				break;
			case "DEL":
				delMedicine(request, response);
				break;
			default:
				listMedicine(request, response);
			}
			listMedicine(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void delMedicine(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));

		dao.delMedicine(id);

	}

	private void addMedicine(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("medicine");
		String mfg = request.getParameter("mgf");
		String exp = request.getParameter("exp");
		String cost = request.getParameter("cost");

		Medicine m = new Medicine(name, mfg, exp, cost);

		dao.addMedicine(m);
	}

	public void listMedicine(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			List<Medicine> medicines = dao.getMedicines();
			request.setAttribute("MEDICINES", medicines);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/database-view.jsp");

			dispatcher.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
