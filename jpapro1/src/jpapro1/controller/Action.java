package jpapro1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpapro1.model.Leads;
import jpapro1.services.LeadsServices;

/**
 * Servlet implementation class Action
 */
@WebServlet("/Action")
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Action() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@EJB
	private LeadsServices ls;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF//views//leads.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Leads l = new Leads();
		l.setName(name);
		ls.addLeads(l);
		
		List<Leads> allData=ls.searchLeads();
		PrintWriter w=response.getWriter();
		w.println("<table>"
				+ "<tr><th>ID</th><th></th><th>NAME</th></tr>"+ "</table>");
		for (int i = 0; i < allData.size(); i++) {
			
			w.println("<table>"
					+ "<tr><td>"+allData.get(i).getId()+"</td><td></td><td>"+allData.get(i).getName()+"</td></tr><br>"
					+ "</table>");
			
		}
	}

}
