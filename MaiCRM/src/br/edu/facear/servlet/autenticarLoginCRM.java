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

import br.edu.facear.model.Atendente;
import br.edu.facear.model.ManutencaoBusca;
import br.edu.facear.service.service_Atendente;
import br.edu.facear.service.service_ManutencaoBusca;

/**
 * Servlet implementation class autenticarLoginCRM
 */
@WebServlet("/autenticarLoginCRM")
public class autenticarLoginCRM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public autenticarLoginCRM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextpage = "/index.html";			
		
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		try {
			service_Atendente a = new service_Atendente();
			service_ManutencaoBusca m = new service_ManutencaoBusca();
			Atendente atendente = a.autenticarAtendente(cpf, senha);
			List<ManutencaoBusca> lista = new ArrayList<>();
			lista = m.listarManutencao();
			request.setAttribute("listamanutencao", lista);
			request.setAttribute("atendente", atendente);
			
			if(atendente!=null){
				nextpage = "/principal.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
		
	}

}
