package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Servico;
import br.edu.facear.service.service_Servico;

/**
 * Servlet implementation class logoutLoginCRM
 */
@WebServlet("/logoutLoginCRM")
public class logoutLoginCRM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutLoginCRM() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextpage = "/index.html";
		request.setAttribute("logout", null);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
		rd.forward(request, response);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextpage = "/index.html";
		request.setAttribute("logout", null);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
		rd.forward(request, response);	
	}

}
