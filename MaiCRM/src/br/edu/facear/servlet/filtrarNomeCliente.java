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

import br.edu.facear.model.ManutencaoBusca;
import br.edu.facear.service.service_ManutencaoBusca;

/**
 * Servlet implementation class filtrarNomeCliente
 */
@WebServlet("/filtrarNomeCliente")
public class filtrarNomeCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filtrarNomeCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextpage = "/principal.jsp";			
		String nome_cliente = request.getParameter("nome_cliente");
		
		try {
			service_ManutencaoBusca m = new service_ManutencaoBusca();
			List<ManutencaoBusca> lista = new ArrayList<>();
			lista = m.listarManutencaoNomeCliente(nome_cliente);
			request.setAttribute("listamanutencao", lista);
			
			if(lista!=null){
				RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
				rd.forward(request, response);
			}else {
				System.out.println("Lista vazia");
				RequestDispatcher rd = getServletContext().getRequestDispatcher(nextpage);
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
