package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Atendente;
import br.edu.facear.service.service_Atendente;

/**
 * Servlet implementation class alterarAtendentes
 */
@WebServlet("/alterarAtendentes")
public class alterarAtendentes extends redirecionamento {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterarAtendentes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nextpage = "/alterarAtendentes.jsp";
		
		try {
			Integer x = new Integer(Integer.parseInt(id));
			service_Atendente sa = new service_Atendente();
			Atendente aten = sa.ConsultaPorID(x);
			request.setAttribute("atendenteObjeto", aten);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
			rd.forward(request, response);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		String supervisor = request.getParameter("supervisor");
		
		try {
			service_Atendente sa = new service_Atendente();
			Atendente aten = new Atendente(Integer.parseInt(id), nome, cpf, senha, Integer.parseInt(supervisor));			
			sa.alterarAtendente(aten);
			
			PaginaPrincipal(request, response);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
